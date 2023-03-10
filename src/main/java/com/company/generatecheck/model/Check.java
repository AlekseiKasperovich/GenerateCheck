package com.company.generatecheck.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
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
    private BigDecimal taxablePrice;

    @Column(nullable = false)
    private BigDecimal tax;

    @Column(nullable = false)
    private BigDecimal priceWithTax;

    private BigDecimal wholesaleDiscount;

    private BigDecimal promotionalDiscount;

    @Column(nullable = false)
    private BigDecimal totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private DiscountCard discountCard;

    @OneToMany
    @Builder.Default
    private Set<Item> items = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Check check = (Check) o;
        return id.equals(check.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
