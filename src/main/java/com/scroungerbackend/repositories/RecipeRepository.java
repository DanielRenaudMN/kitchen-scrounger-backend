package com.scroungerbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scroungerbackend.models.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}