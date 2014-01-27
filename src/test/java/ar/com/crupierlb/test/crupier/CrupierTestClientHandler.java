package ar.com.crupierlb.test.crupier;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * Listing 2.6 of <i>Netty in Action</i>
 * 
 * @author <a href="mailto:nmaurer@redhat.com">Norman Maurer</a>
 */
@Sharable
public class CrupierTestClientHandler extends SimpleChannelInboundHandler<ByteBuf>
{

	@Override
	public void channelActive(ChannelHandlerContext ctx)
	{
		ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!", CharsetUtil.UTF_8));
	}

	@Override
	public void channelRead0(ChannelHandlerContext ctx, ByteBuf in)
	{
		System.out.println("Client received: " + ByteBufUtil.hexDump(in.readBytes(in.readableBytes())));
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
	{
		cause.printStackTrace();
		ctx.close();
	}
}
