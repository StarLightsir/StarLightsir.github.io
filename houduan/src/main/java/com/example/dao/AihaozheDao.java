package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Aihaozhe;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface AihaozheDao extends BaseMapper<Aihaozhe> {

@Select("select * from aihaozhe")
List<Map<String, Object>> daochuexcel();

//youxxianxci

//tonxgji1

}
