package com.example.first.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "第一个")
@RestController
public class FirstController {

    @ApiOperation(value = "上传文件接口",notes = "上传文件接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "上传人")
    })
    @GetMapping("/")
    public String first() throws InterruptedException {
        Thread.sleep(2000);
        return "index";
    }
}
