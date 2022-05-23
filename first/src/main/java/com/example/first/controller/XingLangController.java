package com.example.first.controller;

import com.example.first.service.xinlang.XingLangService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@Api(tags = "第一个")
@RestController
public class XingLangController {

    @Resource
    private XingLangService xingLangService;

    @ApiOperation(value = "上传文件接口",notes = "上传文件接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "上传人")
    })
    @GetMapping("/xingLang")
    public Map xingLang(String id, Integer date){
        Map data = xingLangService.getXingLang("sz002061", 120);
        return data;
    }
}
