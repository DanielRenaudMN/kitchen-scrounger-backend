package com.scroungerbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scroungerbackend.models.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
