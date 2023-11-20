package com.app.stream.controllers;

import com.app.stream.entity.Serie;
import com.app.stream.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/series")
public class SerieController {

    private final SerieRepository serieRepository;

    @Autowired
    public SerieController(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    // Obtener todas las series
    @GetMapping
    public List<Serie> getAllSeries() {
        return serieRepository.findAll();
    }

    // Obtener una serie por ID
    @GetMapping("/{id}")
    public ResponseEntity<Serie> getSerieById(@PathVariable String id) {
        return serieRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Agregar una nueva serie
    @PostMapping("/create")
    public ResponseEntity<Serie> addSerie(@RequestBody Serie serie) {
        Serie savedSerie = serieRepository.save(serie);
        return new ResponseEntity<>(savedSerie, HttpStatus.CREATED);
    }

    // Actualizar una serie existente
    @PutMapping("/{id}")
    public ResponseEntity<Serie> updateSerie(@PathVariable String id, @RequestBody Serie serie) {
        if (!serieRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        serie.setId(id);
        Serie updatedSerie = serieRepository.save(serie);
        return ResponseEntity.ok(updatedSerie);
    }

    // Eliminar una serie por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSerie(@PathVariable String id) {
        if (!serieRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        serieRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}