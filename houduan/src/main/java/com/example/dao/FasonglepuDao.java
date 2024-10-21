package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Fasonglepu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface FasonglepuDao extends BaseMapper<Fasonglepu> {

@Select("select * from fasonglepu")
List<Map<String, Object>> daochuexcel();

//youxxianxci

//tonxgji1

}
