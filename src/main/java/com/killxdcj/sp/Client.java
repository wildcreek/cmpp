package com.killxdcj.sp;

import com.killxdcj.cmpp.meta.CmppActiveTestMeta;
import com.killxdcj.cmpp.meta.CmppConnectMeta;
import com.killxdcj.cmpp.packet.CmppPacket;
import com.killxdcj.cmpp.packet.CmppPacketType;
import com.killxdcj.sp.callback.CmppSpCallback;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: caojianhua
 * Date: 16/9/18
 * Time: 17:43
 */
public class Client extends ChannelInboundHandlerAdapter {
    private String host;
    private int port;
    private String sourceAddr;
    private String sharedSecret;

    private Channel channel;
    private Bootstrap b;
    EventLoopGroup eventLoopGroup;

    private Map<CmppPacketType, List<CmppSpCallback>> callbackTable;

    public Client(String host, int port, String sourceAddr, String sharedSecret) {
        this.host = host;
        this.port = port;
        this.sourceAddr = sourceAddr;
        this.sharedSecret = sharedSecret;

        callbackTable = new HashMap<CmppPacketType, List<CmppSpCallback>>();
    }

    public void registCallback(CmppPacketType type, CmppSpCallback callback) {
        synchronized (callbackTable) {
            List<CmppSpCallback> callbacks = callbackTable.get(type);
            if (callbacks == null) {
                callbacks = new ArrayList<CmppSpCallback>();
            }

            if (callbacks.indexOf(callback) == -1) {
                callbacks.add(callback);
            }

            callbackTable.put(type, callbacks);
        }
    }

    public void unregistCallback(CmppPacketType type, CmppSpCallback callback) {
        synchronized (callbackTable) {
            List<CmppSpCallback> callbacks = callbackTable.get(type);
            if (callbacks == null) {
                return;
            }

            if (callbacks.indexOf(callback) == -1) {
                return;
            }

            callbacks.remove(callback);
        }
    }

    public void start() {
        try {
            this.eventLoopGroup = new NioEventLoopGroup();
            b = new Bootstrap();
            b.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            p.addLast(new LengthFieldBasedFrameDecoder(1000, 0, 4, -4, 0), Client.this);
                        }
                    });

            this.channel = b.connect(host, port).sync().channel();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("start exception:" + e.toString());
        }

        System.out.println("client started");
    }

    public void stop() {
        channel.close();
        eventLoopGroup.shutdownGracefully();
    }

    public void sendMessage() {
//        channel.writeAndFlush()
        CmppActiveTestMeta activeTestMeta = new CmppActiveTestMeta();
        byte[] data = CmppPacketType.CMPP_ACTIVE_TEST.getCodec().code(activeTestMeta);
        ByteBuf buf = Unpooled.buffer(data.length);
        buf.writeBytes(data);
        channel.writeAndFlush(buf);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        CmppConnectMeta connectMeta = new CmppConnectMeta();
        connectMeta.setSourceAddr(this.sourceAddr);
        connectMeta.setSharedSecret(this.sharedSecret);
        connectMeta.setVersion(0x30);

        byte[] data = CmppPacketType.CMPP_CONNECT.getCodec().code(connectMeta);
        ByteBuf buf = Unpooled.buffer(data.length);
        buf.writeBytes(data);
        ctx.writeAndFlush(buf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof ByteBuf) {
            ByteBuf data = (ByteBuf) msg;
            long total_length = data.readUnsignedInt();
            if (total_length != data.capacity()) {
                System.out.println("读取到消息头Total_Length不匹配,total_length=" + total_length);
                return;
            }
            long command_id = data.readUnsignedInt();
            long sequence_id = data.readUnsignedInt();
            System.out.println("读取到消息头total_length=" + total_length + ",command_id=" + Long.toHexString(command_id) + ",sequence_id=" + sequence_id);
            byte[] dataByte = new byte[data.capacity()];
            data.readerIndex(0);
            data.readBytes(dataByte);
            CmppPacket packet = (CmppPacket) CmppPacketType.parseCommand(command_id).getCodec().decode(dataByte);
            dispatchPacket(packet);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    private void dispatchPacket(CmppPacket packet) {
        System.out.println("读取到消息体" + packet.toString());

        synchronized (callbackTable) {
            CmppPacketType packetType = CmppPacketType.parseCommand(packet.getCommandId());
            List<CmppSpCallback> callbacks = callbackTable.get(packetType);
            for (CmppSpCallback callback : callbacks) {
                callback.onPacket(packet);
            }
        }
    }
}
