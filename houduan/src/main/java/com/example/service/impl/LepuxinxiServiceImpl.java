package com.example.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.ResultCode;
import com.example.dao.*;
import com.example.entity.Lepuxinxi;
import com.example.exception.CustomException;
import com.example.service.LepuxinxiService;
import com.example.vo.LepuxinxiVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("lepuxinxiService")
public class LepuxinxiServiceImpl extends ServiceImpl<LepuxinxiDao, Lepuxinxi> implements LepuxinxiService {

    @Resource
    private LepuxinxiDao lepuxinxiDao;

    public Lepuxinxi add(Lepuxinxi lepuxinxi) {
		
	   //youquchong1
        lepuxinxi.setAddtime(new Date());
        lepuxinxiDao.insert(lepuxinxi);
        return lepuxinxi;
    }
	
	@Override    public List<Map<String,Object>> lepuxinxi_tj_lepufenlei() {    List<Map<String,Object>> returnMap = lepuxinxiDao.lepuxinxi_tj_lepufenlei();    return returnMap;    }    @Override    public List<Map<String,Object>> lepuxinxi_tj_chuangzuoren() {    List<Map<String,Object>> returnMap = lepuxinxiDao.lepuxinxi_tj_chuangzuoren();    return returnMap;    }    
	
    public void delete(Long id) {
        lepuxinxiDao.deleteById(id);
    }
	

    public void update(Lepuxinxi lepuxinxi) {
        //youquchong2
        lepuxinxiDao.updateById(lepuxinxi);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return lepuxinxiDao.daochuexcel();
    }

    @Override
    public Lepuxinxi findById(Integer id) {
        return lepuxinxiDao.selectById(id);
    }

    public LepuxinxiVo findPage(LepuxinxiVo lepuxinxiVo) {
        LambdaQueryWrapper<Lepuxinxi> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(lepuxinxiVo.getLepubianhao()), Lepuxinxi::getLepubianhao,lepuxinxiVo.getLepubianhao());        wrapper.like(ObjectUtils.isNotEmpty(lepuxinxiVo.getLepumingcheng()), Lepuxinxi::getLepumingcheng,lepuxinxiVo.getLepumingcheng());        wrapper.like(ObjectUtils.isNotEmpty(lepuxinxiVo.getLepufenlei()), Lepuxinxi::getLepufenlei,lepuxinxiVo.getLepufenlei());        wrapper.like(ObjectUtils.isNotEmpty(lepuxinxiVo.getLeqi()), Lepuxinxi::getLeqi,lepuxinxiVo.getLeqi());        wrapper.like(ObjectUtils.isNotEmpty(lepuxinxiVo.getLepujieshao()), Lepuxinxi::getLepujieshao,lepuxinxiVo.getLepujieshao());        wrapper.like(ObjectUtils.isNotEmpty(lepuxinxiVo.getJiage()), Lepuxinxi::getJiage,lepuxinxiVo.getJiage());        wrapper.like(ObjectUtils.isNotEmpty(lepuxinxiVo.getLeputu()), Lepuxinxi::getLeputu,lepuxinxiVo.getLeputu());        wrapper.like(ObjectUtils.isNotEmpty(lepuxinxiVo.getChuangzuoren()), Lepuxinxi::getChuangzuoren,lepuxinxiVo.getChuangzuoren());        
        Page<Lepuxinxi> page = new Page<>(lepuxinxiVo.getCurrent(),lepuxinxiVo.getCurrentNum());
        lepuxinxiDao.selectPage(page,wrapper);
        List<Lepuxinxi> lepuxinxis = page.getRecords();
        lepuxinxiVo.setList(lepuxinxis);
        lepuxinxiVo.setPages(page.getPages());
        lepuxinxiVo.setTotal(page.getTotal());
        lepuxinxiVo.setCurrent(page.getCurrent());
        lepuxinxiVo.setCurrentNum(page.getSize());
        return lepuxinxiVo;
    }

    @Override
    public void deleteList(List<Lepuxinxi> list) {
        List<Integer> ids =  list.stream().map(Lepuxinxi::getId).collect(Collectors.toList());
        lepuxinxiDao.deleteBatchIds(ids);
    }
	
	
	
	
	
	//youxxianxci
}
