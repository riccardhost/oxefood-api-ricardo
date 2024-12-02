package br.com.ifpe.oxefood.modelo.vendas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class VendasService {
    
@Autowired //instancia um obj do tipo repositório
private VendasRepository repository;

    @Transactional //Abre um bloco de transação no banco de dados
    public Vendas save(Vendas vendas) {

        vendas.setHabilitado(Boolean.TRUE);
        return repository.save(vendas);

    }

    public List<Vendas> listarTodos() {
  
        return repository.findAll();
    }

    public Vendas obterPorID(Long id) {

        return repository.findById(id).get();
    }   
    
    @Transactional
    public void update(Long id, Vendas vendasAlterado) {

        Vendas vendas = repository.findById(id).get();
        vendas.setCliente(vendasAlterado.getCliente());
        vendas.setProduto(vendasAlterado.getProduto());
        vendas.setStatusVenda(vendasAlterado.getStatusVenda());
        vendas.setDataVenda(vendasAlterado.getDataVenda());
        vendas.setValorTotal(vendasAlterado.getValorTotal());
        vendas.setObservacao(vendasAlterado.getObservacao());
        vendas.setRetiradaEmLoja(vendasAlterado.getRetiradaEmLoja());

        repository.save(vendas);

    }

    @Transactional
    public void delete(Long id) {

        Vendas vendas = repository.findById(id).get();
        vendas.setHabilitado(Boolean.FALSE);

        repository.save(vendas);
        
    }

}
