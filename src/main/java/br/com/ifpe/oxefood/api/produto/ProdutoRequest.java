package br.com.ifpe.oxefood.api.produto;

import org.hibernate.validator.constraints.Length;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

   @NotNull(message = "O título é de preenchimento obrigatório")
   @NotEmpty(message = "O título é de preenchimento obrigatório")
   @Length(max = 50, message = "O título deverá ter no máximo {max} caracteres")
   private String titulo;

   private String codigoProduto;

   @NotBlank(message = "A descrição é de preenchimento obrigatório")
   private String descricao;

   private String valorUnitario;

   private String tempoMinEntrega;

   private String tempoMaxEntrega;

   public Produto build() {

       return Produto.builder()
           .titulo(titulo)
           .codigoProduto(codigoProduto)
           .descricao(descricao)
           .valorUnitario(valorUnitario)
           .tempoMinEntrega(tempoMinEntrega)
           .tempoMaxEntrega(tempoMaxEntrega)
           .build();
   }
}
