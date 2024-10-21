package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Aihaozhe;
import com.example.vo.AihaozheVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface AihaozheService extends IService<Aihaozhe> {
    Aihaozhe add(Aihaozhe aihaozhe);
    void delete(Long id);
    void update(Aihaozhe aihaozhe);
    Aihaozhe findById(Integer id);
    AihaozheVo findPage(AihaozheVo aihaozheVo);
	Aihaozhe login(Aihaozhe aihaozhe);
    void deleteList(List<Aihaozhe> list);
	
	void findaihaozheyonghuming(Aihaozhe aihaozhe);
	List<Map<String, Object>> daochuexcel();
	//youxxianxci
}
