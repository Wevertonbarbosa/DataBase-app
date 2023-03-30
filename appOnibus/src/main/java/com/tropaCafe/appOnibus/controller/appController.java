package com.tropaCafe.appOnibus.controller;

import com.tropaCafe.appOnibus.model.Inscritos;
import com.tropaCafe.appOnibus.repository.InscritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@RestController
@RequestMapping("/api/app")
public class appController {

    @Autowired
    private InscritoRepository inscritoRepository;

    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping
    public Iterable<Inscritos> list() {
        return inscritoRepository.findAll();//Select All Mostrar todos os dados das tabelas
    }
    @CrossOrigin(origins = "http://localhost:8100")
    @GetMapping("/{id}")
    public Inscritos mostrarPorId(@PathVariable long id) {
        Optional<Inscritos> inscritosOptional = inscritoRepository.findById(id);

        if (inscritosOptional.isPresent()) {
            return inscritosOptional.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private void inserirInscrito(@RequestBody Inscritos inscrito) {
        inscritoRepository.save(inscrito);
    }


    @CrossOrigin(origins = "http://localhost:8100")
    @PutMapping("/{id}")
    private void alterar(@PathVariable long id, @RequestBody Inscritos inscritos) {
        Optional<Inscritos> inscritosOptional = inscritoRepository.findById(id);

        if (inscritosOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Inscritos inscritosEncontrado = inscritosOptional.get();
        inscritosEncontrado.atualizar(inscritos);

        inscritoRepository.save(inscritosEncontrado);
    }


    @CrossOrigin(origins = "http://localhost:8100")
    @DeleteMapping("/{id}")
    private void deletarInscrito(@PathVariable long id){
        Optional<Inscritos> inscritosOptional = inscritoRepository.findById(id);

        if (inscritosOptional.isEmpty()){

            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        inscritoRepository.delete(inscritosOptional.get());
    }

}







