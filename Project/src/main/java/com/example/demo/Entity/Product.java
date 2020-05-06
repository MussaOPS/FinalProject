package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "category", "user"})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;
    private String productName;
    private String description;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryID")
    private Category category;

    @ToString.Exclude
    @OneToMany(mappedBy = "product")
    private List<User> user;

    public Product(String productName, String description, Category category) {
        this.productName = productName;
        this.description = description;
        this.category = category;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product productID=" + productID +
                "\nproductName='" + productName + '\'' +
                "\ndescription='" + description + '\'' +
                '}';
    }
}
