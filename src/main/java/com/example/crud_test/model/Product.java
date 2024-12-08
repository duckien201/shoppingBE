package com.example.crud_test.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User shop;   // id người bán

    private String name;

    @ElementCollection
    private List<String> image;

    private String material;
    private double price;
    private int sale;    // sale bao nhieu %
    private int remain;
    private int numberOfSale;

    private int star;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Lob
    @Size(max = 10000)
    private String description;

    private String status;
    private String reasonReject;
}
