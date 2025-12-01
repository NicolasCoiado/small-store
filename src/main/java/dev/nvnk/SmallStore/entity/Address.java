package dev.nvnk.SmallStore.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String cep;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "states")
    private States state;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String neighborhood;
    @Column(nullable = false)
    private String number;
}
