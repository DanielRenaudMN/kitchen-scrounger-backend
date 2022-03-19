package com.scroungerbackend.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.sql.Clob;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "recipes")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeId;

    private String recipeName;

    private String sourceName;

    private String sourceUrl;

    private String imageUrl;

    private String imageType;

    private int recipeLikes;

    private int minutesRequired;

    @Lob
    private Clob recipeSummary;

    @Lob
    private Clob recipeInstructions;

    @ManyToMany(mappedBy = "userRecipes")
    private Set<User> users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        Recipe recipe = (Recipe) o;
        return recipeId != null && Objects.equals(recipeId, recipe.recipeId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}