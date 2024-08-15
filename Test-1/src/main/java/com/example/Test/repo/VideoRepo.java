package com.example.Test.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Test.model.Video;

public interface VideoRepo extends JpaRepository<Video,String> {

Optional<Video >	findByTitle(String title);
}
