package com.rihejiu.nustarlib.listeners;

import com.rihejiu.nustarlib.event.ClickEvent;
import com.rihejiu.nustarlib.event.CloseEvent;
import com.rihejiu.nustarlib.menu.MenuHolder;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class Monitor implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getInventory().getHolder() instanceof MenuHolder) {
            MenuHolder menuHolder = (MenuHolder) event.getInventory().getHolder();
            Bukkit.getPluginManager().callEvent(new ClickEvent(event,menuHolder.getMenuType(), menuHolder.getAbsNuStarGui()));
        }
    }
    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        if (event.getInventory().getHolder() instanceof MenuHolder) {
            Bukkit.getPluginManager().callEvent(new CloseEvent(event,((MenuHolder)event.getInventory().getHolder()).getMenuType()));
        }
    }
}
