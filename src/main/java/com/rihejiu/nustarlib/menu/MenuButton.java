package com.rihejiu.nustarlib.menu;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class MenuButton {
    public String getName() {
        return name;
    }

    public String getMaterial() {
        return material;
    }

    public List<String> getLore() {
        return lore;
    }

    public int getData() {
        return data;
    }

    private final String name;
    private final String material;
    private final List<String> lore;
    private int data;
    public MenuButton(ConfigurationSection section) {
        this.name = section.getString("name");
        this.material = section.getString("material");
        this.lore = section.getStringList("lore");
        this.data = section.getInt("data", 0);
    }
    public ItemStack crate() {
        ItemStack itemStack = new ItemStack(Material.getMaterial(this.material.toUpperCase()));
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(this.name);
        itemMeta.setLore(this.lore);
        itemStack.setItemMeta(itemMeta);
        itemStack.setDurability((short) data);
        return itemStack;
    }
}
