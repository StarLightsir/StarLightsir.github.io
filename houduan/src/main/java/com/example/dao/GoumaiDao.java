package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Goumai;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoumaiDao extends BaseMapper<Goumai> {

@Select("select * from goumai")
List<Map<String, Object>> daochuexcel();

//youxxianxci

//tonxgji1

}
