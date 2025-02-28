package com.example.controller;

import cn.hutool.core.io.FileUtil;
import com.example.common.Result;
import com.example.entity.FileInfo;
import com.example.exception.CustomException;
import com.example.service.FileInfoService;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/files")
public class FileController {

    private static final String BASE_PATH = System.getProperty("user.dir") + "/src/main/resources/static/file/";

    @Resource
    private FileInfoService fileInfoService;

    @PostMapping("/upload")
    public Result upload(MultipartFile file, HttpServletRequest request) throws IOException {
        String originName = file.getOriginalFilename();
        if (originName == null) {
            return Result.error("1001", "文件名不能为空");
        }
        if (!originName.contains("png")
                && !originName.contains("jpg")
                && !originName.contains("jpeg")
                && !originName.contains("gif")) {
            return Result.error("1001", "只能上传图片");
        }
        // 文件名加个时间戳
        String fileName = FileUtil.mainName(originName) + System.currentTimeMillis() + "." + FileUtil.extName(originName);

        // 2. 文件上传
        FileUtil.writeBytes(file.getBytes(), BASE_PATH + fileName);

        // 3. 信息入库，获取文件id
        FileInfo info = new FileInfo();
        info.setOriginName(originName);
        info.setFileName(fileName);
        FileInfo addInfo = fileInfoService.add(info);
        if (addInfo != null) {
            return Result.success(addInfo);
        } else {
            return Result.error("4001", "上传失败");
        }
    }

    @PostMapping("/uploadwenjian")
    public Result uploadwenjian(MultipartFile file, HttpServletRequest request) throws IOException {
        String originName = file.getOriginalFilename();
        if (originName == null) {
            return Result.error("1001", "文件名不能为空");
        }

        // 文件名加个时间戳
        String fileName = FileUtil.mainName(originName) + System.currentTimeMillis() + "." + FileUtil.extName(originName);

        // 2. 文件上传
        FileUtil.writeBytes(file.getBytes(), BASE_PATH + fileName);

        // 3. 信息入库，获取文件id
        FileInfo info = new FileInfo();
        info.setOriginName(originName);
        info.setFileName(fileName);
        FileInfo addInfo = fileInfoService.add(info);
        if (addInfo != null) {
            return Result.success(addInfo);
        } else {
            return Result.error("4001", "上传失败");
        }
    }
	
	
    @PostMapping("/front/uploadwenjian")
    public Result uploadwenjian(MultipartFile file) throws IOException {
        String originName = file.getOriginalFilename();
        if (originName == null) {
            return Result.error("1001", "文件名不能为空");
        }

        // 文件名加个时间戳
        String fileName = FileUtil.mainName(originName) + System.currentTimeMillis() + "." + FileUtil.extName(originName);

        // 2. 文件上传
        FileUtil.writeBytes(file.getBytes(), BASE_PATH + fileName);

        // 3. 信息入库，获取文件id
        FileInfo info = new FileInfo();
        info.setOriginName(originName);
        info.setFileName(fileName);
        FileInfo addInfo = fileInfoService.add(info);
        if (addInfo != null) {
            return Result.success(addInfo);
        } else {
            return Result.error("4001", "上传失败");
        }
    }


    @PostMapping("/notice/upload")
    public Result<Map<String, String>> noticeUpload(MultipartFile file, HttpServletRequest request) throws IOException {
        String originName = file.getOriginalFilename();
        // 文件名加个时间戳
        String fileName = FileUtil.mainName(originName) + System.currentTimeMillis() + "." + FileUtil.extName(originName);
        // 2. 缩小尺寸
        Thumbnails.of(file.getInputStream()).width(400).toFile(BASE_PATH + fileName);

        // 3. 信息入库，获取文件id
        FileInfo info = new FileInfo();
        info.setOriginName(originName);
        info.setFileName(fileName);
        FileInfo addInfo = fileInfoService.add(info);

        Map<String, String> map = new HashMap<>(2);
        map.put("src", "/files/download/" + addInfo.getId());
        map.put("title", originName);
        return Result.success(map);
    }


    @GetMapping("/download/{id}")
    public void download(@PathVariable String id, HttpServletResponse response) throws IOException {
        if ("null".equals(id)) {
            throw new CustomException("1001", "您未上传文件");
        }
        FileInfo fileInfo = fileInfoService.findById(Long.parseLong(id));
        if (fileInfo == null) {
            throw new CustomException("1001", "未查询到该文件");
        }
        byte[] bytes = FileUtil.readBytes(BASE_PATH + fileInfo.getFileName());
        response.reset();
        // 设置response的Header
        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileInfo.getOriginName(), "UTF-8"));
        response.addHeader("Content-Length", "" + bytes.length);
        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
        response.setContentType("application/octet-stream");
        toClient.write(bytes);
        toClient.flush();
        toClient.close();
    }

    @DeleteMapping("/{id}")
    public Result deleteFile(@PathVariable String id) {
        FileInfo fileInfo = fileInfoService.findById(Long.parseLong(id));
        if (fileInfo == null) {
            throw new CustomException("1001", "未查询到该文件");
        }
        String name = fileInfo.getFileName();
        // 先删除文件
        FileUtil.del(new File(BASE_PATH + name));
        // 再删除表记录
        fileInfoService.delete(Long.parseLong(id));

        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<FileInfo> getById(@PathVariable String id) {
        FileInfo fileInfo = fileInfoService.findById(Long.parseLong(id));
        if (fileInfo == null) {
            throw new CustomException("1001", "数据库未查到此文件");
        }
        try {
            FileUtil.readBytes(BASE_PATH + fileInfo.getFileName());
        } catch (Exception e) {
            throw new CustomException("1001", "此文件已被您删除");
        }
        return Result.success(fileInfo);
    }
}
