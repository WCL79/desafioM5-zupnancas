package br.com.zup.zup.repositories;

import br.com.zup.zup.models.Saldo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaldoRepository extends JpaRepository<Saldo, String> {
}
