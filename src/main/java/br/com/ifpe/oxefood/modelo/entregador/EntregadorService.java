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
}
