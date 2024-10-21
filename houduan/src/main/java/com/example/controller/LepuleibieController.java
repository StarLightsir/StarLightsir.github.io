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
import com.example.entity.Lepuleibie;
import com.example.exception.CustomException;
import com.example.service.LepuleibieService;
import com.example.utils.MapWrapperUtils;
import com.example.utils.jwt.JwtUtil;
import com.example.vo.LepuleibieVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/lepuleibie")
public class LepuleibieController {

    @Resource
    private LepuleibieService lepuleibieService;

    @PostMapping
    public Result<Lepuleibie> add(@RequestBody LepuleibieVo lepuleibie) {
		//yoxuxiaxnci
        lepuleibieService.add(lepuleibie);
        return Result.success(lepuleibie);
    }
	
	
    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("leibiemingcheng","类别名称");        row.put("leibiejieshao","类别介绍");        row.put("shiyongleqi","使用乐器");        

        row.put("addtime","添加时间");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = lepuleibieService.daochuexcel();
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
    public Result<Lepuleibie> deleteList(@RequestBody LepuleibieVo lepuleibie) {
        lepuleibieService.deleteList(lepuleibie.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        lepuleibieService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody LepuleibieVo lepuleibie) {
        lepuleibieService.update(lepuleibie);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Lepuleibie> detail(@PathVariable Integer id) {
        Lepuleibie lepuleibie = lepuleibieService.findById(id);
        return Result.success(lepuleibie);
    }

    @GetMapping
    public Result<List<Lepuleibie>> all() {
        return Result.success(lepuleibieService.list());
    }

    @PostMapping("/page")
    public Result<LepuleibieVo> page(@RequestBody LepuleibieVo lepuleibieVo) {
        return Result.success(lepuleibieService.findPage(lepuleibieVo));
    }
	//youupdt2login
}
