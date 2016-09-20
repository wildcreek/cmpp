package com.killxdcj;

import com.killxdcj.echo.EchoClient;
import com.killxdcj.test.Test;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by caojianhua on 16/9/7.
 */
public class PackageEcho  extends ChannelInboundHandlerAdapter{
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        super.channelRead(ctx, msg);
        if (msg instanceof ByteBuf) {
            ByteBuf data = (ByteBuf)msg;
            System.out.println("len:" + data.readInt());
            System.out.println("cmd:" + (data.readInt() & 0xFFFF));
            System.out.println("seq:" + data.readInt());
            System.out.println("stat:" + data.readByte());
            byte[] ismg = new byte[16];
            data.readBytes(ismg, 0, 16);
            System.out.println("ismg:" + new String(ismg));
            System.out.println("ver:" + data.readByte());
        } else {

        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        ByteBuf firstMessage = Unpooled.buffer(100);
//        for (int i = 0; i < firstMessage.capacity(); i ++) {
//            firstMessage.writeByte((byte) i);
//        }
//        ctx.writeAndFlush(firstMessage);

        Test test = new Test();
        byte[] data = test.buildCmppConnect();
        ByteBuf firstMessage = Unpooled.buffer(data.length);
        firstMessage.writeBytes(data);
        ctx.writeAndFlush(firstMessage);
        System.out.println("channel active");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }
}
