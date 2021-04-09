package br.com.zup.zup.dto.conta;

import br.com.zup.zup.enumerator.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotNull;



@Data//O @Data contem todos
@NoArgsConstructor//Construtor sem argumentos
@AllArgsConstructor//Construtor com todos argumentos
public class AtulizarContaDTO {

    @NotNull(message = "O campo status não foi informado!")
    private Integer id;

    @NotNull(message = "O campo status não foi informado!")
    private Status status;
}
