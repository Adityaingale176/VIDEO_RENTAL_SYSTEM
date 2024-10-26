package com.example.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springsecurity.Respository.VideoRepository;
import com.example.springsecurity.model.Video;

import jakarta.persistence.EntityNotFoundException;

@Service
public class VideoService {

    @Autowired
    VideoRepository videoRepository;

    public List<Video> getAllVideo(){
        return videoRepository.findAll();
    }

    public Video addVideo(Video video) {
        return videoRepository.save(video);
    }

    public Video updateVideo(Long id, Video video) {
        video.setId(id);
        return videoRepository.save(video);
    }

    public void deleteVideo(Long id) {
        videoRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return videoRepository.existsById(id);
    }

}
