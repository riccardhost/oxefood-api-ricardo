package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat; //Esta relacionado ao formato JSON da DATA DE NASCIMENTO

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
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
public class EntregadorRequest {

   @NotNull(message = "O Nome é de preenchimento obrigatório")
   @NotEmpty(message = "O Nome é de preenchimento obrigatório")
   @Length(max = 100, message = "O Nome deverá ter no máximo {max} caracteres")
   private String nome;

   @NotBlank(message = "O CPF é de preenchimento obrigatório")
   @CPF
   private String cpf;

   @NotBlank(message = "Por favor, informe o RG")
   private String rg;

   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate dataNascimento;
   
   @Length(min = 11, max = 15, message = "O campo Fone tem que ter entre {min} e {max} caracteres")
   @NotBlank(message = "Por favor, informe o numero do celular")
   private String foneCelular;

   @NotBlank(message = "Por favor, informe o numero do fixo")
   private String foneFixo;

   @NotBlank(message = "Por favor, informe a quantidade de entrega")
   private Integer quantidadeEntrega;
   
   @NotBlank(message = "Por favor, informe o valor do frete")
   private Double valorFrete;

   @NotBlank(message = "Por favor, informe o endereço")
   private String endereco;

   @NotBlank(message = "Por favor, informe o número")
   private String numero;

   @NotBlank(message = "Por favor, informe o bairro")
   private String bairro;

   @NotBlank(message = "Por favor, informe o cidade")
   private String cidade;

   @NotBlank(message = "Por favor, informe o CEP")
   private String cep;

   @NotBlank(message = "Por favor, informe o estado")
   private String uf;

   @NotBlank(message = "Por favor, informe o complemento")
   private String complemento;

   private Boolean ativo;

   public Entregador build() {

       return Entregador.builder()
            .nome(nome)
            .cpf(cpf)
            .rg(rg)
            .dataNascimento(dataNascimento)
            .foneCelular(foneCelular)
            .foneFixo(foneFixo)
            .quantidadeEntrega(quantidadeEntrega)
            .valorFrete(valorFrete)
            .endereco(endereco)
            .numero(numero)
            .bairro(bairro)
            .cidade(cidade)
            .cep(cep)
            .uf(uf)
            .complemento(complemento)
            .ativo(ativo)
            .build();
   }

}
