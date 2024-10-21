package com.example.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.ResultCode;
import com.example.dao.*;
import com.example.entity.Chuangzuozhe;
import com.example.exception.CustomException;
import com.example.service.ChuangzuozheService;
import com.example.vo.ChuangzuozheVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("chuangzuozheService")
public class ChuangzuozheServiceImpl extends ServiceImpl<ChuangzuozheDao, Chuangzuozhe> implements ChuangzuozheService {

    @Resource
    private ChuangzuozheDao chuangzuozheDao;

    public Chuangzuozhe add(Chuangzuozhe chuangzuozhe) {
		if(chuangzuozhe.getMima()==null) {chuangzuozhe.setMima(SecureUtil.md5("001"));}else {chuangzuozhe.setMima(SecureUtil.md5(chuangzuozhe.getMima())); }
	    LambdaQueryWrapper<Chuangzuozhe> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Chuangzuozhe::getZhanghao,chuangzuozhe.getZhanghao());
        Chuangzuozhe findChuangzuozhe = chuangzuozheDao.selectOne(wrapper);
        if (findChuangzuozhe != null) {
            throw new CustomException("1001", "" + chuangzuozhe.getZhanghao() + "\"已存在");
        }
        chuangzuozhe.setAddtime(new Date());
        chuangzuozheDao.insert(chuangzuozhe);
        return chuangzuozhe;
    }
	
	
	
    public void delete(Long id) {
        chuangzuozheDao.deleteById(id);
    }
	

    public void update(Chuangzuozhe chuangzuozhe) {
         LambdaQueryWrapper<Chuangzuozhe> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Chuangzuozhe::getZhanghao,chuangzuozhe.getZhanghao());
        Chuangzuozhe findChuangzuozhe = chuangzuozheDao.selectOne(wrapper);
		if (findChuangzuozhe != null && chuangzuozhe.getId() != findChuangzuozhe.getId()) {
            throw new CustomException("1001", "" + chuangzuozhe.getZhanghao() + "\"已存在");
        }
        chuangzuozheDao.updateById(chuangzuozhe);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return chuangzuozheDao.daochuexcel();
    }

    @Override
    public Chuangzuozhe findById(Integer id) {
        return chuangzuozheDao.selectById(id);
    }

    public ChuangzuozheVo findPage(ChuangzuozheVo chuangzuozheVo) {
        LambdaQueryWrapper<Chuangzuozhe> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(chuangzuozheVo.getZhanghao()), Chuangzuozhe::getZhanghao,chuangzuozheVo.getZhanghao());        wrapper.like(ObjectUtils.isNotEmpty(chuangzuozheVo.getMima()), Chuangzuozhe::getMima,chuangzuozheVo.getMima());        wrapper.like(ObjectUtils.isNotEmpty(chuangzuozheVo.getXingming()), Chuangzuozhe::getXingming,chuangzuozheVo.getXingming());        wrapper.eq(ObjectUtils.isNotEmpty(chuangzuozheVo.getXingbie()), Chuangzuozhe::getXingbie,chuangzuozheVo.getXingbie());        wrapper.like(ObjectUtils.isNotEmpty(chuangzuozheVo.getShenfenzheng()), Chuangzuozhe::getShenfenzheng,chuangzuozheVo.getShenfenzheng());        wrapper.like(ObjectUtils.isNotEmpty(chuangzuozheVo.getLianxidianhua()), Chuangzuozhe::getLianxidianhua,chuangzuozheVo.getLianxidianhua());        wrapper.like(ObjectUtils.isNotEmpty(chuangzuozheVo.getZhaopian()), Chuangzuozhe::getZhaopian,chuangzuozheVo.getZhaopian());        
        Page<Chuangzuozhe> page = new Page<>(chuangzuozheVo.getCurrent(),chuangzuozheVo.getCurrentNum());
        chuangzuozheDao.selectPage(page,wrapper);
        List<Chuangzuozhe> chuangzuozhes = page.getRecords();
        chuangzuozheVo.setList(chuangzuozhes);
        chuangzuozheVo.setPages(page.getPages());
        chuangzuozheVo.setTotal(page.getTotal());
        chuangzuozheVo.setCurrent(page.getCurrent());
        chuangzuozheVo.setCurrentNum(page.getSize());
        return chuangzuozheVo;
    }

    @Override
    public void deleteList(List<Chuangzuozhe> list) {
        List<Integer> ids =  list.stream().map(Chuangzuozhe::getId).collect(Collectors.toList());
        chuangzuozheDao.deleteBatchIds(ids);
    }
	
	@Override
    public Chuangzuozhe login(Chuangzuozhe chuangzuozhe) {
        LambdaQueryWrapper<Chuangzuozhe> wrapper = new LambdaQueryWrapper();
        wrapper.eq(ObjectUtils.isNotEmpty(chuangzuozhe.getZhanghao()), Chuangzuozhe::getZhanghao,chuangzuozhe.getZhanghao());
        Chuangzuozhe chuangzuozheInfo = chuangzuozheDao.selectOne(wrapper);
        if (chuangzuozheInfo == null) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        if (!SecureUtil.md5(chuangzuozhe.getMima()).equalsIgnoreCase(chuangzuozheInfo.getMima())) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        return chuangzuozheInfo;
    }
	
	 @Override
    public void findchuangzuozhezhanghao(Chuangzuozhe chuangzuozhe) {
        LambdaQueryWrapper<Chuangzuozhe> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Chuangzuozhe::getZhanghao,chuangzuozhe.getZhanghao());
        Chuangzuozhe findChuangzuozhe = chuangzuozheDao.selectOne(wrapper);
        if (findChuangzuozhe != null) {
            throw new CustomException("1001", "" + chuangzuozhe.getZhanghao() + "\"已存在");
        }
    }
	
	//youxxianxci
}
