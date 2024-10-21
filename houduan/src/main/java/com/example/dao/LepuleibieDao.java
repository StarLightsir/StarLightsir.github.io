package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Lepuleibie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface LepuleibieDao extends BaseMapper<Lepuleibie> {

@Select("select * from lepuleibie")
List<Map<String, Object>> daochuexcel();

//youxxianxci

//tonxgji1

}
