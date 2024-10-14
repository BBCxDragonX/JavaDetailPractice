package com.dreamboat.practiceModel;

import com.amazonaws.services.glue.model.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter@Getter
public class RestaurantManager {
    private List<MenuItems> MenuItems;
    private Map<Orders,List<MenuItems>> orders;
    private int calculations;
}
