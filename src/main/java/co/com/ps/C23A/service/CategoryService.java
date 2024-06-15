package co.com.ps.C23A.service;

import co.com.ps.C23A.domain.Category;
import co.com.ps.C23A.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryService implements ICategoryService{

    private final CategoryRepository categoryRepository;
    @Override
    @Transactional (readOnly = true)
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional (readOnly = true)
    public Category findById(Long idCategory) {
        Optional<Category> categoryTmp = categoryRepository.findById(idCategory);
        if (categoryTmp.isPresent()) {
            return categoryTmp.get();
        }else {
            throw new RuntimeException("Category not found" + idCategory);
        }
    }

    @Transactional (readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    @Transactional (readOnly = false, propagation = Propagation.REQUIRED)
    public Category update(Category category) {
        if (categoryRepository.existsById(category.getCategoryId())){
            return categoryRepository.save(category);}
        else {
            throw new RuntimeException("Category not found with id: " + category.getCategoryId());
        }};

    @Override
    @Transactional (readOnly = true)
    public Optional<Category> findByName(String name) {
        return categoryRepository.findByCategoryName(name);
    }

    @Override
    public void delete(Long idCategory) {
        if (categoryRepository.existsById(idCategory)) {
            categoryRepository.deleteById(idCategory);
        }
        else {throw new RuntimeException("Category not found with id: " + idCategory);}
    }
}