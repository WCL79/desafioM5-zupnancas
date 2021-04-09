package br.com.zup.zup.exceptions;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data//O @Data contem todos
@NoArgsConstructor//Construtor sem argumentos
@AllArgsConstructor//Construtor com todos argumentos
public class RespostaDeErro {
    private String tipoDeErro;
    private int codigoDoErro;
    private String statusCode;
    private List<ObjetoDeErro> objetoDeErro;
}
