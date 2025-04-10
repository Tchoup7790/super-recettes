package com.group.SuperRecipes.repository;
import com.group.SuperRecipes.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}