package com.dreamboat.serviceNmain;

import com.dreamboat.practiceModel.MenuItems;
import com.dreamboat.practiceModel.Orders;
import com.dreamboat.practiceModel.RestaurantManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestaurantService {
    Orders orders = new Orders();
    MenuItems mitems;
    RestaurantManager RM = new RestaurantManager();
    List<MenuItems> MI = new ArrayList<>();
    List<Orders> Ord = new ArrayList<>();
    Double totalBill;

    public String toOrdersString(){
        return orders.getId()+"\n"+orders.getItems()+"\n"+orders.getTotal();
    }
    public String toMenuItems(){
        return mitems.getId()+"\n"+mitems.getName()+"\n"+mitems.getDescription()+"\n"+mitems.getPrice();
    }
    public List<MenuItems> additems(){
        MI.add(new MenuItems(1,"Chicken Biryani",200.0,"spicy chicken boneless piece with BASMATI rice"));
        MI.add(new MenuItems(2,"Chicken Mandi",200.0,"Juicy Al-Fahm piece with BASMATI rice"));
        MI.add(new MenuItems(3,"Chicken Frankie",90.0,"Butter chicken boneless pieces with cheese rolled between indian bread"));
        MI.add(new MenuItems(4,"Chicken Spicy Roll",60.0,"spicy chicken boneless strips dry between bun"));
        MI.add(new MenuItems(5,"Chicken Home made andhra Curry",90.0,"spicy chicken curry with homemade recipe"));
        MI.add(new MenuItems(6,"Egg 65",180.0,"Our most special item, which has the crunchy,spicy taste"));
        return MI;
    }
    public int ChooseOptionFromMenu(){
        System.out.println("Enter the number beside your selected item to add it to the order or enter '0' \n1,Chicken Biryan,price=200.0,description=spicy chicken boneless piece with BASMATI rice\n2,Chicken Mandi,price=200.0,Juicy Al-Fahm piece with BASMATI rice\n3,Chicken Frankie,90.0,Butter chicken boneless pieces with cheese rolled between indian bread\n4,Chicken Spicy Roll,60.0,spicy chicken boneless strips dry between bun\n5,Chicken Home made andhra Curry,90.0,spicy chicken curry with homemade recipe\n6,Egg 65,180.0,Our most special item, which has the crunchy,spicy taste");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }



}
