package br.com.zup.zup.controllers;


import br.com.zup.zup.dto.credito.RegistrarCreditoDTO;
import br.com.zup.zup.models.Credito;
import br.com.zup.zup.services.CreditoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("creditos/")
public class CreditoController {

    @Autowired
    private CreditoService creditoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Credito registrarCredito(@RequestBody @Valid RegistrarCreditoDTO registrarCreditoDTO){
        return creditoService.adicionarNovoCredito(modelMapper.map(registrarCreditoDTO, Credito.class));
    }
}
