package dev.nvnk.SmallStore.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "company")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String cnpj;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "created_at", updatable = false, insertable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
}