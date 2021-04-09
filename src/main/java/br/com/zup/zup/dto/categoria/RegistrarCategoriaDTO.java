package br.com.zup.zup.dto.categoria;

import br.com.zup.zup.models.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data//O @Data contem todos
@NoArgsConstructor//Construtor sem argumentos
@AllArgsConstructor//Construtor com todos argumentos
public class RegistrarCategoriaDTO {

    @NotNull(message = "O campo nome não foi informado!")
    @NotEmpty(message = "O campo nome está vazio!")
    @NotBlank(message = "O campo nome está em branco")
    private String nome;

    /*
    public Categoria converterCadastrarCategoriaDtoParaCategoria() {
        Categoria categoria = new Categoria();
        categoria.setNome(this.nome);
        return categoria;
    }*/
}
