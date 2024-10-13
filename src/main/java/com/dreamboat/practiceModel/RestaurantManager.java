package com.dreamboat.practiceModel;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter@Getter
public class RestaurantManager {
    private Map<Integer,Double> MenuItems;
    private Map<Integer,Double> orders;
    private int calculations;
}
