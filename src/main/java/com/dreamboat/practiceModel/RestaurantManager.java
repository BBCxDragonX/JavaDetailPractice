package com.dreamboat.practiceModel;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter@Getter
public class RestaurantManager {
    private List<MenuItems> MenuItems;
    private List<Orders> orders;
    private int calculations;
}
