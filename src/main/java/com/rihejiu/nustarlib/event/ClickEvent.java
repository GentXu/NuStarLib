package com.rihejiu.nustarlib.event;

import com.rihejiu.nustarlib.menu.AbsNuStarGui;
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
    private final AbsNuStarGui absNuStarGui;
    public String getMenuType() {
        return menuType;
    }

    public AbsNuStarGui getAbsNuStarGui() {
        return absNuStarGui;
    }

    public ItemStack getCurrentItem() {
        return currentItem;
    }

    public Player getPlayer() {
        return player;
    }

    private final ItemStack currentItem;

    private final Player player;
    public ClickEvent(InventoryClickEvent origin,String menuType, AbsNuStarGui gui) {
        this.origin = origin;
        this.absNuStarGui = gui;
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
