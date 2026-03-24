package com.fumagalli.gerenciamento_categorias.services;

import com.fumagalli.gerenciamento_categorias.model.CategoriaModel;
import com.fumagalli.gerenciamento_categorias.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<CategoriaModel> findAll(){
        return categoriaRepository.findAll();
    }

    public CategoriaModel criarCategoria(CategoriaModel categoriaModel){
        return categoriaRepository.save(categoriaModel);
    }

    public Optional<CategoriaModel> buscarPorId(Long id){
        return categoriaRepository.findById(id);
    }

    public CategoriaModel atualizar(long id, CategoriaModel categoriaModel){
        CategoriaModel model = categoriaRepository.findById(id).get();
        model.setNome(categoriaModel.getNome());
        model.setDescricao(categoriaModel.getDescricao());

        return categoriaRepository.save(model);
    }

    public void deletar(Long id){
        categoriaRepository.deleteById(id);
    }

}
