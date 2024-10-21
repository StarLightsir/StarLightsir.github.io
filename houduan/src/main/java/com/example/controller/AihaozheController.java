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
import com.example.entity.Aihaozhe;
import com.example.exception.CustomException;
import com.example.service.AihaozheService;
import com.example.utils.MapWrapperUtils;
import com.example.utils.jwt.JwtUtil;
import com.example.vo.AihaozheVo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "/aihaozhe")
public class AihaozheController {

    @Resource
    private AihaozheService aihaozheService;

    @PostMapping
    public Result<Aihaozhe> add(@RequestBody AihaozheVo aihaozhe) {
		//yoxuxiaxnci
        aihaozheService.add(aihaozhe);
        return Result.success(aihaozhe);
    }
	
	
    @GetMapping("/getExcel")
    public void getExcel(HttpServletResponse response) throws IOException {
        // 1. 生成excel
        Map<String, Object> row = new LinkedHashMap<>();
        row.put("yonghuming","用户名");        row.put("xingming","姓名");        row.put("xingbie","性别");        row.put("lianxidianhua","联系电话");        row.put("weixinhao","微信号");        

        row.put("addtime","添加时间");
        List<Map<String, Object>> list = CollUtil.newArrayList(row);
        List<Map<String, Object>> daochuexcellist = aihaozheService.daochuexcel();
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
    public Result<Aihaozhe> deleteList(@RequestBody AihaozheVo aihaozhe) {
        aihaozheService.deleteList(aihaozhe.getList());
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        aihaozheService.delete(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody AihaozheVo aihaozhe) {
        aihaozheService.update(aihaozhe);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Aihaozhe> detail(@PathVariable Integer id) {
        Aihaozhe aihaozhe = aihaozheService.findById(id);
        return Result.success(aihaozhe);
    }

    @GetMapping
    public Result<List<Aihaozhe>> all() {
        return Result.success(aihaozheService.list());
    }

    @PostMapping("/page")
    public Result<AihaozheVo> page(@RequestBody AihaozheVo aihaozheVo) {
        return Result.success(aihaozheService.findPage(aihaozheVo));
    }
	    @PostMapping("/login")
    public Result login(@RequestBody Aihaozhe aihaozhe, HttpServletRequest request) {
        if (StrUtil.isBlank(aihaozhe.getYonghuming()) || StrUtil.isBlank(aihaozhe.getMima())) {
            throw new CustomException(ResultCode.PARAM_LOST_ERROR);
        }
        Aihaozhe login = aihaozheService.login(aihaozhe);
//        if(!login.getStatus()){
//            return Result.error("1001","状态限制，无法登录系统");
//        }
        if(login != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("user", login);
            Map<String, Object> map = MapWrapperUtils.builder(MapWrapperUtils.KEY_USER_ID,aihaozhe.getId());
            String token = JwtUtil.creatToken(map);
            hashMap.put("token", token);
            return Result.success(hashMap);
        }else {
            return Result.error();
        }
    }
    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestBody Aihaozhe info, HttpServletRequest request) {
        Aihaozhe aihaozhe = aihaozheService.findById(info.getId());
        String oldPassword = SecureUtil.md5(info.getMima());
        if (!oldPassword.equals(aihaozhe.getMima())) {
            return Result.error(ResultCode.PARAM_PASSWORD_ERROR.code, ResultCode.PARAM_PASSWORD_ERROR.msg);
        }
        info.setMima(SecureUtil.md5(info.getNewPassword()));
        Aihaozhe aihaozhe1 = new Aihaozhe();
        BeanUtils.copyProperties(info, aihaozhe1);
        aihaozheService.update(aihaozhe1);
        return Result.success();
    }
	@PostMapping("/register")
    public Result<Aihaozhe> register(@RequestBody AihaozheVo aihaozhe) {
        aihaozheService.add(aihaozhe);
        return Result.success(aihaozhe);
    }
}
