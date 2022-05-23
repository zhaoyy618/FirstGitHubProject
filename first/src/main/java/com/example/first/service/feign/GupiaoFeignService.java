package com.example.first.service.feign;

import com.alibaba.fastjson.JSONObject;
import com.example.first.entity.GPEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "XingLang",url = "https://money.finance.sina.com.cn",path = "/quotes_service/api/json_v2.php")
public interface GupiaoFeignService {
    //复制StudentController的查询所有学生的接口
    @GetMapping(value = "/CN_MarketData.getKLineData")
    String getKLineData(@RequestParam String symbol, @RequestParam int scale, @RequestParam String ma,
                            @RequestParam int datalen);

}
