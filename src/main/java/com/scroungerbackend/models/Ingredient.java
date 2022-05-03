package com.scroungerbackend.models;

import java.sql.Clob;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ingredients")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Ingredient {

}
