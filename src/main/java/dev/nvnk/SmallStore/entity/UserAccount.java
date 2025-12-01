package dev.nvnk.SmallStore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String cpf;
    @Column(nullable = false)
    private int role;
    @Column(nullable = false)
    private int company_id;

    @Column(name = "created_at", updatable = false, insertable = false)
    private LocalDateTime createdAt;
}
