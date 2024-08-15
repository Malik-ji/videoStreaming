package com.example.Test.impl;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.Test.Sevice.VideoService;
import com.example.Test.model.Video;
import com.example.Test.repo.VideoRepo;

import jakarta.annotation.PostConstruct;

@Service
public class VideoServiceImple implements VideoService {

	@Value("${directory}")
	String directory;

	@Autowired
	private VideoRepo videoRepo;

	@PostConstruct
	public void init() {
		File f = new File(directory);

		if (!f.exists()) {
			f.mkdir();
			System.out.println("The file or directory exists.");
		} else {
			System.out.println("Already created");
		}
	}

	@Override
	public Video save(Video video, MultipartFile file) {
		// TODO Auto-generated method stub
		try {
			String originalFilename = file.getOriginalFilename();
			String contentType = file.getContentType();
			System.out.println("Affan" + originalFilename);
			InputStream inputStream = file.getInputStream();
			String cleanPath = StringUtils.cleanPath(originalFilename);
			String cleanPath2 = StringUtils.cleanPath(directory);
			Path path = Paths.get(cleanPath2, cleanPath);
			Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
			video.setContentType(contentType);
			video.setFilePath(path.toString());
			return videoRepo.save(video);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}

//		return null;	
	}

	@SuppressWarnings("deprecation")
	@Override
	public Video getVideo(String id) {
		Video byId =null;
		try {
			 byId = videoRepo.getById(id);
		} catch (Exception e) {
		e.printStackTrace();
		}
		return byId;
	}

	@Override
	public Video getByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Video> getAll() {
		List<Video> findAll = videoRepo.findAll();
		return findAll;
	}

}
