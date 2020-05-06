package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "storage"})
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int warehouseID;
    private String warehouseType;
    private int amount;
    private boolean isAvailable = true;

    @ToString.Exclude
    @OneToMany(mappedBy = "warehouse")
    private List<Storage> storage;

    public Warehouse(String warehouseType, int amount, String description) {
        this.warehouseType = warehouseType;
        this.amount = amount;
    }

    public Warehouse() {
    }

    @Override
    public String toString() {
        return "Warehouse warehouseID=" + warehouseID +
                "\nwarehouseType='" + warehouseType + '\'' +
                "\namount='" + amount + '\'' +
                '}';
    }

}
