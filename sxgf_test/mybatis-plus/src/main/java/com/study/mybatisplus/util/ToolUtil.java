package com.study.mybatisplus.util;

import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;
import java.util.Random;

public class ToolUtil {

    /**
     * 获取随机字符,自定义长度
     */
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * md5加密(加盐)
     */
    public static String md5Hex(String password, String salt)  {
            return MD5Util.encrypt(password + salt);
    }
}
