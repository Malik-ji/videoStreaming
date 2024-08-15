package com.example.Test.Sevice;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.Test.model.Video;

public interface VideoService {

	Video save(Video video, MultipartFile file);

	Video getVideo(String id);

	Video getByTitle(String title);

	List<Video>	getAll();
}
