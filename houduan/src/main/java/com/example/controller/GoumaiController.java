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
import com.example.entity.Goumai;
import com.example.exception.CustomException;
import com.example.service.GoumaiService;
import com.example.utils.MapWrapperUtils;
import com.example.utils.jwt.JwtUtil;
import com.example.vo.GoumaiVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/goumai")
public class GoumaiController {

    @Resource
    private GoumaiService goumaiService;

    @PostMapping
    public Result<Goumai> add(@RequestBody GoumaiVo goumai) {
		//yoxuxiaxnci
        goumaiService.add(goumai);
        return Result.success(goumai);
    }
	
	
    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("lepubianhao","乐谱编号");        row.put("lepumingcheng","乐谱名称");        row.put("lepuleibie","乐谱类别");        row.put("jiage","价格");        row.put("chuangzuoren","创作人");        row.put("goumairen","购买人");        

        row.put("addtime","添加时间");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = goumaiService.daochuexcel();
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
    public Result<Goumai> deleteList(@RequestBody GoumaiVo goumai) {
        goumaiService.deleteList(goumai.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        goumaiService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody GoumaiVo goumai) {
        goumaiService.update(goumai);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Goumai> detail(@PathVariable Integer id) {
        Goumai goumai = goumaiService.findById(id);
        return Result.success(goumai);
    }

    @GetMapping
    public Result<List<Goumai>> all() {
        return Result.success(goumaiService.list());
    }

    @PostMapping("/page")
    public Result<GoumaiVo> page(@RequestBody GoumaiVo goumaiVo) {
        return Result.success(goumaiService.findPage(goumaiVo));
    }
	//youupdt2login
}
