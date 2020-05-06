package com.example.demo.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storageID;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "warehouseID")
    private Warehouse warehouse;

    public Storage(User user, Warehouse warehouse) {
        this.user = user;
        this.warehouse = warehouse;
    }

}
