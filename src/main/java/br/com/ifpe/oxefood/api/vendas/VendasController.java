package br.com.ifpe.oxefood.api.vendas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.vendas.Vendas;
import br.com.ifpe.oxefood.modelo.vendas.VendasService;
import jakarta.validation.Valid;

@RestController //API REQUEST
@RequestMapping("/api/vendas")
@CrossOrigin //
public class VendasController { //classe da Api que define a rota das vendas

    @Autowired //cria um objt automaticamente 
    private VendasService vendasService;

    @PostMapping //
    public ResponseEntity<Vendas> save(@RequestBody @Valid VendasRequest request) {

        Vendas vendas = vendasService.save(request.build());
        return new ResponseEntity<>(vendas, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Vendas> listarTodos() {
        return vendasService.listarTodos();
    }

    @GetMapping("/{id}")
    public Vendas obterPorID(@PathVariable Long id) {
        return vendasService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendas> update(@PathVariable("id") Long id, @RequestBody VendasRequest request) {

        vendasService.update(id, request.build());
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        vendasService.delete(id);
        return ResponseEntity.ok().build();
    
   }

}
