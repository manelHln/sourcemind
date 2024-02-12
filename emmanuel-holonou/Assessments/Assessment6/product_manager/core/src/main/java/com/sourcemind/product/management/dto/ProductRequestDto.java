package com.sourcemind.product.management.dto;

import com.sourcemind.product.management.domain.Tag;

import java.util.HashSet;
import java.util.Set;

public class ProductRequestDto {
    private String name;
    private String description;
    private String ownerName;
    private Set<Tag> tags = new HashSet<>();

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

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "ProductRequestDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", tags=" + tags +
                '}';
    }
}