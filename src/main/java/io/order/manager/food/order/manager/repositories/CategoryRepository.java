package io.order.manager.food.order.manager.repositories;

import io.order.manager.food.order.manager.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
