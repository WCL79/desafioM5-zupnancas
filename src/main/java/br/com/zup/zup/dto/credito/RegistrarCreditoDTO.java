package br.com.zup.zup.dto.credito;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data//O @Data contem todos
@NoArgsConstructor//Construtor sem argumentos
@AllArgsConstructor//Construtor com todos argumentos
public class RegistrarCreditoDTO {


    @NotNull(message = "O campo valor não foi informado")
    private Double valor;

    @NotNull(message = "O campo descricacao não foi informado")
    @NotEmpty(message = "O descricacao está vazio!")
    private String descricacao;

    @NotNull(message = "O campo cpf não foi informado")
    @NotEmpty(message = "O cpf está vazio!")
    @CPF(message = "O CPF informado é inválido!")
    private String cpf;
}
