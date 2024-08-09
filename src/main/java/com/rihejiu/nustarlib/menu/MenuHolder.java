package com.rihejiu.nustarlib.menu;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class MenuHolder implements InventoryHolder {
    public Menu getMenu() {
        return menu;
    }

    private Menu menu;

    public String getMenuType() {
        return menuType;
    }

    private final String menuType;
    public MenuHolder(Menu menu,String menuType){
        this.menu = menu;
        this.menuType = menuType;
    }
    public MenuHolder(String menuType) {
        this.menuType = menuType;
    }
    @Override
    public Inventory getInventory() {
        return menu.toBukkitInventory();
    }
}
