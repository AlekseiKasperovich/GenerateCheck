package com.company.generatecheck.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "checks")
public class Check {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String cashier;

    @Column(nullable = false)
    private LocalDateTime printed;

    @Column(nullable = false)
    private Integer taxablePrice;

    @Column(nullable = false)
    private Integer tax;

    @Column(nullable = false)
    private Integer totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private DiscountCard discountCard;

    @OneToMany
    private Set<Item> items = new HashSet<>();

}
