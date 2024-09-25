package com.rihejiu.nustarlib.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Map;

public class FileMenu {
    private final Inventory inventory;
    public FileMenu(Inventory inventory, String title, Map<String, MenuButton> buttons) {
        this.inventory = inventory;
        this.title = title;
        this.buttons = buttons;
    }

    public Map<String, MenuButton> getButtons() {
        return buttons;
    }

    private final Map<String, MenuButton> buttons;
    public String getTitle() {
        return title;
    }
    public Inventory cloneInventory() {
        Inventory cloneInv = Bukkit.createInventory(inventory.getHolder(), inventory.getSize(), getTitle());
        cloneInv.setContents(inventory.getContents());
        return cloneInv;
    }
    private final String title;
    public Inventory getInventory() {
        return inventory;
    }
    public void open(Player player) {
        player.openInventory(this.inventory);
    }
}
