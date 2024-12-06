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

   @NotBlank(message = "O código é de preenchimento obrigatório")
   @Length(min = 4, message = "O título deverá ter no máximo {min} caracteres")
   @Length(max = 10, message = "O título deverá ter no máximo {max} caracteres")
   private String codigoProduto;

   @NotBlank(message = "A descrição é de preenchimento obrigatório")
   private String descricao;

   @NotBlank(message = "Por favor, informe o valor")
   private Double valorUnitario;

   @NotBlank(message = "Por favor, informe o tempo mínimo")
   private Integer tempoMinEntrega;

   @NotBlank(message = "Por favor, informe o tempo máximo")
   private Integer tempoMaxEntrega;

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
