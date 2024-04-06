package com.api.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.api.book.helper.FileUploadHelper;


@RestController
public class FileUploadController
{
	@Autowired
	private FileUploadHelper uploadHelper;
	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("image") MultipartFile file)
	{
		try
		{
			if(file.isEmpty())
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Select a file first.");
			}
			
			if( !file.getContentType().equals("image/jpeg"))
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Select an image.");
			}
			
			boolean result = uploadHelper.uploadFile(file);
			
			if(result)
			{
				return ResponseEntity.ok("File uploaded.");
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error.");
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Upload failed.");
	}
}
