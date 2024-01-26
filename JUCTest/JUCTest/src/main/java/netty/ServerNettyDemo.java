package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @ClassName: ServerNettyDemo
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/11 16:04
 * @Version: V1.0
 */
public class ServerNettyDemo {
    public static void main(String[] args) throws InterruptedException {
        ServerBootstrap sbs = new ServerBootstrap();
        EventLoopGroup elg = new NioEventLoopGroup();

        try {
            sbs.group(elg).channel(NioServerSocketChannel.class).localAddress(9999).childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel nioSocketChannel) throws Exception {
                    nioSocketChannel.pipeline().addLast(new ServerChannelHandler());
                }
            });
            ChannelFuture sync = sbs.bind().sync();
            sync.channel().closeFuture().sync();
        }finally {
            elg.shutdownGracefully().sync();

        }

    }
}
