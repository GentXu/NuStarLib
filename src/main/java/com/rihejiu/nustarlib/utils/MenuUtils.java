package com.rihejiu.nustarlib.utils;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Dye;

import java.util.List;

public class MenuUtils {
    public static ItemStack menuItem(Material material, String name, List<String> lore){
        ItemStack menuItem = new ItemStack(material);
        ItemMeta itemMeta = menuItem.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);
        menuItem.setItemMeta(itemMeta);
        return menuItem;
    }
    public static ItemStack menuItemWithColor(DyeColor dyeColor, Material material, String name, List<String> lore){
        Dye dye = new Dye();
        dye.setColor(dyeColor);
        ItemStack menuItemWithColor = dye.toItemStack(1);
        menuItemWithColor.setType(material);
        ItemMeta itemMeta = menuItemWithColor.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);
        menuItemWithColor.setItemMeta(itemMeta);
        return menuItemWithColor;
    }
}
