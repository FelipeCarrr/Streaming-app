package com.app.stream.repository;

import com.app.stream.entity.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SerieRepository extends MongoRepository<Serie, String> {
    // Puedes agregar métodos personalizados según tus necesidades
}
