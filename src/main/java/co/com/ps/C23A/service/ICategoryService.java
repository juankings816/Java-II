package co.com.ps.C23A.service;

import co.com.ps.C23A.domain.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {

    Category findById(Long idCategory);
    Optional<Category> findByName(String nombre);
    List<Category> findAll();
    Category save(Category category);
    Category update(Category category);
    void delete(Long idCategory);
}