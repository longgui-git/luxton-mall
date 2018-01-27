package com.luxton.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.luxton.service.PictureUploadService;
import com.luxton.utils.ExceptionUtil;
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
			
			File filePath = new File("/ftpuser/images"+imagePath);
			if (!filePath.exists()) {
				filePath.mkdirs();
//				filePath.setReadable(true, false);
//				filePath.setExecutable(true,false);
				Runtime.getRuntime().exec("chmod -R 755 /ftpuser/images");
			}
			
			File file = new File("/ftpuser/images"+newName);
			
			
			FileOutputStream fos = new FileOutputStream("/ftpuser/images"+newName);
			
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = is.read(buffer, 0, 8192)) != -1) {
			   fos.write(buffer, 0, bytesRead);
			}
			
			fos.flush();
			fos.close();
			is.close();
			
			file.setReadable(true,false);
//			file.setExecutable(true);
//			Runtime.getRuntime().exec("chmod -R 755 /ftpuser/images"+newName);
			
			System.out.println(file.canRead());
			
		} catch (IOException e) {
			return LuxtonResult.build(561, "文件上传失败!"+ExceptionUtil.getStackTrace(e));
		}
		
		
		return LuxtonResult.ok("http://image.luxtonusa.com"+newName);
	}

	@Override
	public LuxtonResult uploadPictureList(List<MultipartFile> fileList) {
		
		System.out.println("-----"+fileList.size());
		
		List<String> picList = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		for(MultipartFile uploadFile:fileList) {
			
			String oldName = uploadFile.getOriginalFilename();
			//图片上传
			String imagePath = new DateTime().toString("/yyyy/MM/dd");
			
			//生成新文件名
			String newName = IDUtils.getImageName();
			newName = imagePath+"/"+newName + oldName.substring(oldName.lastIndexOf("."));
			
			try {
				
				InputStream is = uploadFile.getInputStream();
				
				File filePath = new File("/ftpuser/images"+imagePath);
				if (!filePath.exists()) {
					filePath.mkdirs();
					filePath.setReadable(true);
					filePath.setExecutable(true);
				}
				
				File file = new File("/ftpuser/images"+newName);
				file.setReadable(true);
				file.setExecutable(true);
				Runtime.getRuntime().exec("chmod 777 /ftpuser/images"+newName);
				
				FileOutputStream fos = new FileOutputStream("/ftpuser/images"+newName);
				
				int bytesRead = 0;
				byte[] buffer = new byte[8192];
				while ((bytesRead = is.read(buffer, 0, 8192)) != -1) {
				   fos.write(buffer, 0, bytesRead);
				}
				
				fos.flush();
				fos.close();
				is.close();
				
				picList.add("http://image.luxtonusa.com"+newName);
				
			} catch (IOException e) {
				sb=sb.append(oldName+"  ");
				
			}
			
		}
		Map<String, Object> map = new HashMap<>();
		map.put("picList", picList);
		map.put("failPic", sb.append(",上传失败，请重新上传"));
		
		return LuxtonResult.ok(map);
	}

	
	
	
}
