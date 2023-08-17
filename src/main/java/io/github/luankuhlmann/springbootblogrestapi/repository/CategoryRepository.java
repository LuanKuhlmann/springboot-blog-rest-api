package io.github.luankuhlmann.springbootblogrestapi.repository;

import io.github.luankuhlmann.springbootblogrestapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
