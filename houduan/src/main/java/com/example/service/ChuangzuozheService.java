package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Chuangzuozhe;
import com.example.vo.ChuangzuozheVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface ChuangzuozheService extends IService<Chuangzuozhe> {
    Chuangzuozhe add(Chuangzuozhe chuangzuozhe);
    void delete(Long id);
    void update(Chuangzuozhe chuangzuozhe);
    Chuangzuozhe findById(Integer id);
    ChuangzuozheVo findPage(ChuangzuozheVo chuangzuozheVo);
	Chuangzuozhe login(Chuangzuozhe chuangzuozhe);
    void deleteList(List<Chuangzuozhe> list);
	
	void findchuangzuozhezhanghao(Chuangzuozhe chuangzuozhe);
	List<Map<String, Object>> daochuexcel();
	//youxxianxci
}
