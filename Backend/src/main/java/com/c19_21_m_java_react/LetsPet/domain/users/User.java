package com.c19_21_m_java_react.LetsPet.domain.users;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "users")
@Entity(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    public User(RegisterUser registerUser) {
        this.name = registerUser.name();
        this.email = registerUser.email();
        this.password = registerUser.password();
    }

}
