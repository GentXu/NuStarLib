package com.rihejiu.nustarlib.menu;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class FileMenu {
    private final Inventory inventory;
    public FileMenu(Inventory inventory) {
        this.inventory = inventory;
    }
    public void open(Player player) {
        player.openInventory(this.inventory);
    }
}
