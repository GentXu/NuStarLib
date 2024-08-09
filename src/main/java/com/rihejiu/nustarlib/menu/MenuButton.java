package com.rihejiu.nustarlib.menu;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class MenuButton {
    private final String name;
    private final String material;
    private final List<String> lore;
    public MenuButton(ConfigurationSection section) {
        this.name = section.getString("name");
        this.material = section.getString("material");
        this.lore = section.getStringList("lore");
    }
    public ItemStack crate() {
        ItemStack itemStack = new ItemStack(Material.getMaterial(this.material.toUpperCase()));
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(this.name);
        itemMeta.setLore(this.lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
