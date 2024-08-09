package com.rihejiu.nustarlib.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public abstract class AbstractMenu implements Menu {
    protected Player owner;
    protected Inventory components;
    protected int size;
    protected String title;
    protected String menuId;
    public AbstractMenu(Player player, int size, String title, String menuId){
        this.owner = player;
        this.size = size;
        this.title = title;
        this.menuId = menuId;
        this.components = Bukkit.createInventory(new MenuHolder(this,menuId), size,title);
    }
    @Override
    public void open() {
        owner.openInventory(components);
    }
    @Override
    public Inventory toBukkitInventory(){
        return components;
    }
}
