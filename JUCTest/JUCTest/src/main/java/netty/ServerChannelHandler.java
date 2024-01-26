package netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @ClassName: ServerChannelHandler
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/11 17:29
 * @Version: V1.0
 */
public class ServerChannelHandler  extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf)msg;
        System.out.println("Server accept: "+in.toString(CharsetUtil.UTF_8));
        ctx.writeAndFlush(in);
        //ctx.close();//短连接
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //出现异常
        cause.printStackTrace();
        ctx.close();
    }
}
