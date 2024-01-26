package netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.io.Serializable;

/**
 * @ClassName: ClientChannelHandler
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/11 17:31
 * @Version: V1.0
 */
public class ClientChannelHandler extends SimpleChannelInboundHandler implements Serializable {

    /*channel活跃后，做业务处理*/
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer(
                "Hello,Netty",CharsetUtil.UTF_8));
    }
    /*读取到网络数据后进行业务处理*/
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        System.out.println("client Accept"+((ByteBuf)o).toString(CharsetUtil.UTF_8));
        //ctx.close();
        channelHandlerContext.close();
    }
}
