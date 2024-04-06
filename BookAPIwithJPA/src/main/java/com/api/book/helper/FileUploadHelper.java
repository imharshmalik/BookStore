package com.api.book.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Component
public class FileUploadHelper
{
	public final String UPLOAD_PATH = new ClassPathResource("static/images").getFile().getAbsolutePath();
	
	// THIS CONSTRUCTOR IS MADE TO THROW IO EXCEPTION AND HANDLE THE CLASS_PATH_RESOURCE METHOD ABOVE
	public FileUploadHelper() throws IOException
	{
		
	}
	
	
	public boolean uploadFile(MultipartFile file)
	{
		boolean uploadStatus = false;
		try
		{
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_PATH + File.separator + file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			uploadStatus = true;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return uploadStatus;
	}
}
