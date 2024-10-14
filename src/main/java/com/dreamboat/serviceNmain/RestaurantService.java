package com.dreamboat.serviceNmain;

import com.dreamboat.practiceModel.MenuItems;
import com.dreamboat.practiceModel.Orders;
import com.dreamboat.practiceModel.RestaurantManager;

import java.util.*;

public class RestaurantService {


    private final List<MenuItems> menuItems;  // Use final for immutable data
    private final Map<Orders, List<MenuItems>> orders;  // Use final for immutable data
    private Double totalBill;

    public RestaurantService() {
        this.menuItems = this.addItems(); // Initialize in constructor for single instance
        this.orders = new HashMap<>(); // Initialize in constructor for single instance
    }

    public String toOrdersString(Orders orders) {
        return orders.getId() + "\n" + orders.getItems() + "\n" + orders.getTotal();
    }

    public String toMenuItems(MenuItems menutems) {
        return "ItemName: " + menutems.getName() + "\nDescription: " + menutems.getDescription() + "\nPrice: " + menutems.getPrice();
    }

    private List<MenuItems> addItems() {
        List<MenuItems> menu = new ArrayList<>(); // Create list locally to avoid redundant instantiation
        menu.add(new MenuItems(1,"Chicken Biryani",200.0,"spicy chicken boneless piece with BASMATI rice"));
        menu.add(new MenuItems(2,"Chicken Mandi",200.0,"Juicy Al-Fahm piece with BASMATI rice"));
        menu.add(new MenuItems(3,"Chicken Frankie",90.0,"Butter chicken boneless pieces with cheese rolled between indian bread"));
        menu.add(new MenuItems(4,"Chicken Spicy Roll",60.0,"spicy chicken boneless strips dry between bun"));
        menu.add(new MenuItems(5,"Chicken Home made andhra Curry",90.0,"spicy chicken curry with homemade recipe"));
        menu.add(new MenuItems(6,"Egg 65",180.0,"Our most special item, which has the crunchy,spicy taste"));
        return menu;
    }

    public int chooseOptionFromMenu() {
        System.out.println("Enter the number beside your selected item to add it to the order or enter '0' ");
        for (MenuItems menutems : menuItems) {
            System.out.printf("%d,%s,price=%.1f,description=%s\n", menutems.getId(), menutems.getName(), menutems.getPrice(), menutems.getDescription());
        }
        Scanner id = new Scanner(System.in);
        return id.nextInt();
    }

    public String getMenuItemwithId() {
        int id = chooseOptionFromMenu();
        for (MenuItems menutems : menuItems) {
            if (menutems.getId() == id) {
                return toMenuItems(menutems);
            }
        }
        return null;
    }

    public void writeItemToOrder(Orders order) {
        int itemenud = chooseOptionFromMenu();
        if (itemenud != 0) {
            MenuItems selectedItem = null;
            for (MenuItems menutems : menuItems) {
                if (menutems.getId() == itemenud) {
                    selectedItem = menutems;
                    break; // Exit loop after finding the item
                }
            }
            if (selectedItem != null) {
                List<MenuItems> orderItems = orders.getOrDefault(order, new ArrayList<>()); // Get existing or create new list
                orderItems.add(selectedItem);
                orders.put(order, orderItems); // Update map with potentially modified list
            }
        }
    }

    public static void main(String[] args) {
        RestaurantService rs = new RestaurantService();
        System.out.println(rs.getMenuItemwithId());
    }
}