package br.com.ifpe.oxefood.api.produto;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

   private String titulo;

   private String codigoProduto;

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
