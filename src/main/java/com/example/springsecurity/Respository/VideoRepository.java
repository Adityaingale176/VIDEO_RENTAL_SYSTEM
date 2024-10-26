package com.example.springsecurity.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springsecurity.model.Video;

public interface VideoRepository extends JpaRepository<Video, Long>{

}
