package com.baizhi.cmfz.util;

import java.util.Random;
/**
*@Author zhangshaojie
*@Description 盐 方法
*@Time  2018/7/4 14:23
*/
public class SaltUtil {

    /**
    *@Author  zhangshaojie
    *@Description  获取随机盐
    *@Time      2018/7/4 14:23
    *@Param  无参
    *@Exception
    */
    public static String getSalt() {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i <6; i++) {
            sb.append(chars[new Random().nextInt(chars.length)]);
        }
        return sb.toString();
    }
}
