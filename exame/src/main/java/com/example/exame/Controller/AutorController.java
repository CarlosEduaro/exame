package com.example.exame.Controller;


import com.example.exame.Entity.Autor;
import com.example.exame.Service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/autores")
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Pontos", description = "Contém todas as operações que podem ser realizadas em um ponto.")
public class AutorController {

    private final AutorService autorService;

    @Autowired
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Autor> getAllAutores() {
        return autorService.getAllAutor();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAutorById(@PathVariable Long id) {
        return new ResponseEntity<>(autorService.getAutorById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createAutor(@RequestBody Autor autor) {
        autorService.createAutor(autor);
        return new ResponseEntity<>("Autor Created", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAutor(@PathVariable Long id, @RequestBody Autor autorDetails) {
        autorService.updateAutor(id, autorDetails);
        return new ResponseEntity<>("Autor Updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAutor(@PathVariable Long id) {
        autorService.deleteAutor(id);
        return new ResponseEntity<>("Autor Deleted", HttpStatus.OK);
    }
}

