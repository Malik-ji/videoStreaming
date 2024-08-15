package com.example.Test.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
//import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table( name = "yt_videos")
@Getter
@Setter
@NoArgsConstructor
@Entity 
@Builder
@AllArgsConstructor
public class Video {

	@Id
	private String video_Id;
	private String title;
	private String description;
	private String contentType;
	private String filePath;
	
//	com.example.Test.model.Course course;
	
}
