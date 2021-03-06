package br.com.zup.zup.controllers;

import br.com.zup.zup.dto.saldo.RegistrarSaldoDTO;
import br.com.zup.zup.models.Saldo;
import br.com.zup.zup.services.SaldoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/saldos/")
public class SaldoController {

    @Autowired
    private SaldoService saldoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Saldo registrarSaldo(@RequestBody @Valid RegistrarSaldoDTO cadastrarSaldo) {
        return saldoService.registrarSaldo(modelMapper.map(cadastrarSaldo, Saldo.class));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Saldo> visualizarTodasContas() {
        return saldoService.obterTodosSaldos();
    }

    @GetMapping("{cpf}/")
    public Saldo buscarSaldoPorCpf(@PathVariable Saldo cpf){
        Saldo saldo = saldoService.buscarPorCpf(cpf);
        modelMapper.map(saldo, SaldoController.class);
        return saldo;
    }
}
