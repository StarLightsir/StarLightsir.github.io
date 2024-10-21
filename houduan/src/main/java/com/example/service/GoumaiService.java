package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Goumai;
import com.example.vo.GoumaiVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface GoumaiService extends IService<Goumai> {
    Goumai add(Goumai goumai);
    void delete(Long id);
    void update(Goumai goumai);
    Goumai findById(Integer id);
    GoumaiVo findPage(GoumaiVo goumaiVo);
	
    void deleteList(List<Goumai> list);
	
	
	List<Map<String, Object>> daochuexcel();
	//youxxianxci
}
