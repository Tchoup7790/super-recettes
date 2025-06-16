package com.group.SuperRecipes.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.group.SuperRecipes.model.dao.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {
}