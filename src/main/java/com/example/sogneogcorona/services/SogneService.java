package com.example.sogneogcorona.services;


import com.example.sogneogcorona.model.Sogne;
import com.example.sogneogcorona.repositories.SogneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class SogneService {
    @Autowired
    SogneRepo sogneRepo;

    public Set<Sogne> findAll(){
        Set<Sogne> sognes = new HashSet<>();
        for (Sogne sogne : sogneRepo.findAll()){
            sognes.add(sogne);
        }
        return sognes;
    }

    public Sogne findById(int id){
        //findById returnerer en optional, så der skal checkes for null og pakkes ud
        Optional<Sogne> optionalSogne = sogneRepo.findById(id);
        if (!optionalSogne.isPresent()) {
            throw new RuntimeException("Sogne " + id + " not found");
        }
        //return indholdet af optionalBrand
        return optionalSogne.get();
    }

    public Sogne create(Sogne sogne){

        return sogneRepo.save(sogne);
    }

    public Sogne update(Sogne sogne){
        //check evt. for eksistens og thow exception hvis ikke eksisterer
        return sogneRepo.save(sogne);
    }

    public void deleteById(int id){
        sogneRepo.deleteById(id);
    }

}
