package br.com.ifpe.oxefood.modelo.produto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.exception.EntidadeNaoEncontradaException;
import br.com.ifpe.oxefood.util.exception.ProdutoException;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

@Autowired //instancia um obj do tipo repositório
private ProdutoRepository repository;

    @Transactional //Abre um bloco de transação no banco de dados
    public Produto save(Produto produto) {

        if (produto.getValorUnitario() < 100) {
            throw new ProdutoException(ProdutoException.MSG_VALOR_MINIMO_PRODUTO);
        }
    
        produto.setHabilitado(Boolean.TRUE);
        return repository.save(produto);
    }

    public List<Produto> listarTodos() {
  
        return repository.findAll();
    }

    public Produto obterPorID(Long id) {

            Optional<Produto> consulta = repository.findById(id);
        
            if (consulta.isPresent()) {
                return consulta.get();
            } else {
                throw new EntidadeNaoEncontradaException("Produto", id);
            }
    }

    @Transactional
    public void update(Long id, Produto produtoAlterado) {

        Produto produto = repository.findById(id).get();
        produto.setCodigo(produtoAlterado.getCodigo());
        produto.setCategoriaProduto(produtoAlterado.getCategoriaProduto());
        produto.setTitulo(produtoAlterado.getTitulo());
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
