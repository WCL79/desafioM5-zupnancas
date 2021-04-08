package br.com.zup.zup.services;

import br.com.zup.zup.enumerator.Status;
import br.com.zup.zup.models.Conta;
import br.com.zup.zup.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private  ContaRepository contaRepository;

    @Autowired
    private  SaldoService saldoService;

    public Conta regitrarConta(Conta conta) {
        consultarSituacao(conta.getStatus());
        return contaRepository.save(conta);
    }

    public void consultarSituacao(Status status) {
        if (status.equals(Status.PAGO)) {
            throw new RuntimeException("O status deve ser apenas ARGUARDANDO OU ATRASADO!");
        }
    }

    public Conta pesquisarContaPorId(Conta conta) {
        Optional<Conta> optionalConta = contaRepository.findById(conta.getId());

        return optionalConta.orElseThrow( () -> new RuntimeException("Id não existe!") );
    }
}
