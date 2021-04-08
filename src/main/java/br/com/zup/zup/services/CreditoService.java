package br.com.zup.zup.services;


import br.com.zup.zup.models.Credito;
import br.com.zup.zup.repositories.CreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CreditoService {

    @Autowired
    private final CreditoRepository creditoRepository;
    @Autowired
    private final SaldoService saldoService;


    public CreditoService(CreditoRepository creditoRepository, SaldoService saldoService) {
        this.creditoRepository = creditoRepository;
        this.saldoService = saldoService;
    }

    public Credito adicionarNovoCredito(Credito credito) {
        credito.setDataDeEntrada(LocalDate.now());
        Credito novoCredito = creditoRepository.save(credito);
        saldoService.atualizarSaldo(novoCredito);
        return novoCredito;
    }
}
