package br.com.ifpe.oxefood.modelo.entregador;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EntregadorService {

    @Autowired //instancia um obj do tipo repositório
    private EntregadorRepository repository;

    @Transactional //Abre um bloco de transação no banco de dados
    public Entregador save(Entregador entregador) {

        entregador.setHabilitado(Boolean.TRUE);
        return repository.save(entregador);
    }

    public List<Entregador> listarTodos() {
  
        return repository.findAll();
    }

    public Entregador obterPorID(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Entregador entregadorAlterado) {

        Entregador entregador = repository.findById(id).get();
        entregador.setNome(entregadorAlterado.getNome());
        entregador.setCpf(entregadorAlterado.getCpf());
        entregador.setRg(entregadorAlterado.getRg());
        entregador.setDataNascimento(entregadorAlterado.getDataNascimento());
        entregador.setFoneCelular(entregadorAlterado.getFoneCelular());
        entregador.setFoneFixo(entregadorAlterado.getFoneFixo());
        entregador.setQuantidadeEntrega(entregadorAlterado.getQuantidadeEntrega());
        entregador.setValorFrete(entregadorAlterado.getValorFrete());
        entregador.setEndereco(entregadorAlterado.getEndereco());
        entregador.setNumero(entregadorAlterado.getNumero());
        entregador.setBairro(entregadorAlterado.getBairro());
        entregador.setCidade(entregadorAlterado.getCidade());
        entregador.setCep(entregadorAlterado.getCep());
        entregador.setUf(entregadorAlterado.getUf());
        entregador.setComplemento(entregadorAlterado.getComplemento());
        entregador.setAtivo(entregadorAlterado.getAtivo());

        repository.save(entregador);

    }
    
    @Transactional
    public void delete(Long id) {

        Entregador entregador = repository.findById(id).get();
        entregador.setHabilitado(Boolean.FALSE);

        repository.save(entregador);
        
    }
   
}
