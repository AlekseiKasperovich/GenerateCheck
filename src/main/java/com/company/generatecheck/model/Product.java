package com.company.generatecheck.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer price;

}
