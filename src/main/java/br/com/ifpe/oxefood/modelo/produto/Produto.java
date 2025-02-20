package br.com.ifpe.oxefood.modelo.produto;

import org.hibernate.annotations.SQLRestriction; /* Todas as anotações do JPA devem ser importadas do pacote */

import br.com.ifpe.oxefood.modelo.categoriaProduto.CategoriaProduto;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity; /* Todas as anotações do JPA devem ser importadas do pacote */
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table; /* Todas as anotações do JPA devem ser importadas do pacote */
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity /* Ela transforma essa classe */
@Table(name = "Produto") /* Essa classe cria uma tabela no BD */
@SQLRestriction("habilitado = true") /* Vai acrescentar todas as consultas na tabela Cliente */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto extends EntidadeAuditavel {
    
    @ManyToOne
    private CategoriaProduto categoriaProduto;

    @Column /* Faz com que crie uma coluna na tabela do BD */
    private String titulo;

    @Column
    private String codigo;

    @Column
    private String descricao;

    @Column
    private Double valorUnitario;

    @Column
    private Integer tempoMinEntrega;

    @Column
    private Integer tempoMaxEntrega;

}
