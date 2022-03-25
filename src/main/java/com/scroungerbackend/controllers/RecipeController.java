package com.scroungerbackend.controllers;

import com.scroungerbackend.client.SpoonacularClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    SpoonacularClient spoonacularClient;

    @GetMapping("/search")
    public List<String> getRecipeInformationInstructions(@RequestParam String ingredients, @RequestParam int numberOfIngredients) throws URISyntaxException {
        return spoonacularClient.getRecipesInformationInstructions(ingredients, numberOfIngredients);
    }

    @GetMapping("/test")
    public void test() {
        System.out.println("testing things");
    }
}
