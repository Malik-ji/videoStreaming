package com.example.Test.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Test.CustomMessage;
import com.example.Test.FileUploader;
import com.example.Test.Sevice.VideoService;
import com.example.Test.model.Video;

import ch.qos.logback.core.status.Status;

@RestController
@RequestMapping("/api/videos")
public class FileUploadContriller {

	@Autowired
	FileUploader uploader;

	@Autowired
	VideoService service;

	@PostMapping("/uploadStreamFile")
	@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
	public ResponseEntity<?> fileUpload(@RequestParam("file") MultipartFile file, @RequestParam("title") String title,
			@RequestParam("description") String desc) {
		try {
			Video vd = new Video();
			vd.setDescription(desc);
			vd.setTitle(title);
			vd.setVideo_Id(UUID.randomUUID().toString());
			Video save = service.save(vd, file);
			if(save!=null)
			{
				return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(vd);
			}else
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(CustomMessage.builder().message("File Not Found").success(false).build());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return null;

	}

	@PostMapping("api/v2/uploadfile")
	public ResponseEntity<String> fileUPload(@RequestParam("file") MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		if (!file.isEmpty()) {
			boolean uploadFile = uploader.uploadFile(file);
			if (uploadFile) {

				return new ResponseEntity("File Uploaded SuccessFully", HttpStatusCode.valueOf(200));
			} else {
				return new ResponseEntity(HttpStatusCode.valueOf(500), HttpStatusCode.valueOf(500));
			}
		} else {
			return new ResponseEntity("Please Upload Fill File", HttpStatusCode.valueOf(200));
		}

	}
	
	@GetMapping("/stream/{videoId}")
	public ResponseEntity<Resource> stream(@PathVariable String videoId){
		String filePath =null;
//		try {
			Video video = service.getVideo(videoId);
			System.out.println("DDDDDDDDdf"+video.toString());
			String contentType = video.getContentType();
			 filePath = video.getFilePath();
			if(contentType==null)
			{
				contentType="application/octet-stream";
			}
			Resource resource=new FileSystemResource(filePath);
			  return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).body(resource);

//		||} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.status(HttpStatusCode.valueOf(500)).body(new FileSystemResource(filePath));
//		}
		
		
	}
		@GetMapping()
		public List<Video> getAll()
		{
			List<Video> all = service.getAll();
			return all;
		}
	
}
