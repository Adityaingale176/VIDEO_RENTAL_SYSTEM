package com.example.springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.model.Video;
import com.example.springsecurity.service.VideoService;

@RestController
public class VideoController {

    @Autowired
    VideoService videoService;
    @GetMapping("/getall")
    public ResponseEntity<List<Video>> viewAllVideos(){
        return new ResponseEntity<List<Video>>(videoService.getAllVideo(),  HttpStatus.OK);
    }

    @PostMapping("/admin/add")
    public ResponseEntity<Video> addVideo(@RequestBody Video video){
        return new ResponseEntity<Video>(videoService.addVideo(video), HttpStatus.CREATED);
    }
    
    @PutMapping("/admin/update/{id}")
    public ResponseEntity<?> updateVideo(@PathVariable Long id, @RequestBody Video video){
       if (videoService.existsById(id)){
            Video updatedVideo = videoService.updateVideo(id, video);
            return new ResponseEntity<>(updatedVideo, HttpStatus.OK);
       }
       else{
        return new ResponseEntity<>("Video with id "+id+" not found", HttpStatus.NOT_FOUND);
       }
    }

    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<?> deleteVideo(@PathVariable Long id){
        if(videoService.existsById(id)){
            videoService.deleteVideo(id);
            return new ResponseEntity<>("Video deleted successfully", HttpStatus.OK);
        }
        videoService.deleteVideo(id);
        return new ResponseEntity<>("Video with id "+id+"not found", HttpStatus.NOT_FOUND);
    }
}
