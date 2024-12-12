package br.com.ifpe.oxefood.api.vendas;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat; //Esta relacionado ao formato JSON da DATA DE NASCIMENTO

import br.com.ifpe.oxefood.modelo.vendas.Vendas;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendasRequest {

    private String cliente;

    private String produto;

    private String statusVenda;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVenda;

    private Double valorTotal;

    private String observacao;

    private Boolean retiradaEmLoja;

    public Vendas build() {

        return Vendas.builder()
                .cliente(cliente)
                .produto(produto)
                .statusVenda(statusVenda)
                .dataVenda(dataVenda)
                .valorTotal(valorTotal)
                .observacao(observacao)
                .retiradaEmLoja(retiradaEmLoja)
                .build();
    }
}
