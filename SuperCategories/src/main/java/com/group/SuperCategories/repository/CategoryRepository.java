package com.group.SuperCategories.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.group.SuperCategories.model.dao.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {
}