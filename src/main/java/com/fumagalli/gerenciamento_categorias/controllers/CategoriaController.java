package com.fumagalli.gerenciamento_categorias.controllers;

import com.fumagalli.gerenciamento_categorias.model.CategoriaModel;
import com.fumagalli.gerenciamento_categorias.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaModel>> findAll(){
        List<CategoriaModel> requeste = categoriaService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    public ResponseEntity<CategoriaModel> criarCategoria(@RequestBody CategoriaModel categoriaModel){
        CategoriaModel novo = categoriaService.criarCategoria(categoriaModel);
        return ResponseEntity.status(201).body(novo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCategoria(@PathVariable Long id){
        categoriaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaModel> buscarPorIdCategoria(@PathVariable Long id){
        Optional<CategoriaModel> categoria = categoriaService.buscarPorId(id);

        if(categoria.isPresent()){
            return ResponseEntity.ok(categoria.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaModel> atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaModel categoriaModel){
        CategoriaModel atualizado = categoriaService.atualizar(id, categoriaModel);
        return ResponseEntity.ok().body(atualizado);
    }
}
