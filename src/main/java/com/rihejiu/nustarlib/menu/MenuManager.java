package com.rihejiu.nustarlib.menu;

import com.rihejiu.nustarlib.NuStarLib;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuManager {
    public Map<String, FileMenu> getMenuMap() {
        return this.menuMap;
    }
    private final Map<String, FileMenu> menuMap = new HashMap<>();
    public MenuManager() {
        addMenu(new File(NuStarLib.getInstance().getDataFolder(), "/testMenu.yml"));
    }
    public void addMenu(File menuFile) {
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(menuFile);
        String menuName = yamlConfiguration.getString("MenuName");
        List<String> layout = yamlConfiguration.getStringList("Layout");
        Inventory inventory = Bukkit.createInventory(new MenuHolder(menuName), layout.size() * 9, menuName);
        int line = 0;
        for (String layoutString : layout) {
            char[] buttons = layoutString.toCharArray();
            int index = 0;
            for (char button : buttons) {
                ConfigurationSection section = yamlConfiguration.getConfigurationSection("Buttons." + button);
                if (section != null) {
                    inventory.setItem(line * 9 + index, new MenuButton(section).crate());
                }
                index ++;
            }
            line ++;
        }
        this.menuMap.put(menuName, new FileMenu(inventory));
    }
    public void openMenu(String menuName, Player player) {
        this.menuMap.get(menuName).open(player);
    }
}
