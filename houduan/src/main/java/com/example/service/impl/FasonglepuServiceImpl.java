package com.example.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.ResultCode;
import com.example.dao.*;
import com.example.entity.Fasonglepu;
import com.example.exception.CustomException;
import com.example.service.FasonglepuService;
import com.example.vo.FasonglepuVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("fasonglepuService")
public class FasonglepuServiceImpl extends ServiceImpl<FasonglepuDao, Fasonglepu> implements FasonglepuService {

    @Resource
    private FasonglepuDao fasonglepuDao;

    public Fasonglepu add(Fasonglepu fasonglepu) {
		
	   //youquchong1
        fasonglepu.setAddtime(new Date());
        fasonglepuDao.insert(fasonglepu);
        return fasonglepu;
    }
	
	
	
    public void delete(Long id) {
        fasonglepuDao.deleteById(id);
    }
	

    public void update(Fasonglepu fasonglepu) {
        //youquchong2
        fasonglepuDao.updateById(fasonglepu);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return fasonglepuDao.daochuexcel();
    }

    @Override
    public Fasonglepu findById(Integer id) {
        return fasonglepuDao.selectById(id);
    }

    public FasonglepuVo findPage(FasonglepuVo fasonglepuVo) {
        LambdaQueryWrapper<Fasonglepu> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(fasonglepuVo.getLepubianhao()), Fasonglepu::getLepubianhao,fasonglepuVo.getLepubianhao());        wrapper.like(ObjectUtils.isNotEmpty(fasonglepuVo.getLepumingcheng()), Fasonglepu::getLepumingcheng,fasonglepuVo.getLepumingcheng());        wrapper.like(ObjectUtils.isNotEmpty(fasonglepuVo.getLepuleibie()), Fasonglepu::getLepuleibie,fasonglepuVo.getLepuleibie());        wrapper.like(ObjectUtils.isNotEmpty(fasonglepuVo.getChuangzuoren()), Fasonglepu::getChuangzuoren,fasonglepuVo.getChuangzuoren());        wrapper.like(ObjectUtils.isNotEmpty(fasonglepuVo.getGoumairen()), Fasonglepu::getGoumairen,fasonglepuVo.getGoumairen());        wrapper.like(ObjectUtils.isNotEmpty(fasonglepuVo.getLepuchuansong()), Fasonglepu::getLepuchuansong,fasonglepuVo.getLepuchuansong());        
        Page<Fasonglepu> page = new Page<>(fasonglepuVo.getCurrent(),fasonglepuVo.getCurrentNum());
        fasonglepuDao.selectPage(page,wrapper);
        List<Fasonglepu> fasonglepus = page.getRecords();
        fasonglepuVo.setList(fasonglepus);
        fasonglepuVo.setPages(page.getPages());
        fasonglepuVo.setTotal(page.getTotal());
        fasonglepuVo.setCurrent(page.getCurrent());
        fasonglepuVo.setCurrentNum(page.getSize());
        return fasonglepuVo;
    }

    @Override
    public void deleteList(List<Fasonglepu> list) {
        List<Integer> ids =  list.stream().map(Fasonglepu::getId).collect(Collectors.toList());
        fasonglepuDao.deleteBatchIds(ids);
    }
	
	
	
	
	
	//youxxianxci
}
