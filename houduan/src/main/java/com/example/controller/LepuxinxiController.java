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
import com.example.entity.Lepuxinxi;
import com.example.exception.CustomException;
import com.example.service.LepuxinxiService;
import com.example.utils.MapWrapperUtils;
import com.example.utils.jwt.JwtUtil;
import com.example.vo.LepuxinxiVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/lepuxinxi")
public class LepuxinxiController {

    @Resource
    private LepuxinxiService lepuxinxiService;

    @PostMapping
    public Result<Lepuxinxi> add(@RequestBody LepuxinxiVo lepuxinxi) {
		//yoxuxiaxnci
        lepuxinxiService.add(lepuxinxi);
        return Result.success(lepuxinxi);
    }
	
	
    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("lepubianhao","乐谱编号");        row.put("lepumingcheng","乐谱名称");        row.put("lepufenlei","乐谱分类");        row.put("leqi","乐器");        row.put("lepujieshao","乐谱介绍");        row.put("jiage","价格");        row.put("chuangzuoren","创作人");        

        row.put("addtime","添加时间");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = lepuxinxiService.daochuexcel();
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
	
	@GetMapping("/lepuxinxi_tj_lepufenlei")    public Result lepuxinxi_tj_lepufenlei() {        return Result.success(lepuxinxiService.lepuxinxi_tj_lepufenlei());    }    @GetMapping("/lepuxinxi_tj_chuangzuoren")    public Result lepuxinxi_tj_chuangzuoren() {        return Result.success(lepuxinxiService.lepuxinxi_tj_chuangzuoren());    }    

    @PostMapping("/deleteList")
    public Result<Lepuxinxi> deleteList(@RequestBody LepuxinxiVo lepuxinxi) {
        lepuxinxiService.deleteList(lepuxinxi.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        lepuxinxiService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody LepuxinxiVo lepuxinxi) {
        lepuxinxiService.update(lepuxinxi);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Lepuxinxi> detail(@PathVariable Integer id) {
        Lepuxinxi lepuxinxi = lepuxinxiService.findById(id);
        return Result.success(lepuxinxi);
    }

    @GetMapping
    public Result<List<Lepuxinxi>> all() {
        return Result.success(lepuxinxiService.list());
    }

    @PostMapping("/page")
    public Result<LepuxinxiVo> page(@RequestBody LepuxinxiVo lepuxinxiVo) {
        return Result.success(lepuxinxiService.findPage(lepuxinxiVo));
    }
	//youupdt2login
}
