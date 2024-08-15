package com.example.Test;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploader {

	public boolean uploaded=false;
	
	@Value("${directory}")
	String directory;

	public boolean uploadFile(MultipartFile file)
	{
		
		System.out.println("FFFFFFFFFF F "+directory );
		try {
			
//			if(!file.isEmpty())
//			{
//				
//				InputStream is=file.getInputStream();
//				byte[] data = new byte[is.available()];
//				is.read(data);
//				FileOutputStream fos=new FileOutputStream(directory+File.separator+file.getOriginalFilename());
//				fos.write(data);
//				fos.close();
//				fos.flush();
//				uploaded=true;
			
//			}
			Files.copy(file.getInputStream(),Path.of(directory+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			uploaded=true;
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		return uploaded;
	}

}
