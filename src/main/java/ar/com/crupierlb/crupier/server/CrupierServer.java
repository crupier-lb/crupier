package ar.com.crupierlb.crupier.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 */
public class CrupierServer
{

	private final int port;

	public CrupierServer(int port)
	{
		this.port = port;
	}

	public void start() throws Exception
	{
		NioEventLoopGroup group = new NioEventLoopGroup();
		try
		{
			ServerBootstrap b = new ServerBootstrap();
			b.group(group).channel(NioServerSocketChannel.class).localAddress(new InetSocketAddress(port)).childHandler(new ChannelInitializer<SocketChannel>()
			{
				@Override
				public void initChannel(SocketChannel ch) throws Exception
				{
					ch.pipeline().addLast(new CrupierServerHandler());
				}
			});

			ChannelFuture f = b.bind().sync();
			System.out.println(CrupierServer.class.getName() + " started and listen on " + f.channel().localAddress());
			f.channel().closeFuture().sync();
		}
		finally
		{
			group.shutdownGracefully().sync();
		}
	}

}
