package br.com.ifpe.oxefood.modelo.entregador;

import java.time.LocalDate;
import org.hibernate.annotations.SQLRestriction;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity /* Ela transforma essa classe */
@Table(name = "Entregador") /* Essa classe cria uma tabela no BD */
@SQLRestriction("habilitado = true") /* Vai acrescentar todas as consultas na tabela Cliente */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Entregador extends EntidadeAuditavel {
    
    @Column(nullable = false, length = 100)
    private String nome;

    @Column(unique = true)
    private String cpf;

    @Column
    private String rg;

    @Column
    private LocalDate dataNascimento;

    @Column
    private String foneCelular;

    @Column
    private String foneFixo;

    @Column
    private Integer quantidadeEntrega;

    @Column
    private Double valorFrete;

    @Column
    private String endereco;

    @Column
    private String numero;

    @Column
    private String bairro;

    @Column
    private String cidade;

    @Column
    private String cep;

    @Column
    private String uf;

    @Column
    private String complemento;

    @Column
    private Boolean ativo;

}
