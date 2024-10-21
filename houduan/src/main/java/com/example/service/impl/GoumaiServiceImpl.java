package com.example.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.ResultCode;
import com.example.dao.*;
import com.example.entity.Goumai;
import com.example.exception.CustomException;
import com.example.service.GoumaiService;
import com.example.vo.GoumaiVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("goumaiService")
public class GoumaiServiceImpl extends ServiceImpl<GoumaiDao, Goumai> implements GoumaiService {

    @Resource
    private GoumaiDao goumaiDao;

    public Goumai add(Goumai goumai) {
		
	   //youquchong1
        goumai.setAddtime(new Date());
        goumaiDao.insert(goumai);
        return goumai;
    }
	
	
	
    public void delete(Long id) {
        goumaiDao.deleteById(id);
    }
	

    public void update(Goumai goumai) {
        //youquchong2
        goumaiDao.updateById(goumai);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return goumaiDao.daochuexcel();
    }

    @Override
    public Goumai findById(Integer id) {
        return goumaiDao.selectById(id);
    }

    public GoumaiVo findPage(GoumaiVo goumaiVo) {
        LambdaQueryWrapper<Goumai> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(goumaiVo.getLepubianhao()), Goumai::getLepubianhao,goumaiVo.getLepubianhao());        wrapper.like(ObjectUtils.isNotEmpty(goumaiVo.getLepumingcheng()), Goumai::getLepumingcheng,goumaiVo.getLepumingcheng());        wrapper.like(ObjectUtils.isNotEmpty(goumaiVo.getLepuleibie()), Goumai::getLepuleibie,goumaiVo.getLepuleibie());        wrapper.like(ObjectUtils.isNotEmpty(goumaiVo.getJiage()), Goumai::getJiage,goumaiVo.getJiage());        wrapper.like(ObjectUtils.isNotEmpty(goumaiVo.getChuangzuoren()), Goumai::getChuangzuoren,goumaiVo.getChuangzuoren());        wrapper.like(ObjectUtils.isNotEmpty(goumaiVo.getGoumairen()), Goumai::getGoumairen,goumaiVo.getGoumairen());        wrapper.eq(ObjectUtils.isNotEmpty(goumaiVo.getIssh()), Goumai::getIssh,goumaiVo.getIssh());        
        Page<Goumai> page = new Page<>(goumaiVo.getCurrent(),goumaiVo.getCurrentNum());
        goumaiDao.selectPage(page,wrapper);
        List<Goumai> goumais = page.getRecords();
        goumaiVo.setList(goumais);
        goumaiVo.setPages(page.getPages());
        goumaiVo.setTotal(page.getTotal());
        goumaiVo.setCurrent(page.getCurrent());
        goumaiVo.setCurrentNum(page.getSize());
        return goumaiVo;
    }

    @Override
    public void deleteList(List<Goumai> list) {
        List<Integer> ids =  list.stream().map(Goumai::getId).collect(Collectors.toList());
        goumaiDao.deleteBatchIds(ids);
    }
	
	
	
	
	
	//youxxianxci
}
