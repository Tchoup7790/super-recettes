package com.group.SuperRecipes.service;
import com.group.SuperRecipes.model.dao.Category;
import com.group.SuperRecipes.model.dto.CreateCategoryInput;
import com.group.SuperRecipes.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public List<Category> findAll() {
        return repo.findAll();
    }

    public Category save(CreateCategoryInput input) {
        Category newCategory = Category.builder()
                .name(input.name())
                .build();

        return repo.save(newCategory);
    }

    public Optional<Category> findById(String id) {
        return repo.findById(id);
    }

    public void delete(String id) {
        repo.deleteById(id);
    }
}