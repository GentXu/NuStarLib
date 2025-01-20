package com.rihejiu.nustarlib.menu;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class MenuHolder implements InventoryHolder {
    private Inventory inventory;

    public String getMenuType() {
        return menuType;
    }

    private final String menuType;
    public MenuHolder(String menuType, Inventory inventory){
        this.inventory = inventory;
        this.menuType = menuType;
    }
    public MenuHolder(String menuType) {
        this.menuType = menuType;
    }
    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
