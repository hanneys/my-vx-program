package com.eve.controller;

import com.eve.base.BizException;
import com.eve.base.ResponseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author han aijun
 * @Date 2021/4/28 10:27
 * @Version 1.0
 */
@ResponseResult
@RestController
@RequestMapping("file")
public class FileController {

    @PostMapping(value = "/upload")
    public Map<String, Object> fileUpload(@RequestParam(value = "file") MultipartFile file,HttpServletRequest request) {
        if (file.isEmpty()) {
            throw  new BizException("文件为空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "D:/background/"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/background/" + fileName;
        Map<String, Object> map = new HashMap<>();
        map.put("fileName",filename);
        return map;
    }
}
