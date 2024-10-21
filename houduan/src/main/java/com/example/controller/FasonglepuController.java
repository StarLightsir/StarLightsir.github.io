package com.example.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.common.Result;
import com.example.common.ResultCode;
import com.example.entity.Fasonglepu;
import com.example.exception.CustomException;
import com.example.service.FasonglepuService;
import com.example.utils.MapWrapperUtils;
import com.example.utils.jwt.JwtUtil;
import com.example.vo.FasonglepuVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/fasonglepu")
public class FasonglepuController {

    @Resource
    private FasonglepuService fasonglepuService;

    @PostMapping
    public Result<Fasonglepu> add(@RequestBody FasonglepuVo fasonglepu) {
		//yoxuxiaxnci
        fasonglepuService.add(fasonglepu);
        return Result.success(fasonglepu);
    }
	
	
    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("lepubianhao","乐谱编号");        row.put("lepumingcheng","乐谱名称");        row.put("lepuleibie","乐谱类别");        row.put("chuangzuoren","创作人");        row.put("goumairen","购买人");        

        row.put("addtime","添加时间");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = fasonglepuService.daochuexcel();
        for (Map<String, Object> map : daochuexcellist) {
            list.add(map);
        }
        // 2. 写excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition","attachment;filename=chaoba.xlsx");
        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        writer.close();
        IoUtil.close(System.out);
    }
	
	

    @PostMapping("/deleteList")
    public Result<Fasonglepu> deleteList(@RequestBody FasonglepuVo fasonglepu) {
        fasonglepuService.deleteList(fasonglepu.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        fasonglepuService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody FasonglepuVo fasonglepu) {
        fasonglepuService.update(fasonglepu);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Fasonglepu> detail(@PathVariable Integer id) {
        Fasonglepu fasonglepu = fasonglepuService.findById(id);
        return Result.success(fasonglepu);
    }

    @GetMapping
    public Result<List<Fasonglepu>> all() {
        return Result.success(fasonglepuService.list());
    }

    @PostMapping("/page")
    public Result<FasonglepuVo> page(@RequestBody FasonglepuVo fasonglepuVo) {
        return Result.success(fasonglepuService.findPage(fasonglepuVo));
    }
	//youupdt2login
}
