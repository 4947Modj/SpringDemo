package com.example.demo.Controller;

import com.example.demo.Entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
//@CrossOrigin
public class UploadController {

    @PostMapping("/upload")
    public Result uploadFile(String name, Integer age, MultipartFile file) throws IOException {
        log.info("Received file: {}",file.getOriginalFilename());
        // 获取文件后缀名
        int index = file.getOriginalFilename().lastIndexOf(".");
        // 生成唯一文件名
        String fileName = UUID.randomUUID() + file.getOriginalFilename().substring(index);
        // 保存文件到指定目录
        file.transferTo(new File("E:\\demo\\files\\"+fileName));
        return Result.success();
    }
}
