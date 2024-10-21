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
import com.example.entity.Chuangzuozhe;
import com.example.exception.CustomException;
import com.example.service.ChuangzuozheService;
import com.example.utils.MapWrapperUtils;
import com.example.utils.jwt.JwtUtil;
import com.example.vo.ChuangzuozheVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/chuangzuozhe")
public class ChuangzuozheController {

    @Resource
    private ChuangzuozheService chuangzuozheService;

    @PostMapping
    public Result<Chuangzuozhe> add(@RequestBody ChuangzuozheVo chuangzuozhe) {
		//yoxuxiaxnci
        chuangzuozheService.add(chuangzuozhe);
        return Result.success(chuangzuozhe);
    }
	
	
    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("zhanghao","帐号");        row.put("xingming","姓名");        row.put("xingbie","性别");        row.put("shenfenzheng","身份证");        row.put("lianxidianhua","联系电话");        

        row.put("addtime","添加时间");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = chuangzuozheService.daochuexcel();
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
    public Result<Chuangzuozhe> deleteList(@RequestBody ChuangzuozheVo chuangzuozhe) {
        chuangzuozheService.deleteList(chuangzuozhe.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        chuangzuozheService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody ChuangzuozheVo chuangzuozhe) {
        chuangzuozheService.update(chuangzuozhe);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Chuangzuozhe> detail(@PathVariable Integer id) {
        Chuangzuozhe chuangzuozhe = chuangzuozheService.findById(id);
        return Result.success(chuangzuozhe);
    }

    @GetMapping
    public Result<List<Chuangzuozhe>> all() {
        return Result.success(chuangzuozheService.list());
    }

    @PostMapping("/page")
    public Result<ChuangzuozheVo> page(@RequestBody ChuangzuozheVo chuangzuozheVo) {
        return Result.success(chuangzuozheService.findPage(chuangzuozheVo));
    }
	    @PostMapping("/login")
    public Result login(@RequestBody Chuangzuozhe chuangzuozhe, HttpServletRequest request) {
        if (StrUtil.isBlank(chuangzuozhe.getZhanghao()) || StrUtil.isBlank(chuangzuozhe.getMima())) {
            throw new CustomException(ResultCode.PARAM_LOST_ERROR);
        }
        Chuangzuozhe login = chuangzuozheService.login(chuangzuozhe);
//        if(!login.getStatus()){
//            return Result.error("1001","状态限制，无法登录系统");
//        }
        if(login != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("user", login);
            Map<String, Object> map = MapWrapperUtils.builder(MapWrapperUtils.KEY_USER_ID,chuangzuozhe.getId());
            String token = JwtUtil.creatToken(map);
            hashMap.put("token", token);
            return Result.success(hashMap);
        }else {
            return Result.error();
        }
    }
    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestBody Chuangzuozhe info, HttpServletRequest request) {
        Chuangzuozhe chuangzuozhe = chuangzuozheService.findById(info.getId());
        String oldPassword = SecureUtil.md5(info.getMima());
        if (!oldPassword.equals(chuangzuozhe.getMima())) {
            return Result.error(ResultCode.PARAM_PASSWORD_ERROR.code, ResultCode.PARAM_PASSWORD_ERROR.msg);
        }
        info.setMima(SecureUtil.md5(info.getNewPassword()));
        Chuangzuozhe chuangzuozhe1 = new Chuangzuozhe();
        BeanUtils.copyProperties(info, chuangzuozhe1);
        chuangzuozheService.update(chuangzuozhe1);
        return Result.success();
    }
	@PostMapping("/register")
    public Result<Chuangzuozhe> register(@RequestBody ChuangzuozheVo chuangzuozhe) {
        chuangzuozheService.add(chuangzuozhe);
        return Result.success(chuangzuozhe);
    }
}
