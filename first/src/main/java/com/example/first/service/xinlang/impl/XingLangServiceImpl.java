package com.example.first.service.xinlang.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.example.first.entity.GPEntity;
import com.example.first.service.feign.GupiaoFeignService;
import com.example.first.service.xinlang.XingLangService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@Service
public class XingLangServiceImpl implements XingLangService  {

    @Resource
    private GupiaoFeignService gupiaoFeignService;

    @Override
    public Map getXingLang(String id, Integer time) {
        String no = gupiaoFeignService.getKLineData(id, 5, "no", time);
        ArrayList<GPEntity> userList  = JSON.parseObject(no, new TypeReference<ArrayList<GPEntity>>(){});
        HashMap result = new HashMap<>();
        ArrayList times = new ArrayList(1000);
        ArrayList volumes = new ArrayList(1000);
        if(!CollectionUtils.isEmpty(userList)){
            userList.forEach(item->{
                volumes.add(item.getVolume());
                times.add(item.getDay());
            });
        }
        result.put("date",times);
        result.put("volume",volumes);
        return result;
    }
}
