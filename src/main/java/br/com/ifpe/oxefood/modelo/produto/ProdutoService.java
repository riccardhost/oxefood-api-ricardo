package br.com.ifpe.oxefood.modelo.produto;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoService {
    
@Autowired //instancia um obj do tipo repositório
private ProdutoRepository repository;

    @Transactional //Abre um bloco de transação no banco de dados
    public Produto save(Produto produto) {

       produto.setHabilitado(Boolean.TRUE);
       return repository.save(produto);
    }

    public List<Produto> listarTodos() {
  
        return repository.findAll();
    }

    public Produto obterPorID(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Produto produtoAlterado) {

        Produto produto = repository.findById(id).get();
        produto.setTitulo(produtoAlterado.getTitulo());
        produto.setCodigoProduto(produtoAlterado.getCodigoProduto());
        produto.setDescricao(produtoAlterado.getDescricao());
        produto.setValorUnitario(produtoAlterado.getValorUnitario());
        produto.setTempoMinEntrega(produtoAlterado.getTempoMinEntrega());
        produto.setTempoMaxEntrega(produtoAlterado.getTempoMaxEntrega());

        repository.save(produto);

    }

    @Transactional
    public void delete(Long id) {

        Produto produto = repository.findById(id).get();
        produto.setHabilitado(Boolean.FALSE);

        repository.save(produto);
        
    }

}
