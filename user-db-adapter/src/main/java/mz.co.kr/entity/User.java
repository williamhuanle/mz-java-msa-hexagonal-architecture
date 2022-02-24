package mz.co.kr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mz.co.kr.auth.domain.enums.OAuth2Provider;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Email
    @Column(nullable = false)
    private String email;
    private String imageUrl;
    @Column(nullable = false)
    private Boolean emailVerified = false;
    private String password;
    @NotNull
    @Enumerated(EnumType.STRING)
    private OAuth2Provider provider;
    private String providerId;

}
