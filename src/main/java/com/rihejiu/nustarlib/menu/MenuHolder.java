package com.rihejiu.nustarlib.menu;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class MenuHolder implements InventoryHolder {
    private Inventory inventory;
    private AbsNuStarGui absNuStarGui;
    public String getMenuType() {
        return menuType;
    }

    private final String menuType;

    /**
     *
     * @param menuType 菜单名称
     * @param inventory 打开的原版inv
     */
    public MenuHolder(String menuType, Inventory inventory){
        this.inventory = inventory;
        this.menuType = menuType;
    }

    /**
     * 重载方法
     * 用于ClickEvent获取打开的GUI对象
     * @param menuHolder templateInventory的MenuHolder
     * @param gui   GUI对象传参
     */
    public MenuHolder(MenuHolder menuHolder,AbsNuStarGui gui) {
        this.inventory = menuHolder.getInventory();
        this.menuType = menuHolder.getMenuType();
        this.absNuStarGui = gui;
    }
    public MenuHolder(String menuType) {
        this.menuType = menuType;
    }

    public AbsNuStarGui getAbsNuStarGui() {
        return absNuStarGui;
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
