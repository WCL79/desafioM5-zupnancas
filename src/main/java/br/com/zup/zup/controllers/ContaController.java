package br.com.zup.zup.controllers;

import br.com.zup.zup.dto.conta.RegistrarContaDTO;
import br.com.zup.zup.models.Conta;
import br.com.zup.zup.services.ContaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("contas/")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Conta registrarConta(@RequestBody @Valid RegistrarContaDTO registrarContaDTO){
        return contaService.regitrarConta(registrarContaDTO.converterDTOParaModel());
    }
}
