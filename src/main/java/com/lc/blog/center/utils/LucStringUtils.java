package com.lc.blog.center.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lucheng
 * @data: 2022/5/9 14:27
 * @version: 1.0
 */
public class LucStringUtils {
    public static List<Integer> parseToIntegerList(String str) {
        if(str == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (String s : str.split(",")) {
            list.add(Integer.valueOf(s));
        }
        return list;
    }

    public static  List<Long> parseToLongList(String str) {
        if(str == null) {
            return null;
        }
        List<Long> list = new ArrayList<>();
        for (String s : str.split(",")) {
            list.add(Long.valueOf(s));
        }
        return list;
    }
}
