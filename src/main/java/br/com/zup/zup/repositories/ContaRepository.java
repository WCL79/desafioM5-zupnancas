package br.com.zup.zup.repositories;

import br.com.zup.zup.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Integer> {
}
