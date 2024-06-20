package org.example.aws_sample.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.aws_sample.dto.User.UserCreateDto;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false, unique = true, length = 10)
    private String id;

    @Column(nullable = false, length = 10)
    private String password;

    @Column(nullable = false, length = 10)
    private String name;

    @Column(length = 30)
    private String email;

    public User(UserCreateDto userCreateDto) {
        this.id = userCreateDto.getId();
        this.password = userCreateDto.getPassword();
        this.name = userCreateDto.getUsername();
        this.email = userCreateDto.getEmail();
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
