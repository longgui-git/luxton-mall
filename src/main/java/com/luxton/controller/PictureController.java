package com.luxton.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.luxton.service.PictureUploadService;
import com.luxton.utils.LuxtonResult;

@Controller
public class PictureController {

	@Autowired
	private PictureUploadService picService;
	
	@RequestMapping("/picture/upload")
	@ResponseBody
	public LuxtonResult uploadPicture(MultipartFile uploadFile){
		
		LuxtonResult result = picService.uploadPicture(uploadFile);
		
		return result;
	}
	
	@RequestMapping("/picture/list/upload")
	@ResponseBody
	public LuxtonResult uploadPictureList(List<MultipartFile> fileList){
		
		LuxtonResult result = picService.uploadPictureList(fileList);
		
		return result;
	}
	
}
