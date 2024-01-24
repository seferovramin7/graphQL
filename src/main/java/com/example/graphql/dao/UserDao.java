package com.example.graphql.dao;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "graph_user")
@Data
@Entity
public class UserDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long userId;
    private String name;
    private String surname;
}
