package br.com.zup.zup.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data//O @Data contem todos
@NoArgsConstructor//Construtor sem argumentos
@AllArgsConstructor//Construtor com todos argumentos
public class SaldoDTO {

    @NotNull(message = "O campo cpf deve ser informado!")
    @NotEmpty(message = "o campo cpf está vazio")
    @CPF(message = "CPF inválido!")
    private String cpf;

    @NotNull(message = "O campo valor deve ser informado!")
    private Double valor;

    @NotNull(message = "O campo limite deve ser informado!")
    @Min(value = 0, message = "o valor do limite deve ser maior do que zero!")
    private Double limite;
}
