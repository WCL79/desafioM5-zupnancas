package br.com.zup.zup.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data//O @Data contem todos
@NoArgsConstructor//Construtor sem argumentos
@AllArgsConstructor//Construtor com todos argumentos
@Entity
@Table(name = "creditos")
public class Credito {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double valor;

    @Column(length = 150)
    private String descricao;
    @Column(length = 150)
    private LocalDate dataDeEntrada;

    @ManyToOne(optional = false)
    private Saldo saldo;

    @ManyToMany
    private List<Categoria> categorias;
}
