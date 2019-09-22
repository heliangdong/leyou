package com.leyou.service.impl;

import com.leyou.controller.UploadController;
import com.leyou.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UploadServiceImpl implements UploadService {
    private static final Logger logger= LoggerFactory.getLogger(UploadController.class);

    // 支持的文件类型
    private static final List<String> suffixs= Arrays.asList("image/png", "image/jpeg","image/jpg");


    @Override
    public String upload(MultipartFile file) throws IOException {
        try{
            String type = file.getContentType();
            // 1、图片信息校验
            // 1)校验文件类型
            if(!suffixs.contains(type)){
                logger.info("上传失败，文件类型不匹配：{}", type);
                return null;
            }
            //2)校验图片内容
            BufferedImage image = ImageIO.read(file.getInputStream());
            if(image==null){
                logger.info("上传失败，文件内容不符合要求");
                return null;
            }
            // 2、保存图片
            // 2.1、生成保存目录
            File dir=new File("D:\\\\heima\\\\upload");
            if(!dir.exists()){
                dir.mkdir();
            }
            // 2.2、保存图片
            file.transferTo(new File(dir,file.getOriginalFilename()));

            // 2.3、拼接图片地址
            // 2.3、拼接图片地址
            String url = "http://image.leyou.com/upload/" + file.getOriginalFilename();
            return url;
        }catch (Exception e){
            return null;
        }


    }
}
