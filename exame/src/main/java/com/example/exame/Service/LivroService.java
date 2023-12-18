package com.example.exame.Service;

import com.example.exame.Entity.Livro;
import com.example.exame.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> getAllLivros() {
        return livroRepository.findAll();
    }

    public Livro getLivroById(Long id) {
        Optional<Livro> optionalLivro = livroRepository.findById(id);
        return optionalLivro.orElse(null);
    }

    public Livro createLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro updateLivro(Long id, Livro livroDetails) {
        Optional<Livro> optionalLivro = livroRepository.findById(id);
        if (optionalLivro.isPresent()) {
            Livro livro = optionalLivro.get();
            livro.setTitulo(livroDetails.getTitulo());
            livro.setDescricao(livroDetails.getDescricao());
            return livroRepository.save(livro);
        }
        return null;
    }

    public void deleteLivro(Long id) {
        livroRepository.deleteById(id);
    }
}
