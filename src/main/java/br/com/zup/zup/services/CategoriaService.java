package br.com.zup.zup.services;

import br.com.zup.zup.models.Categoria;
import br.com.zup.zup.models.Conta;
import br.com.zup.zup.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Categoria pesquisarCategoriaPorId(Categoria categoria) {
        Optional<Categoria> optionalConta = categoriaRepository.findById(categoria.getId());

        return optionalConta.orElseThrow( () -> new RuntimeException("Id não existe!") );
    }

    public void deletarCategoria(Categoria categoria) {
        Categoria categoriaGravada = pesquisarCategoriaPorId(categoria);
        categoriaRepository.delete(categoriaGravada);
    }

    public void deletarCategoria(Integer id) {
        Categoria categoria = new Categoria();
        categoria.setId(id);
        deletarCategoria(categoria);
    }
}

