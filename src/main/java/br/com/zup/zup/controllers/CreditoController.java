package br.com.zup.zup.controllers;


import br.com.zup.zup.dto.credito.RegistrarCreditoDTO;
import br.com.zup.zup.models.Credito;
import br.com.zup.zup.services.CreditoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("creditos/")
public class CreditoController {

    @Autowired
    private CreditoService creditoService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//usar padrão dto na sala de aula
    public RegistrarCreditoDTO registrarCredito(@RequestBody @Valid RegistrarCreditoDTO registrarCreditoDTO){
        Credito credito = creditoService.cadastrarCredito(registrarCreditoDTO.converterCadastrarCreditoDtoParaCredito());
        return RegistrarCreditoDTO.converterModelParaDTO(credito);
    }

    @GetMapping
    public List<Credito> buscarTodos() {
        return creditoService.pesquisarTodosCreditos();
    }
}
