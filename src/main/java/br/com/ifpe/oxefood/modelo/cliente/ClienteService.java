package br.com.ifpe.oxefood.modelo.cliente;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    @Autowired //instancia um obj do tipo repositório
    private ClienteRepository repository;

    @Transactional //Abre um bloco de transação no banco de dados
    public Cliente save(Cliente cliente) {

        cliente.setHabilitado(Boolean.TRUE);
        return repository.save(cliente);

    }

    public List<Cliente> listarTodos() {
  
        return repository.findAll();
    }

    public Cliente obterPorID(Long id) {

        return repository.findById(id).get();
    }   
    
}


