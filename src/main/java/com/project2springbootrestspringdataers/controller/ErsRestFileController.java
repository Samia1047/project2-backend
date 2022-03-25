package com.project2springbootrestspringdataers.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project2springbootrestspringdataers.entity.FileDB;
import com.project2springbootrestspringdataers.pojo.ResponseFile;
import com.project2springbootrestspringdataers.pojo.ResponseMessage;
import com.project2springbootrestspringdataers.service.FileStorageService;

@RestController
@RequestMapping()
@CrossOrigin(origins = {"http://localhost:4444", "http://localhost:4200"})

public class ErsRestFileController {
	@Autowired
	  private FileStorageService storageService;
	
	//http://localhost:4444/upload
	  @PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";
	    try {
	      storageService.store(file);
	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }
	  @GetMapping("/files")
	  public ResponseEntity<List<ResponseFile>> getListFiles() {
	    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
	      String fileDownloadUri = ServletUriComponentsBuilder
	          .fromCurrentContextPath()
	          .path("/files/")
	          .path(dbFile.getId())
	          .toUriString();
	      return new ResponseFile(
	          dbFile.getName(),
	          fileDownloadUri,
	          dbFile.getType(),
	          dbFile.getData().length);
	    }).collect(Collectors.toList());
	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }
	  @GetMapping("/files/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable String id) {
	    FileDB fileDB = storageService.getFile(id);
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
	        .body(fileDB.getData());
	  }
	  
	  
	  //
//	  @RestController
//	  @RequestMapping("api")
//	  public class ImageController {
//	  	
//	  	@Autowired
//	  	ImageService imageService;
//	  	
//	  	// http://localhost:4444/api/manager/pic-upload
//	  	@CrossOrigin(origins = "http://localhost:4200")
//	  	@PostMapping("manager/pic-upload")
//	  	ImagePojo uploadImage(@RequestParam("file") MultipartFile file) throws SystemException {
//	  		return imageService.uploadImage(file);
//	  	}
//	  	
//	  	// http://localhost:4444/api/manager/all-pics
//	  	@CrossOrigin(origins = "http://localhost:4200")
//	  	@GetMapping("manager/all-pics")
//	  	List<ImagePojo> getAllImages() throws SystemException {
//	  		return imageService.getAllImages();
//	  	}
//	  	
//	  }
	
}
