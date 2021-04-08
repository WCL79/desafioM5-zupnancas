package br.com.zup.zup.dto.conta;

import br.com.zup.zup.enumerator.Status;
import br.com.zup.zup.models.Conta;
import br.com.zup.zup.models.Saldo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data//O @Data contem todos
@NoArgsConstructor//Construtor sem argumentos
@AllArgsConstructor//Construtor com todos argumentos
public class RegistrarContaDTO {

    @NotNull(message = "O campo valor não foi informado!")
    private Double valor;

    @NotNull(message = "O campo descricacao não foi informado!")
    @NotEmpty(message = "O campo descricacao está vazio!")
    @NotBlank(message = "O campo descricacao está em branco!")
    private String descricacao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeSaida;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeVencimento;

    @NotNull(message = "O campo status não foi informado!")
    private Status status;

    @NotNull(message = "O campo cpf não foi informado!")
    @NotEmpty(message = "O campo cpf está vazio!")
    @NotBlank(message = "O campo cpf está em branco!")
    @CPF(message = "O CPF informado é invalido!")
    private String cpf;

    public Conta converterDTOParaModel(){
        Saldo saldo = new Saldo();
        Conta conta = new Conta();
        saldo.setCpf(this.cpf);
        conta.setSaldo(saldo);
        conta.setDescricacao(this.descricacao);
        conta.setValor(this.valor);
        conta.setDataDeSaida(this.dataDeSaida);
        conta.setDataDeVencimento(this.dataDeVencimento);
        conta.setStatus(this.status);
        return conta;
    }
}
