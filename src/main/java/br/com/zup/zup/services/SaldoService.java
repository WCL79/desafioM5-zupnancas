package br.com.zup.zup.services;

import br.com.zup.zup.models.Saldo;
import br.com.zup.zup.repositories.SaldoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaldoService {

    @Autowired
    private SaldoRepository saldoRepository;


    public SaldoService(SaldoRepository saldoRepository) {
        this.saldoRepository = saldoRepository;
    }
    public Saldo registrarSaldo(Saldo saldo) {
        return saldoRepository.save(saldo);
    }

    public Saldo buscarPorCpf(Saldo saldo){
        Optional<Saldo> optionalSaldo= saldoRepository.findById(saldo.getCpf());
        return optionalSaldo.orElseThrow( () -> new RuntimeException("Cpf não existe!") );
    }
}
