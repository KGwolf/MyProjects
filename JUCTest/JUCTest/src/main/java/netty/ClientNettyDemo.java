package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @ClassName: ClientNettyDemo
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/11 16:04
 * @Version: V1.0
 */
public class ClientNettyDemo {
    public static void main(String[] args) throws InterruptedException {
        Bootstrap sbs = new Bootstrap();
        EventLoopGroup elg = new NioEventLoopGroup();
        try {
            sbs.group(elg).channel(NioSocketChannel.class).remoteAddress("127.0.0.1",9999).handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new ClientChannelHandler());
                }
            });
            ChannelFuture sync = sbs.connect().sync();
            sync.channel().closeFuture().sync();
        }finally {
            elg.shutdownGracefully().sync();
        }

    }
}
