package com.app.stream.repository;

import com.app.stream.entity.Video;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends MongoRepository<Video, String> {
    // Define métodos de consulta personalizados si es necesario
}
