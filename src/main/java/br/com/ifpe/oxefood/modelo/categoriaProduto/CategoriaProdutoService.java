package br.com.ifpe.oxefood.modelo.categoriaProduto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.exception.EntidadeNaoEncontradaException;
import jakarta.transaction.Transactional;

@Service
public class CategoriaProdutoService {
    
 @Autowired //instancia um obj do tipo repositório
    private CategoriaProdutoRepository repository;

    @Transactional //Abre um bloco de transação no banco de dados
    public CategoriaProduto save(CategoriaProduto categoriaProduto) {

        categoriaProduto.setHabilitado(Boolean.TRUE);
        return repository.save(categoriaProduto);

    }

    public List<CategoriaProduto> listarTodos() {
  
        return repository.findAll();
    }

    public CategoriaProduto obterPorID(Long id) {

       Optional<CategoriaProduto> consulta = repository.findById(id);
  
       if (consulta.isPresent()) {
           return consulta.get();
       } else {
           throw new EntidadeNaoEncontradaException("CategoriaProduto", id);
       }
    }

    @Transactional
    public void update(Long id, CategoriaProduto categoriaProdutoAlterado) {

        CategoriaProduto categoriaProduto = repository.findById(id).get();
        categoriaProduto.setDescricao(categoriaProdutoAlterado.getDescricao());
    
        repository.save(categoriaProduto);

    }

    @Transactional
    public void delete(Long id) {

        CategoriaProduto categoriaProduto = repository.findById(id).get();
        categoriaProduto.setHabilitado(Boolean.FALSE);

        repository.save(categoriaProduto);
        
    }

}
