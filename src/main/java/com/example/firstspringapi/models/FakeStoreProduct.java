package com.example.firstspringapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class FakeStoreProduct {
    @Id
    private Long id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;
}
