package br.com.zup.zup.repositories;

import br.com.zup.zup.enumerator.Status;
import br.com.zup.zup.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ContaRepository extends JpaRepository<Conta, Integer> {
    Iterable<Conta> findByStatus(Status status);
}
