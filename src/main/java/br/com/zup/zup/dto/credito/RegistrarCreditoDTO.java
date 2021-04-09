package br.com.zup.zup.dto.credito;


import br.com.zup.zup.models.Categoria;
import br.com.zup.zup.models.Credito;
import br.com.zup.zup.models.Saldo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
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
    private String descricao;

    @NotNull(message = "O campo cpf não foi informado")
    @NotEmpty(message = "O cpf está vazio!")
    @CPF(message = "O CPF informado é inválido!")
    private String cpf;

    private List<Categoria> categorias;

    public Credito converterCadastrarCreditoDtoParaCredito() {
        Credito credito = new Credito();
        credito.setValor(this.valor);
        credito.setDescricao(this.descricao);
        Saldo saldo = new Saldo();
        saldo.setCpf(this.cpf);
        credito.setSaldo(saldo);
        credito.setCategorias(this.categorias);
        return credito;
    }

    public static  RegistrarCreditoDTO converterModelParaDTO(Credito credito){
        RegistrarCreditoDTO registrarCreditoDTO = new RegistrarCreditoDTO(
                credito.getValor(),
                credito.getDescricao(),
                credito.getSaldo().getCpf(),
                credito.getCategorias());
        return registrarCreditoDTO;
    }
}
