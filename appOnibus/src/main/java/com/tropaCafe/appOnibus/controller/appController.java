package com.tropaCafe.appOnibus.controller;

import com.tropaCafe.appOnibus.model.Inscritos;
import com.tropaCafe.appOnibus.repository.InscritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/app")
public class appController {

    @Autowired
    private InscritoRepository inscritoRepository;


//    Read ler
    @GetMapping
    public Iterable<Inscritos> list(){
        return inscritoRepository.findAll();//Select All Mostrar todos os dados das tabelas
    }
}







