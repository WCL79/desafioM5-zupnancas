package br.com.zup.zup.controllers;


import br.com.zup.zup.services.CreditoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("creditos/")
public class CreditoController {

    @Autowired
    private CreditoService creditoService;

    @Autowired
    private ModelMapper modelMapper;


}
