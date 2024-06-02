package com.example.springbootdemo3.controller;
import com.aliyuncs.exceptions.ClientException;
import com.example.springbootdemo3.aop.Log;
import com.example.springbootdemo3.pojo.Result;
import com.example.springbootdemo3.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    //接收文件类型的数据使用到了下列方法
    //形参名与表单中的name保持一致（或者使用@RequestParam指定表单中图片输入的name）
    //这里的参数传递很奇怪，没有设置required但是却能不传递username和age进去，log显示为null
    //或许是因为是PostMapping
    @PostMapping("/upload0")
    public Result upload0(String username, Integer age , MultipartFile image) throws IOException {
        log.info("上传文件：{},{},{}",username,age,image);
        //获取文件名，除此之外也能获取其大小，字节数组，输入流
        String imageName = image.getOriginalFilename();
        Integer index = imageName.lastIndexOf(".");
        //存储到本地，并制造新文件名
        //最大文件大小为1mb，可在配置文件中配置
        image.transferTo(new File("C:\\Users\\33428\\Desktop\\"
                + UUID.randomUUID()+imageName.substring(index)));
        return Result.success();
    }

    //使用自动注入引入工具对象
    @Autowired
    private AliOSSUtils aliOSSUtils;

    @Log
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException, ClientException {
        log.info("上传文件：{}",image.getOriginalFilename());
        String url = aliOSSUtils.upload(image);
        log.info("文件上传成功，返回url为：{}",url);
        return Result.success(url);
    }
}
