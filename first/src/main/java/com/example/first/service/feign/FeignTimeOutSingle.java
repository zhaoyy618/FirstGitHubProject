package com.example.first.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "timeOutSingle",url = "127.0.0.1:8080",path = "")
public interface FeignTimeOutSingle {
    //复制StudentController的查询所有学生的接口
    @GetMapping(value = "/")
    String getTimeOutSingle();
}
