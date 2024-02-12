package com.sourcemind.product.management.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tag", schema = "public")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "product_id",
            nullable = false
    )
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(id, tag.id) && Objects.equals(type, tag.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }
}
