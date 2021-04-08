package br.com.zup.zup.controllers;

import br.com.zup.zup.dto.categoria.RegistrarCategoriaDTO;
import br.com.zup.zup.models.Categoria;
import br.com.zup.zup.services.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("categorias/")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RegistrarCategoriaDTO registrarCategoria(@RequestBody @Valid Categoria categoria,
                                                    RegistrarCategoriaDTO registrarCategoria){
        modelMapper.map(categoria, RegistrarCategoriaDTO.class);
        return registrarCategoria;
    }

}
