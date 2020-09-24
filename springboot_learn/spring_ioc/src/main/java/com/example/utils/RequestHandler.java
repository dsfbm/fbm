package com.example.utils;

import javax.servlet.http.HttpServletRequest;

public class RequestHandler {
//    threadlocal而是一个线程内部的存储类，可以在指定线程内存储数据，数据存储以后，只有指定线程可以得到存储数据
    private static final ThreadLocal<HttpServletRequest> REQUEST_DATA = new ThreadLocal<>();
    public static void put(HttpServletRequest request){
        REQUEST_DATA.set(request);

    }
    public static HttpServletRequest get(){
        return REQUEST_DATA.get();
    }
    public static void remove() {
        REQUEST_DATA.remove();

    }

}
