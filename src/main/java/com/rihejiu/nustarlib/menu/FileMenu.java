package com.rihejiu.nustarlib.menu;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class FileMenu {
    private final Inventory inventory;
    public FileMenu(Inventory inventory, String title) {
        this.inventory = inventory;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    private final String title;
    public Inventory getInventory() {
        return inventory;
    }
    public void open(Player player) {
        player.openInventory(this.inventory);
    }
}
