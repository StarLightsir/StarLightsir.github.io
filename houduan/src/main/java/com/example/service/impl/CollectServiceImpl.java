package com.example.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.CollectDao;
import com.example.dao.FileInfoDao;
import com.example.entity.Collect;
import com.example.entity.FileInfo;
import com.example.entity.Chuangzuozhe;import com.example.entity.Lepuxinxi;
import com.example.service.CollectService;
import com.example.service.ChuangzuozheService;import com.example.service.LepuxinxiService;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("collectService")
public class CollectServiceImpl  extends ServiceImpl<CollectDao, Collect> implements CollectService {

    @Resource
    private CollectDao collectDao;
	
	@Resourceprivate ChuangzuozheService chuangzuozheService;@Resourceprivate LepuxinxiService lepuxinxiService;
   

    public Collect add(Collect collect) {
        Collect collect1 = collectDao.findByUser(collect);
        if(collect1 == null) {
            collectDao.insert(collect);
            return collect;
        }else {
            return null;
        }
    }

    public void delete(Integer id) {
        collectDao.deleteById(id);
    }

    public void update(Collect collect) {
        collectDao.updateById(collect);
    }

    public Collect findById(Long id) {
        return collectDao.selectById(id);
    }

    public List<Collect> findFrontPages(Integer userId) {
        List<Collect> collects;
        if (userId != null){
            collects = collectDao.findByEndUserId(userId);
        } else {
            collects = new ArrayList<>();
        }
        for (Collect collect : collects) {
            packOrder(collect);
        }
        return collects;
    }
    /**
     * 包装收藏的用户和商品信息
     */

	public List<Chuangzuozhe> findPaperByChuangzuozhe(Integer id) {
        List<Collect> collects = collectDao.findByEndUserId(id);
        List<Chuangzuozhe> chuangzuozheList = new ArrayList<>();
        for (Collect collect : collects) {
            Integer foreignId = collect.getShangpinxinxiID();
            Chuangzuozhe chuangzuozhe = null;
            if(foreignId != null){
                chuangzuozhe = chuangzuozheService.findById(foreignId);
            };
            if(chuangzuozhe != null){
                chuangzuozheList.add(chuangzuozhe);
            }
        }
        return chuangzuozheList;
    }
	
	private void packOrder(Collect collect) {
        collect.setChuangzuozhe(chuangzuozheService.findById(collect.getUserId()));
        List<Lepuxinxi> goodsList = CollUtil.newArrayList();
        collect.setProductList(goodsList);
        Lepuxinxi goodsDetail = lepuxinxiService.findById(collect.getShangpinxinxiID());
        if (goodsDetail != null) {
            goodsList.add(goodsDetail);
        }
    }

	@Override
    public void deleteByUserId(Integer id, Integer userId) {
        collectDao.deleteByUserId(id,userId);
    }
    
}
