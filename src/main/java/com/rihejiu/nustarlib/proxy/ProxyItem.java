package com.rihejiu.nustarlib.proxy;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ProxyItem extends ItemStack{
    private final ItemStack itemStack;
    protected ItemMeta itemMeta;
    public ProxyItem(ItemStack itemStack){
        this.itemStack = itemStack;
    }

    @Override
    public ItemMeta getItemMeta(){
        return itemStack.getItemMeta();
    }
    @Override
    public Material getType(){
        return itemStack.getType();
    }
    public boolean checkItemIsNotNull(){
        return itemStack == null || getItemMeta() == null;
    }
    public static boolean takeItem(Player player, String item, int amount){
        Inventory inv = player.getInventory();
        int amount2 = 0;
        for (ItemStack itemStack : inv.getContents()){
            if (itemStack != null) {
                ItemMeta itemMeta = itemStack.getItemMeta();
                if (itemMeta != null && itemMeta.hasDisplayName() && itemMeta.getDisplayName().contains(item)){
                    int itemAmount = itemStack.getAmount();
                    if (itemAmount >= amount){
                        itemStack.setAmount(itemAmount - amount);
                        return true;
                    } else {
                        amount2 += itemAmount;
                    }
                }
            }
        }
        if (amount2 >= amount){
            for (ItemStack itemStack : inv.getContents()){
                if (itemStack != null){
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    if (itemMeta != null && itemMeta.hasDisplayName() && itemMeta.getDisplayName().contains(item)){
                        int itemAmount = itemStack.getAmount();
                        if (amount >= itemAmount) {
                            amount -= itemAmount;
                            itemStack.setAmount(0);
                        } else {
                            itemStack.setAmount(itemAmount-amount);
                            break;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
    public static int checkItem(Player player,String itemName){
        int count = 0;
        Inventory inv = player.getInventory();
        for (ItemStack itemStack: inv.getContents()){
            if (itemStack != null){
                ItemMeta itemMeta = itemStack.getItemMeta();
                if (itemMeta != null && itemMeta.hasDisplayName() && itemMeta.getDisplayName().contains(itemName)){
                    count += itemStack.getAmount();
                }
            }
        }
        return count;
    }
}
