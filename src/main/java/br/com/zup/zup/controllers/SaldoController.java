package br.com.zup.zup.controllers;

import br.com.zup.zup.dto.SaldoDTO;
import br.com.zup.zup.models.Saldo;
import br.com.zup.zup.services.SaldoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("saldos/")
public class SaldoController {

    @Autowired
    private SaldoService saldoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Saldo gravarNovoSaldo(@RequestBody @Valid SaldoDTO cadastrarSaldo) {
        Saldo saldo = saldoService.registrarSaldo(modelMapper.map(cadastrarSaldo, Saldo.class));
        return saldo;
    }
}
