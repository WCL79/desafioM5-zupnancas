package br.com.zup.zup.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data//O @Data contem todos
@NoArgsConstructor//Construtor sem argumentos
@AllArgsConstructor//Construtor com todos argumentos
@Entity
@Table(name = "saldos")
public class Saldo {

    @Id
    @Column(length = 20)
    private String cpf;
    private Double valor;
    private Double limite;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Saldo saldo = (Saldo) o;
        return Objects.equals(cpf, saldo.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}

