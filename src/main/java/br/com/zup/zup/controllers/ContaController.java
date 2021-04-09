package br.com.zup.zup.controllers;

import br.com.zup.zup.dto.conta.AtulizarContaDTO;
import br.com.zup.zup.dto.conta.RegistrarContaDTO;
import br.com.zup.zup.models.Conta;
import br.com.zup.zup.services.ContaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/contas/")
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

    @PutMapping
    public ResponseEntity<Conta> atualizar(@RequestBody AtulizarContaDTO atulizarContaDTO) {
       Conta conta = contaService.atualizarConta(modelMapper.map(atulizarContaDTO, Conta.class));
       return ResponseEntity.ok().body(conta);
    }
}

/*
            if( optionalConta.isPresent() ) {
            BeanUtils.copyProperties(conta, optionalConta.get(), "id");
            //cli é o objeto que buscamos na base de dados
            return ResponseEntity.ok( contaService.regitrarConta(optionalConta.get()) );
        }
        return ResponseEntity.notFound().build();
 */