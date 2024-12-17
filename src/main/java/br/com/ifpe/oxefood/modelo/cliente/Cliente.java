package br.com.ifpe.oxefood.modelo.cliente;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;
import java.time.LocalDate;
import org.hibernate.annotations.SQLRestriction; /* Todas as anotações do JPA devem ser importadas do pacote */

import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column; /* Todas as anotações do JPA devem ser importadas do pacote */
import jakarta.persistence.Entity; /* Todas as anotações do JPA devem ser importadas do pacote */
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table; /* Todas as anotações do JPA devem ser importadas do pacote */
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity /* Ela transforma essa classe */
@Table(name = "Cliente") /* Essa classe cria uma tabela no BD */
@SQLRestriction("habilitado = true") /* Vai acrescentar todas as consultas na tabela Cliente */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends EntidadeAuditavel {

    @OneToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "cliente", orphanRemoval = true, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<EnderecoCliente> enderecos;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column /* Faz com que crie uma coluna na tabela do BD */
    private LocalDate dataNascimento;

    @Column(unique = true)
    private String cpf;

    @Column
    private String foneCelular;

    @Column
    private String foneFixo;

}
