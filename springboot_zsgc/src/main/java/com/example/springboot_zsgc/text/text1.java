package com.example.springboot_zsgc.text;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class text1 {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("123",8080);
        OutputStream is=socket.getOutputStream();
        byte[] bytes=new byte[1024];
//        int len=is.read(bytes);
    }

}
