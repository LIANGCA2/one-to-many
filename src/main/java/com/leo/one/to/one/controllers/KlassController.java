package com.leo.one.to.one.controllers;

import com.leo.one.to.one.entities.Klass;
import com.leo.one.to.one.repositories.KlassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LIULE9
 */
@RestController
@RequestMapping("klasses")
public class KlassController {
    @Autowired
    private KlassRepository repository;

    @GetMapping
    public ResponseEntity<List<Klass>> findAllKlass() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    @Transactional
    public ResponseEntity saveKlass(@RequestBody Klass klass) {
        if (klass.getLeader() != null) {
            klass.getLeader().setKlass(klass);
        }
        repository.save(klass);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateKlass(@RequestBody Klass klass) {
        repository.save(klass);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteKlass(@PathVariable("id") Integer id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}
