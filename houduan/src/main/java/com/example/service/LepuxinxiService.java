package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Lepuxinxi;
import com.example.vo.LepuxinxiVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface LepuxinxiService extends IService<Lepuxinxi> {
    Lepuxinxi add(Lepuxinxi lepuxinxi);
    void delete(Long id);
    void update(Lepuxinxi lepuxinxi);
    Lepuxinxi findById(Integer id);
    LepuxinxiVo findPage(LepuxinxiVo lepuxinxiVo);
	
    void deleteList(List<Lepuxinxi> list);
	List<Map<String,Object>> lepuxinxi_tj_lepufenlei();    List<Map<String,Object>> lepuxinxi_tj_chuangzuoren();    
	
	List<Map<String, Object>> daochuexcel();
	//youxxianxci
}
