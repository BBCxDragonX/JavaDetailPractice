package com.dreamboat.practiceModel;

import com.amazonaws.services.glue.model.Order;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Orders {
    private Integer id;
    private String items;
    private double total;

    public Orders(Integer id,String items, double total){
        this.id = id;
        this.items = items;
        this.total = total;
    }
}
