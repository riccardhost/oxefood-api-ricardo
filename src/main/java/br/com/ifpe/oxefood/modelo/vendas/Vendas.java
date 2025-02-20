package br.com.ifpe.oxefood.modelo.vendas;

import java.time.LocalDate;
import org.hibernate.annotations.SQLRestriction; /* Todas as anotações do JPA devem ser importadas do pacote */
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity; /* Todas as anotações do JPA devem ser importadas do pacote */
import jakarta.persistence.Table; /* Todas as anotações do JPA devem ser importadas do pacote */
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity /* Ela transforma essa classe ...*/
@Table(name = "Vendas") /* Essa classe cria uma tabela no BD */
@SQLRestriction("habilitado = true") /* Vai acrescentar todas as consultas na tabela Cliente */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vendas extends EntidadeAuditavel {

    @Column /* Faz com que crie uma coluna na tabela do BD */
    private String cliente;

    @Column
    private String produto;

    @Column
    private String statusVenda;

    @Column
    private LocalDate dataVenda;

    @Column
    private Double valorTotal;

    @Column
    private String observacao;

    @Column
    private Boolean retiradaEmLoja;

}
