package com.lc.blog.center.utils;

import com.lc.blog.center.web.request.PageResult;

/**
 * @author: lucheng
 * @data: 2022/5/4 17:13
 * @version: 1.0
 */
public class PageUtils {
    public static boolean isEmpty(PageResult pageResult) {
        return pageResult == null || pageResult.getRecordList() == null || pageResult.getRecordList().isEmpty();
    }
}
