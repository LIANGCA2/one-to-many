package com.leo.one.to.one.controllers;

import com.leo.one.to.one.entities.Leader;
import com.leo.one.to.one.repositories.LeaderRepository;
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
@RequestMapping("leaders")
public class LeaderController {

    @Autowired
    private LeaderRepository repository;

    @GetMapping
    public ResponseEntity<List<Leader>> findAllLeader() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    @Transactional
    public ResponseEntity saveLeader(@RequestBody Leader leader) {
        if (leader.getKlass() != null) {
            leader.getKlass().setLeader(leader);
        }
        repository.save(leader);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateLeader(@RequestBody Leader leader) {
        repository.save(leader);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteLeader(@PathVariable("id") Integer id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

}
