package br.com.zup.zup.services;

import br.com.zup.zup.models.Conta;
import br.com.zup.zup.models.Credito;
import br.com.zup.zup.models.Saldo;
import br.com.zup.zup.repositories.SaldoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaldoService {

    @Autowired
    private final SaldoRepository saldoRepository;


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

    public void atualizarSaldo(Credito credito){
        Saldo saldo  = buscarPorCpf(credito.getSaldo());
        Double valor = saldo.getValor();
        valor += credito.getValor();
        saldo.setValor(valor);
        registrarSaldo(saldo);
    }

    public void debitarSaldo(Conta contaAntiga) {
        Saldo sadoRecebe = buscarPorCpf(contaAntiga.getSaldo());
        Double limite = sadoRecebe.getLimite() + sadoRecebe.getValor();
        if(limite > contaAntiga.getValor()){
            Double valorAtualizado = sadoRecebe.getValor() - contaAntiga.getValor();
            sadoRecebe.setValor(valorAtualizado);
            saldoRepository.save(sadoRecebe);
        }
    }
}
