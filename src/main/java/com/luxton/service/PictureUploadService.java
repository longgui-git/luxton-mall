package com.luxton.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.luxton.utils.LuxtonResult;

public interface PictureUploadService {

	public LuxtonResult uploadPicture(MultipartFile uploadFile);
	
	public LuxtonResult uploadPictureList(List<MultipartFile> fileList);
	
}
