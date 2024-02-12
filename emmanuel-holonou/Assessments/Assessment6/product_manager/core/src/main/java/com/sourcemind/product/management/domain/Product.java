package com.sourcemind.product.management.domain;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "product", schema = "public")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image_blob_id", nullable = false)
    private String imageBlobId;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Tag> tags;

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    @Column(name = "owner_username")
    private String ownerUsername;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageBlobId() {
        return imageBlobId;
    }

    public void setImageBlobId(String imageBlobId) {
        this.imageBlobId = imageBlobId;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(imageBlobId, product.imageBlobId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, imageBlobId);
    }
}
