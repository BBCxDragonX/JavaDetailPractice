package com.dreamboat.practiceModel;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MenuItems {
    private Integer Id;
    private String name;
    private double price;
    private String description;

    public MenuItems(Integer id, String name, Double price, String description) {
        this.Id = id;
        this.name = name;
        this.price = price;
        this.description = description;

    }
}