package com.scroungerbackend.client;

import com.scroungerbackend.models.Recipe;
import com.scroungerbackend.models.RecipeInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class SpoonacularClient {
    @Value("${rapidapi.key.name}")
    private String apiKey;

    @Value("${rapidapi.key.value}")
    private String apiKeyValue;

    private static final String URL = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes";

    @Autowired
    RestTemplate restTemplate;

    public List<String> getRecipesInformationInstructions(String ingredients, int numberOfRecipes) throws URISyntaxException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(apiKey, apiKeyValue);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        List<Long> recipeIds = getRecipeIds(ingredients, numberOfRecipes, httpEntity);
        List<String> recipeInformationInstructions = new ArrayList<>();

        for(Long recipeId : recipeIds) {
            ResponseEntity<RecipeInformation> recipeInformation = restTemplate.exchange(
                    new URI(URL + "/" + recipeId + "/information"),
                    HttpMethod.GET,
                    httpEntity,
                    RecipeInformation.class
            );

            if (recipeInformation.getBody() == null) {
                return Collections.emptyList();
            }

            recipeInformationInstructions.add(recipeInformation.getBody().getInstructions());
        }

        return recipeInformationInstructions;
    }

    private List<Long> getRecipeIds(String ingredients, int numberOfRecipes, HttpEntity httpEntity) throws URISyntaxException {
        ResponseEntity<Recipe[]> recipes = restTemplate.exchange(
                new URI(URL + "/findByIngredients?ingredients=" + ingredients + "&number=" + numberOfRecipes),
                HttpMethod.GET,
                httpEntity,
                Recipe[].class
        );

        List<Long> recipeIds = new ArrayList<>();
        if (recipes.getBody() == null) {
            return Collections.emptyList();
        }

        for (Recipe recipe : recipes.getBody()) {
            recipeIds.add(recipe.getId());
        }

        return recipeIds;
    }
}
