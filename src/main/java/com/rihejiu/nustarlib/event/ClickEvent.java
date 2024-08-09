package com.rihejiu.nustarlib.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ClickEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final InventoryClickEvent origin;
    public InventoryClickEvent getOrigin(){return origin;}
    private final String menuType;

    public String getMenuType() {
        return menuType;
    }

    public ItemStack getCurrentItem() {
        return currentItem;
    }

    public Player getPlayer() {
        return player;
    }

    private final ItemStack currentItem;

    private final Player player;
    public ClickEvent(InventoryClickEvent origin,String menuType) {
        this.origin = origin;
        this.currentItem = origin.getCurrentItem();
        this.player = (Player) origin.getWhoClicked();
        this.menuType = menuType;
    }
    public void setCancelled(boolean cancel) {
        origin.setCancelled(cancel);
    }

    public boolean isCancelled() {
        return origin.isCancelled();
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
