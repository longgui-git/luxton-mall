package com.luxton.service;

import org.springframework.web.multipart.MultipartFile;

import com.luxton.utils.LuxtonResult;

public interface PictureUploadService {

	public LuxtonResult uploadPicture(MultipartFile uploadFile);
	
}
