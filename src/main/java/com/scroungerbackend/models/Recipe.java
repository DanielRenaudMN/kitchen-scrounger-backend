package com.scroungerbackend.models;

import java.sql.Clob;
import java.util.Objects;
import java.util.Set;

import org.hibernate.Hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
		if (this == o)
			return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
			return false;
		Recipe recipe = (Recipe) o;
		return recipeId != null && Objects.equals(recipeId, recipe.recipeId);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	public Long getRecipeId() {

		return recipeId;
	}

	public void setRecipeId(Long recipeId) {
		this.recipeId = recipeId;
	}
}