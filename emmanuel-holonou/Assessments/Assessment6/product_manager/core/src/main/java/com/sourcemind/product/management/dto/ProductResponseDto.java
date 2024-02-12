package com.sourcemind.product.management.dto;

import com.sourcemind.product.management.domain.Tag;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductResponseDto {
    private String name;
    private String description;
    private List<String> tags;
    private String ownerName;
    private String imageBlob;

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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getImageBlob() {
        return imageBlob;
    }

    public void setImageBlob(String imageBlob) {
        this.imageBlob = imageBlob;
    }
}
