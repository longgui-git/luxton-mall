package com.luxton.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.luxton.service.PictureUploadService;
import com.luxton.utils.IDUtils;
import com.luxton.utils.LuxtonResult;
@Service
public class PictureUploadServiceImpl implements PictureUploadService {

	@Override
	public LuxtonResult uploadPicture(MultipartFile uploadFile) {

		String oldName = uploadFile.getOriginalFilename();
		
		//图片上传
		String imagePath = new DateTime().toString("/yyyy/MM/dd");
		
		//生成新文件名
		String newName = IDUtils.getImageName();
		newName = imagePath+"/"+newName + oldName.substring(oldName.lastIndexOf("."));
		
		try {
			
			InputStream is = uploadFile.getInputStream();
			
			FileOutputStream fos = new FileOutputStream("/home/ftpuser/images"+newName);
			
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = is.read(buffer, 0, 8192)) != -1) {
			   fos.write(buffer, 0, bytesRead);
			}
			
			fos.close();
			is.close();
			
		} catch (IOException e) {
			return LuxtonResult.build(561, "文件上传失败");
		}
		
		
		return LuxtonResult.ok("http://image.luxtonusa.com"+newName);
	}

}
