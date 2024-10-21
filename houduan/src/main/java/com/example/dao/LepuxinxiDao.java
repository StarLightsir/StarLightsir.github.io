package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Lepuxinxi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface LepuxinxiDao extends BaseMapper<Lepuxinxi> {

@Select("select * from lepuxinxi")
List<Map<String, Object>> daochuexcel();

//youxxianxci

@Select("SELECT distinct(lepufenlei) as aa,count(id) as bb FROM lepuxinxi group by lepufenlei order by id")List<Map<String, Object>> lepuxinxi_tj_lepufenlei();@Select("SELECT distinct(chuangzuoren) as aa,count(id) as bb FROM lepuxinxi group by chuangzuoren order by id")List<Map<String, Object>> lepuxinxi_tj_chuangzuoren();//tonxgji1

}
