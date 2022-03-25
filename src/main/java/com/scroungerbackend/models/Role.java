//package com.scroungerbackend.models;
//
//import com.scroungerbackend.constants.ERole;
//import jakarta.persistence.*;
//import lombok.*;
//import org.hibernate.Hibernate;
//
//import java.util.Objects;
//
//@Entity
//@Table(name = "roles")
//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
//public class Role {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer roleId;
//
//    @Enumerated(EnumType.STRING)
//    @Column(length = 20)
//    private ERole roleName;
//
//    public Role(ERole roleName) {
//        this.roleName = roleName;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
//            return false;
//        Role role = (Role) o;
//        return roleId != null && Objects.equals(roleId, role.roleId);
//    }
//
//    @Override
//    public int hashCode() {
//        return getClass().hashCode();
//    }
//}