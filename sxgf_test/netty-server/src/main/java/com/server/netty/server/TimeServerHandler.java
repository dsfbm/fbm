package com.server.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

public class TimeServerHandler extends ChannelHandlerAdapter {

    private int counter;

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //没有使用回车换行解码器和字符串解码器
        // ByteBuf byteBuf = (ByteBuf)msg;
        // byte[] req = new byte[byteBuf.readableBytes()];
        // byteBuf.readBytes(req);
        // String body = new String(req,"utf-8").substring(0,req.length-System.getProperty("line.separator").length());

        String body = (String) msg;
        System.out.println("receive order:" + body + "; count:" + ++counter);
        String currentTime = "Hello World".equals(body) ? new Date(System.currentTimeMillis()).toString() : "bad order";
        currentTime = currentTime + System.getProperty("line.separator");
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.writeAndFlush(resp);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
