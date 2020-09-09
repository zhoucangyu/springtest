package com.example.springtest.rzl.dao;

import com.example.springtest.rzl.bean.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DataDao {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "accessType", column = "access_type"),
            @Result(property = "time", column = "time"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "modifyTime", column = "modify_time"),
            @Result(property = "isChecked", column = "is_checked")
    })

    @Select("select * from t_access limit #{page},#{size}")
    public List<Data> findByPager(Map<String, Object> params);
    @Select("select count(1) from t_access")
    public long count();
}
