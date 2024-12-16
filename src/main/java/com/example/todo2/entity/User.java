package com.example.todo2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true, length = 30)
    private String username;

    @NotBlank
    @Email
    @Column(length = 50)
    private String email;

    public User (String username, String email) {
        this.username = username;
        this.email = email;
    }

    public User() {

    }
}
