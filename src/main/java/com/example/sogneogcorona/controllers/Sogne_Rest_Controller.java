package com.example.sogneogcorona.controllers;


import com.example.sogneogcorona.model.Sogne;
import com.example.sogneogcorona.repositories.SogneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class Sogne_Rest_Controller {

    @Autowired
    SogneRepo sogneRepo;

    public Sogne_Rest_Controller(SogneRepo sogneRepo) {
        this.sogneRepo = sogneRepo;
    }

    @GetMapping("/sogne")
    public ResponseEntity<List<Sogne>> findAll(){
        //findAll recipes and return
        List<Sogne> sogneList =new ArrayList<>();
        for (Sogne sogne:sogneRepo.findAll()){
            sogneList.add(sogne);
        }
        return ResponseEntity.status(HttpStatus.OK).body(sogneList);
    }

    @GetMapping("/sogne/{id}")
    public ResponseEntity<Optional<Sogne>> findById(@PathVariable int id)
    {
        Optional<Sogne> optionalSogne = sogneRepo.findById(id);
        if (optionalSogne.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalSogne);
        }
        else{
            //Not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(optionalSogne);
        }
    }

    @PutMapping("/car/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody Sogne sogne) {
        Optional<Sogne> optionalSogne = sogneRepo.findById(id);
        if (!optionalSogne.isPresent()) {
            //id findes ikke
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'msg' : 'car " + id + " not found'}");
        }
        sogneRepo.save(sogne);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("{ 'msg' : 'updated' }");

    }
}
