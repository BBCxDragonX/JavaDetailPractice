package com.dreamboat.serviceNmain;

import com.dreamboat.practiceModel.MenuItems;
import com.dreamboat.practiceModel.Orders;
import com.dreamboat.practiceModel.RestaurantManager;

public class RestaurantService {
    Orders orders = new Orders();
    MenuItems mitems = new MenuItems();
    RestaurantManager RM = new RestaurantManager();
    Double totalBill;

    public String toOrdersString(){
        return orders.getId()+"\n"+orders.getItems()+"\n"+orders.getTotal();
    }
    public String toMenuItems(){
        return mitems.getId()+"\n"+mitems.getName()+"\n"+mitems.getDescription()+"\n"+mitems.getPrice();
    }


}
