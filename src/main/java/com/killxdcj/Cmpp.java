package com.killxdcj;

import com.killxdcj.test.PackageOut;
import com.killxdcj.test.Test;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * Created by caojianhua on 16/9/7.
 */
public class Cmpp {
    public static void main(String args[]) {
        System.out.println("xxx");
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
             .channel(NioSocketChannel.class)
             .option(ChannelOption.TCP_NODELAY, true)
             .handler(new ChannelInitializer<SocketChannel>() {

                 protected void initChannel(SocketChannel ch) throws Exception {
                     ChannelPipeline p = ch.pipeline();
                     p.addLast(
                             new LengthFieldBasedFrameDecoder(1000, 0, 4, -4, 0),
                             new PackageEcho()
                     );
                 }
             });

//            b.connect("127.0.0.1", 9000).sync();//.channel().closeFuture().sync();
            Test test = new Test();
            Channel channel = b.connect("115.231.168.137", 8855).sync().channel();
            Thread.sleep(5000);
            channel.close();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}
