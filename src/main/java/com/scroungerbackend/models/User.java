package com.scroungerbackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "userName"),
      @UniqueConstraint(columnNames = "userEmail")
    })
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String userEmail;

  @NotBlank
  @Size(max = 120)
  private String userPassword;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(  name = "user_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
  @ToString.Exclude
  private Set<Role> roles = new HashSet<>();

  public User(String username, String userEmail, String userPassword) {
    this.username = username;
    this.userEmail = userEmail;
    this.userPassword = userPassword;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    User user = (User) o;
    return userId != null && Objects.equals(userId, user.userId);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
