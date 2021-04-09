package br.com.zup.zup.repositories;

import br.com.zup.zup.models.Credito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CreditoRepository extends JpaRepository<Credito, Integer> {
}
