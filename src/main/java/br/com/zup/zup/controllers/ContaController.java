package br.com.zup.zup.controllers;

import br.com.zup.zup.dto.conta.AtulizarContaDTO;
import br.com.zup.zup.dto.conta.RegistrarContaDTO;
import br.com.zup.zup.enumerator.Status;
import br.com.zup.zup.models.Conta;
import br.com.zup.zup.models.Saldo;
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
    public RegistrarContaDTO registrarConta(@RequestBody @Valid RegistrarContaDTO registrarContaDTO){
        Conta conta = contaService.regitrarConta(registrarContaDTO.converterDTOParaModel());
        return RegistrarContaDTO.converterModelParaDTO(conta);
    }

    @PutMapping
    public ResponseEntity<Conta> atualizar(@RequestBody AtulizarContaDTO atulizarContaDTO) {
       Conta conta = contaService.atualizarConta(modelMapper.map(atulizarContaDTO, Conta.class));
       return ResponseEntity.ok().body(conta);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Conta> visualizarStuacao(@RequestParam (name = "status")Status status) {
        return contaService.buscaPorStatus(status);
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