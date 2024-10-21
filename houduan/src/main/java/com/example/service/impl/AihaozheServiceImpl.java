package com.example.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.ResultCode;
import com.example.dao.*;
import com.example.entity.Aihaozhe;
import com.example.exception.CustomException;
import com.example.service.AihaozheService;
import com.example.vo.AihaozheVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("aihaozheService")
public class AihaozheServiceImpl extends ServiceImpl<AihaozheDao, Aihaozhe> implements AihaozheService {

    @Resource
    private AihaozheDao aihaozheDao;

    public Aihaozhe add(Aihaozhe aihaozhe) {
		if(aihaozhe.getMima()==null) {aihaozhe.setMima(SecureUtil.md5("001"));}else {aihaozhe.setMima(SecureUtil.md5(aihaozhe.getMima())); }
	    LambdaQueryWrapper<Aihaozhe> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Aihaozhe::getYonghuming,aihaozhe.getYonghuming());
        Aihaozhe findAihaozhe = aihaozheDao.selectOne(wrapper);
        if (findAihaozhe != null) {
            throw new CustomException("1001", "" + aihaozhe.getYonghuming() + "\"已存在");
        }
        aihaozhe.setAddtime(new Date());
        aihaozheDao.insert(aihaozhe);
        return aihaozhe;
    }
	
	
	
    public void delete(Long id) {
        aihaozheDao.deleteById(id);
    }
	

    public void update(Aihaozhe aihaozhe) {
         LambdaQueryWrapper<Aihaozhe> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Aihaozhe::getYonghuming,aihaozhe.getYonghuming());
        Aihaozhe findAihaozhe = aihaozheDao.selectOne(wrapper);
		if (findAihaozhe != null && aihaozhe.getId() != findAihaozhe.getId()) {
            throw new CustomException("1001", "" + aihaozhe.getYonghuming() + "\"已存在");
        }
        aihaozheDao.updateById(aihaozhe);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return aihaozheDao.daochuexcel();
    }

    @Override
    public Aihaozhe findById(Integer id) {
        return aihaozheDao.selectById(id);
    }

    public AihaozheVo findPage(AihaozheVo aihaozheVo) {
        LambdaQueryWrapper<Aihaozhe> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(aihaozheVo.getYonghuming()), Aihaozhe::getYonghuming,aihaozheVo.getYonghuming());        wrapper.like(ObjectUtils.isNotEmpty(aihaozheVo.getMima()), Aihaozhe::getMima,aihaozheVo.getMima());        wrapper.like(ObjectUtils.isNotEmpty(aihaozheVo.getXingming()), Aihaozhe::getXingming,aihaozheVo.getXingming());        wrapper.eq(ObjectUtils.isNotEmpty(aihaozheVo.getXingbie()), Aihaozhe::getXingbie,aihaozheVo.getXingbie());        wrapper.like(ObjectUtils.isNotEmpty(aihaozheVo.getLianxidianhua()), Aihaozhe::getLianxidianhua,aihaozheVo.getLianxidianhua());        wrapper.like(ObjectUtils.isNotEmpty(aihaozheVo.getWeixinhao()), Aihaozhe::getWeixinhao,aihaozheVo.getWeixinhao());        wrapper.like(ObjectUtils.isNotEmpty(aihaozheVo.getZhaopian()), Aihaozhe::getZhaopian,aihaozheVo.getZhaopian());        
        Page<Aihaozhe> page = new Page<>(aihaozheVo.getCurrent(),aihaozheVo.getCurrentNum());
        aihaozheDao.selectPage(page,wrapper);
        List<Aihaozhe> aihaozhes = page.getRecords();
        aihaozheVo.setList(aihaozhes);
        aihaozheVo.setPages(page.getPages());
        aihaozheVo.setTotal(page.getTotal());
        aihaozheVo.setCurrent(page.getCurrent());
        aihaozheVo.setCurrentNum(page.getSize());
        return aihaozheVo;
    }

    @Override
    public void deleteList(List<Aihaozhe> list) {
        List<Integer> ids =  list.stream().map(Aihaozhe::getId).collect(Collectors.toList());
        aihaozheDao.deleteBatchIds(ids);
    }
	
	@Override
    public Aihaozhe login(Aihaozhe aihaozhe) {
        LambdaQueryWrapper<Aihaozhe> wrapper = new LambdaQueryWrapper();
        wrapper.eq(ObjectUtils.isNotEmpty(aihaozhe.getYonghuming()), Aihaozhe::getYonghuming,aihaozhe.getYonghuming());
        Aihaozhe aihaozheInfo = aihaozheDao.selectOne(wrapper);
        if (aihaozheInfo == null) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        if (!SecureUtil.md5(aihaozhe.getMima()).equalsIgnoreCase(aihaozheInfo.getMima())) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        return aihaozheInfo;
    }
	
	 @Override
    public void findaihaozheyonghuming(Aihaozhe aihaozhe) {
        LambdaQueryWrapper<Aihaozhe> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Aihaozhe::getYonghuming,aihaozhe.getYonghuming());
        Aihaozhe findAihaozhe = aihaozheDao.selectOne(wrapper);
        if (findAihaozhe != null) {
            throw new CustomException("1001", "" + aihaozhe.getYonghuming() + "\"已存在");
        }
    }
	
	//youxxianxci
}
