package com.example.exame.Controller;

import com.example.exame.Entity.Livro;
import com.example.exame.Service.LivroService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/livros") // Alterado o caminho para "livros"
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Livros", description = "Contém todas as operações que podem ser realizadas em um livro.")
public class LivroController {

    private final LivroService livroService; // Alterado para LivroService

    @Autowired
    public LivroController(LivroService livroService) { // Alterado para LivroService
        this.livroService = livroService;
    }

    @GetMapping
    public List<Livro> getAllLivros() { // Alterado para getAllLivros
        return livroService.getAllLivros(); // Alterado para livroService
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLivroById(@PathVariable Long id) { // Alterado para getLivroById
        return new ResponseEntity<>(livroService.getLivroById(id), HttpStatus.OK); // Alterado para livroService
    }

    @PostMapping
    public ResponseEntity<?> createLivro(@RequestBody Livro livro) { // Alterado para createLivro
        livroService.createLivro(livro); // Alterado para livroService
        return new ResponseEntity<>("Livro Created", HttpStatus.CREATED); // Alterado para "Livro Created"
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLivro(@PathVariable Long id, @RequestBody Livro livroDetails) { // Alterado para updateLivro
        livroService.updateLivro(id, livroDetails); // Alterado para livroService
        return new ResponseEntity<>("Livro Updated", HttpStatus.OK); // Alterado para "Livro Updated"
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLivro(@PathVariable Long id) { // Alterado para deleteLivro
        livroService.deleteLivro(id); // Alterado para livroService
        return new ResponseEntity<>("Livro Deleted", HttpStatus.OK); // Alterado para "Livro Deleted"
    }
}
