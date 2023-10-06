package com.app.stream.controllers;

import com.app.stream.entity.Video;
import com.app.stream.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/videos")
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    @GetMapping("/")
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Video> getVideoById(@PathVariable String id) {
        return videoRepository.findById(id);
    }

    @PostMapping("/create")
    public Video createVideo(@RequestBody Video video) {
        return videoRepository.save(video);
    }

    @PutMapping("/{id}")
    public Optional<Video> updateVideo(@PathVariable String id, @RequestBody Video video) {
        if (videoRepository.existsById(id)) {
            video.setId(id);
            return Optional.of(videoRepository.save(video));
        }
        return Optional.empty();
    }

    @DeleteMapping("/{id}")
    public void deleteVideo(@PathVariable String id) {
        videoRepository.deleteById(id);
    }
}
