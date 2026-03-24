package com.fumagalli.gerenciamento_categorias.repositories;

import com.fumagalli.gerenciamento_categorias.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
}
