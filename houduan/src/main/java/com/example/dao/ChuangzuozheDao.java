package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Chuangzuozhe;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ChuangzuozheDao extends BaseMapper<Chuangzuozhe> {

@Select("select * from chuangzuozhe")
List<Map<String, Object>> daochuexcel();

//youxxianxci

//tonxgji1

}
