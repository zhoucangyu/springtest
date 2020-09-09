package com.example.springtest.rzl.controller;

import com.alibaba.fastjson.JSON;
import com.example.springtest.rzl.bean.Data;
import com.example.springtest.rzl.bean.Result;
import com.example.springtest.rzl.bean.Pager;
import com.example.springtest.rzl.service.DataService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("page")
public class DataController {
    @Resource
    DataService dataService;

    @GetMapping("/at")
    public String getPage(@RequestParam int page, @RequestParam int size) {

        Pager<Data> pager = dataService.findByPager(page, size);

        Result result = new Result();
        result.setCode(Result.SUCCESS);
        result.setMessage("SUCCESS");
        result.setData(pager.getRows().get(0).getId());

        return JSON.toJSONString(result);

    }
}
