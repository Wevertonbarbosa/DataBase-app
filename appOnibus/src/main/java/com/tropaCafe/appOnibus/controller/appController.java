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


    //    Read ler
    @GetMapping
    public Iterable<Inscritos> list() {
        return inscritoRepository.findAll();//Select All Mostrar todos os dados das tabelas
    }


    //  Buscando pelo Id do Inscrito.
//    @GetMapping
//    public Inscritos mostrarPorId(@PathVariable long id) {
//        Optional<Inscritos> inscritosOptional = inscritoRepository.findById(id);
//
//        if (inscritosOptional.isPresent()) {
//            return inscritosOptional.get();
//        }
//
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//    }

    //    Create criar

//    Permitindo essa url fazer as requisições neste banco de dados Url da minha aplicação em angular!
    @CrossOrigin(origins = "http://localhost:8100")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private void inserirInscrito(@RequestBody Inscritos inscrito) {
        inscritoRepository.save(inscrito);
    }

//    Up Date atualizar
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


//    Delete deletar Inscrito
    @DeleteMapping("/{id}")
    private void deletarInscrito(@PathVariable long id){
        Optional<Inscritos> inscritosOptional = inscritoRepository.findById(id);

        if (inscritosOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        inscritoRepository.delete(inscritosOptional.get());
    }

}







