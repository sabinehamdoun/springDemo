package com.example.demo;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "user")
@Entity
@Getter
@Setter
class User {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Basic@Column(name="name")
    private String name;

    @Basic@Column(name="age")
    private Integer age;

    @Basic@Column(name="active")
    private Boolean active;

    @Basic@Column(name="password")
    private String password;
}
