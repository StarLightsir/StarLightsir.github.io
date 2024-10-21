package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Lepuleibie;
import com.example.vo.LepuleibieVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface LepuleibieService extends IService<Lepuleibie> {
    Lepuleibie add(Lepuleibie lepuleibie);
    void delete(Long id);
    void update(Lepuleibie lepuleibie);
    Lepuleibie findById(Integer id);
    LepuleibieVo findPage(LepuleibieVo lepuleibieVo);
	
    void deleteList(List<Lepuleibie> list);
	
	
	List<Map<String, Object>> daochuexcel();
	//youxxianxci
}
