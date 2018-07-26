package com.leo.one.to.many.controllers;

import com.leo.one.to.many.entites.Company;
import com.leo.one.to.many.repositories.CompanyRepository;
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
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyRepository repository;

    @GetMapping
    public ResponseEntity<List<Company>> findAllCompany(){
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    @Transactional
    public ResponseEntity saveCompany(@RequestBody Company company){
        if(company.getEmployees()!=null){
            company.getEmployees().forEach(employee -> employee.setCompany(company));
        }
        repository.save(company);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateCompany(@RequestBody Company company){
        repository.save(company);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteCompany(@PathVariable("id") Integer id){
        try {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}
