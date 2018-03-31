package com.upload;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传：
 * 1.加入fileupload的jar包
 * 2.需要在上下文中配置MultipartResolver
 * 3.参数接收MultipartFile
 * @author 12862
 *
 */
@RequestMapping("/file")
@Controller
public class FileUpload {

	@RequestMapping("/upload")
	public String fileUpload(@RequestParam("desc")String desc,@RequestParam("file")MultipartFile file) throws IOException{
		System.out.println("desc:"+desc);
		System.out.println("fileName:"+file.getOriginalFilename());
		System.out.println("InputStream:"+file.getInputStream());
		return "success";
	}
}
