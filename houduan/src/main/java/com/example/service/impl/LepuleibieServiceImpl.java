package com.example.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.ResultCode;
import com.example.dao.*;
import com.example.entity.Lepuleibie;
import com.example.exception.CustomException;
import com.example.service.LepuleibieService;
import com.example.vo.LepuleibieVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("lepuleibieService")
public class LepuleibieServiceImpl extends ServiceImpl<LepuleibieDao, Lepuleibie> implements LepuleibieService {

    @Resource
    private LepuleibieDao lepuleibieDao;

    public Lepuleibie add(Lepuleibie lepuleibie) {
		
	   //youquchong1
        lepuleibie.setAddtime(new Date());
        lepuleibieDao.insert(lepuleibie);
        return lepuleibie;
    }
	
	
	
    public void delete(Long id) {
        lepuleibieDao.deleteById(id);
    }
	

    public void update(Lepuleibie lepuleibie) {
        //youquchong2
        lepuleibieDao.updateById(lepuleibie);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return lepuleibieDao.daochuexcel();
    }

    @Override
    public Lepuleibie findById(Integer id) {
        return lepuleibieDao.selectById(id);
    }

    public LepuleibieVo findPage(LepuleibieVo lepuleibieVo) {
        LambdaQueryWrapper<Lepuleibie> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(lepuleibieVo.getLeibiemingcheng()), Lepuleibie::getLeibiemingcheng,lepuleibieVo.getLeibiemingcheng());        wrapper.like(ObjectUtils.isNotEmpty(lepuleibieVo.getLeibiejieshao()), Lepuleibie::getLeibiejieshao,lepuleibieVo.getLeibiejieshao());        wrapper.like(ObjectUtils.isNotEmpty(lepuleibieVo.getShiyongleqi()), Lepuleibie::getShiyongleqi,lepuleibieVo.getShiyongleqi());        
        Page<Lepuleibie> page = new Page<>(lepuleibieVo.getCurrent(),lepuleibieVo.getCurrentNum());
        lepuleibieDao.selectPage(page,wrapper);
        List<Lepuleibie> lepuleibies = page.getRecords();
        lepuleibieVo.setList(lepuleibies);
        lepuleibieVo.setPages(page.getPages());
        lepuleibieVo.setTotal(page.getTotal());
        lepuleibieVo.setCurrent(page.getCurrent());
        lepuleibieVo.setCurrentNum(page.getSize());
        return lepuleibieVo;
    }

    @Override
    public void deleteList(List<Lepuleibie> list) {
        List<Integer> ids =  list.stream().map(Lepuleibie::getId).collect(Collectors.toList());
        lepuleibieDao.deleteBatchIds(ids);
    }
	
	
	
	
	
	//youxxianxci
}
