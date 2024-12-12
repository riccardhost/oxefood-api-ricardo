package br.com.ifpe.oxefood.api.produto;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

   private Long idCategoriaProduto;

   @NotBlank(message = "O código é de preenchimento obrigatório")
   private String codigo;

   @NotBlank(message = "O titulo é de preenchimento obrigatório")
   private String titulo;

   @NotBlank(message = "A descrição é de preenchimento obrigatório")
   private String descricao;

   private Double valorUnitario;

   private Integer tempoMinEntrega;

   private Integer tempoMaxEntrega;

   public Produto build() {

       return Produto.builder()
        .codigo(codigo)
        .titulo(titulo)
        .descricao(descricao)
        .valorUnitario(valorUnitario)
        .tempoMinEntrega(tempoMinEntrega)
        .tempoMaxEntrega(tempoMaxEntrega)
        .build();
   }
}
