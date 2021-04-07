package br.com.zup.zup.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Data//O @Data contem todos
@NoArgsConstructor//Construtor sem argumentos
@AllArgsConstructor//Construtor com todos argumentos
@Entity
@Table(name = "creditos")
public class Credito {


    private Double valor;
    private String descricao;
    private LocalTime dataDeEntrada;


}
