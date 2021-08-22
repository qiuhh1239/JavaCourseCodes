package com.geektime.week03Code.filter;

import io.github.kimmking.gateway.filter.HttpRequestFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;

public class HttpInboundHandlerProxyBizFilter extends ChannelInboundHandlerAdapter {

	 private HttpRequestFilter filter = new ProxyBizFilter();
	 
	  @Override
	    public void channelRead(ChannelHandlerContext ctx, Object msg) {
		  	System.out.println("ProxyBizFilter.........已执行");
	        try {
	            FullHttpRequest fullRequest = (FullHttpRequest) msg;
	            filter.filter(fullRequest, ctx);
	    
	            //消息交给下一个过滤器使用
	            super.channelRead(ctx , msg);
	        } catch(Exception e) {
	            e.printStackTrace();
	        } 
	    }


}
