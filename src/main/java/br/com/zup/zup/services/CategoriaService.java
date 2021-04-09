package br.com.zup.zup.services;

import br.com.zup.zup.models.Categoria;
import br.com.zup.zup.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria registrarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Iterable<Categoria> obterTodasCategorias() {
        return categoriaRepository.findAll();
    }
}

