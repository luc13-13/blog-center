package com.lc.blog.center.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "uid-center")
public interface UidCenter {

    @GetMapping("/uid/nextId")
    long nextId();
}
