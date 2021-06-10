package com.example.sogneogcorona.controllers;

import com.example.sogneogcorona.model.Kommune;
import com.example.sogneogcorona.model.Sogne;
import com.example.sogneogcorona.repositories.SogneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashSet;

@Controller
public class WebController {
    @Autowired
    SogneRepo sogneRepo;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Sogne> sognes = new HashSet<>();
        sognes = sogneRepo.findAll();
        model.addAttribute("sognes", sognes);
        return "index";
    }

    @GetMapping("/create")
    public String createSogn() {
        return "/create";
    }

    @PostMapping("/create")
    public String createNewSogn(@RequestParam("sognekode") int sogneKode,
                             @RequestParam("navn") String navn,
                             @RequestParam("kommune") Kommune kommune,
                             @RequestParam("smittetryk") double smittetryk,
                             @RequestParam("nedlukningStart") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date nedlukningStart) {
        Sogne sogne = new Sogne(sogneKode, navn, kommune, smittetryk, nedlukningStart);

        sogneRepo.save(sogne);

        return "redirect:/";
    }
    @GetMapping("/delete")
    public String delete(){
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id")int id) {
        sogneRepo.deleteById(id);
        return  "redirect:/";
    }

    @GetMapping("/update")
    public String updateSogn(){
        return "/update";
    }

    @PostMapping("/update")
    public String updateSogn(
            @RequestParam("id") int id,
            @RequestParam("sognekode") int sognekode,
            @RequestParam("navn") String navn,
            @RequestParam("smittetryk") double smittetryk,
            @RequestParam("nedlukningStart") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date nedlukningStart,
            @RequestParam("kommune")Kommune kommune){
        Sogne sogne = new Sogne(id, sognekode, navn, smittetryk, nedlukningStart,kommune );
        sogneRepo.save(sogne);
        return "redirect:/";

    }

}



