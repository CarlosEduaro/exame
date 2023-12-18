package com.example.exame.Service;


import com.example.exame.Entity.Autor;
import com.example.exame.Repository.AutorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Tag(name = "Livros", description = "Contém todas as operações que podem ser realizadas em um livro.")
public class AutorService {

    private final AutorRepository autorRepository;

    @Autowired
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> getAllAutor() {
        return autorRepository.findAll();
    }

    public Autor getAutorById(Long id) {
        Optional<Autor> optionalAutor = autorRepository.findById(id);
        return optionalAutor.orElse(null);
    }

    public void createAutor(Autor autor) {
        autorRepository.save(autor);
    }

    public void updateAutor(Long id, Autor autorDetails) {
        Optional<Autor> optionalAutor = autorRepository.findById(id);
        if (optionalAutor.isPresent()) {
            Autor autor = optionalAutor.get();
            autorRepository.save(autor);
        }
    }

    public void deleteAutor(Long id) {
        autorRepository.deleteById(id);
    }
}



