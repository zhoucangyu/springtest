package com.example.springtest.rzl.service;

import com.example.springtest.rzl.bean.Data;
import com.example.springtest.rzl.bean.Pager;
import com.example.springtest.rzl.dao.DataDao;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class DataService {
    @Resource
    DataDao dataDao;

    public Pager<Data> findByPager(int page, int size) {
        Map<String, Object> params = new HashMap<>();
        params.put("page", (page - 1) * size);
        params.put("size", size);
        Pager<Data> pager = new Pager<>();
        List<Data> list = dataDao.findByPager(params);
        pager.setRows(list);
        pager.setTotal(dataDao.count());
        return pager;
    }
}
