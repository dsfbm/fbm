package com.server.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.logging.Logger;

public class TimeClientHandler extends ChannelHandlerAdapter {

    private static final Logger logger = Logger.getLogger(TimeClientHandler.class.getName());
    private int counter;
    private byte[] req;


    TimeClientHandler() {
        req = ("Hello World" + System.getProperty("line.separator")).getBytes();
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.warning("error:" + cause.getMessage());
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf message = null;
        for (int i = 0; i < 100; i++) {
            message = Unpooled.buffer(req.length);
            message.writeBytes(req);
            ctx.writeAndFlush(message);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //没有使用回车换行解码器和字符串解码器
        // ByteBuf byteBuf = (ByteBuf) msg;
        // byte[] req = new byte[byteBuf.readableBytes()];
        // byteBuf.readBytes(req);
        //  String body = new String(req, "utf-8");

        String body = (String) msg;
        System.out.println("now:" + body + "; count:" + ++counter);
    }
}
