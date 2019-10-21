package com.kkachniarz.springproject.models;

import java.util.UUID;

public class Product {
    public UUID id;
    public String name;

    public Product(UUID  id, String name) {
        this.id = id;
        this.name = name;
    }
}
