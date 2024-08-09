package com.rihejiu.nustarlib.menu;

import org.bukkit.inventory.Inventory;

public interface Menu {
    void open();
    void build(Inventory components);
    Inventory toBukkitInventory();
}
