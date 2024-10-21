package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Fasonglepu;
import com.example.vo.FasonglepuVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface FasonglepuService extends IService<Fasonglepu> {
    Fasonglepu add(Fasonglepu fasonglepu);
    void delete(Long id);
    void update(Fasonglepu fasonglepu);
    Fasonglepu findById(Integer id);
    FasonglepuVo findPage(FasonglepuVo fasonglepuVo);
	
    void deleteList(List<Fasonglepu> list);
	
	
	List<Map<String, Object>> daochuexcel();
	//youxxianxci
}
