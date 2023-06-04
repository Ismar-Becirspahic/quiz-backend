package com.example.historyquizappbackend.models;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nickname")
    private String nickname;
    @Column(name = "points")
    private int points;
}
