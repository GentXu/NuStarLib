package com.rihejiu.nustarlib.managers;

import com.rihejiu.nustarlib.NuStarLib;
import com.rihejiu.nustarlib.menu.FileMenu;
import com.rihejiu.nustarlib.menu.MenuButton;
import com.rihejiu.nustarlib.menu.MenuHolder;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
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
        // 读取菜单文件
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(menuFile);
        String menuName = yamlConfiguration.getString("MenuName");
        List<String> layout = yamlConfiguration.getStringList("Layout");
        Inventory inventory = Bukkit.createInventory(new MenuHolder(menuName), layout.size() * 9, menuName);
        Map<String, MenuButton> menuButtons = new HashMap<>();
        int line = 0;
        // 遍历菜单布局
        for (String layoutString : layout) {
            // 将行字符串拆分成字符
            List<String> StringButtons = getStringButtons(layoutString);
            int index = 0;
            for (String button : StringButtons) {
                ConfigurationSection section = yamlConfiguration.getConfigurationSection("Buttons." + button);
                if (section != null) {
                    MenuButton menuButton = new MenuButton(section);
                    menuButtons.put(button, menuButton);
                    inventory.setItem(line * 9 + index, menuButton.crate());
                }
                index ++;
            }
            line ++;
        }
        this.menuMap.put(menuName, new FileMenu(inventory,menuName, menuButtons));
    }

    @NotNull
    private static List<String> getStringButtons(String layoutString) {
        char[] charButtons = layoutString.toCharArray();
        List<String> StringButtons = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        // 查到的第一个 ` 符号
        int index1 = 0;
        boolean isEnd = false;
        // 将所有字符添加到StringBuilder中
        for (char charButton : charButtons) {
            stringBuilder.append(charButton);
        }
        // 遍历字符找到字符串图标
        for (int i = 0; i < charButtons.length; i++) {
            if (index1 != 0 && charButtons[i] == '`') {
                isEnd = true;
                StringButtons.add(stringBuilder.substring(index1, i));
                index1 = 0;
                continue;
            }
            if (charButtons[i] == '`') {
                index1 = i + 1;
                continue;
            }
            if (index1 != 0 && !isEnd) {
                continue;
            }
            StringButtons.add(String.valueOf(charButtons[i]));
        }
        return StringButtons;
    }

    public void openMenu(String menuName, Player player) {
        this.menuMap.get(menuName).open(player);
    }
}
