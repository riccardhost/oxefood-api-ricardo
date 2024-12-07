package br.com.ifpe.oxefood.modelo.cliente;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.exception.EntidadeNaoEncontradaException;
import br.com.ifpe.oxefood.util.exception.ClienteException;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired //instancia um obj do tipo repositório
    private ClienteRepository repository;

    @Transactional //Abre um bloco de transação no banco de dados
    public Cliente save(Cliente cliente) {

        if (!cliente.getFoneCelular().startsWith("(81)")) {
            throw new ClienteException(ClienteException.MSG_DDD_PERNAMBUCO);
        }
    
        cliente.setHabilitado(Boolean.TRUE);
        return repository.save(cliente);

    }

    public List<Cliente> listarTodos() {
  
        return repository.findAll();
    }

    public Cliente obterPorID(Long id) {

       Optional<Cliente> consulta = repository.findById(id);
  
       if (consulta.isPresent()) {
           return consulta.get();
       } else {
           throw new EntidadeNaoEncontradaException("Cliente", id);
       }
    }

    @Transactional
    public void update(Long id, Cliente clienteAlterado) {

        Cliente cliente = repository.findById(id).get();
        cliente.setNome(clienteAlterado.getNome());
        cliente.setDataNascimento(clienteAlterado.getDataNascimento());
        cliente.setCpf(clienteAlterado.getCpf());
        cliente.setFoneCelular(clienteAlterado.getFoneCelular());
        cliente.setFoneFixo(clienteAlterado.getFoneFixo());

        repository.save(cliente);

    }

    @Transactional
    public void delete(Long id) {

        Cliente cliente = repository.findById(id).get();
        cliente.setHabilitado(Boolean.FALSE);

        repository.save(cliente);
        
    }

}
