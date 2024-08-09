package com.rihejiu.nustarlib;

import com.rihejiu.nustarlib.menu.MenuManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class NuStarLib extends JavaPlugin {
    private static MenuManager menuManager;
    private static NuStarLib instance;
    public void console(String msg){
        Bukkit.getConsoleSender().sendMessage(msg);
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        console("§3 _   _       ____  _             _     _ _     ");
        console("§3| \\ | |_   _/ ___|| |_ __ _ _ __| |   (_) |__  ");
        console("§3|  \\| | | | \\___ \\| __/ _` | '__| |   | | '_ \\ ");
        console("§3| |\\  | |_| |___) | || (_| | |  | |___| | |_) |");
        console("§3|_| \\_|\\__,_|____/ \\__\\__,_|_|  |_____|_|_.__/ ");
        instance = this;
        File testMenu = new File(getDataFolder(),"testMenu.yml");
        if (!testMenu.exists()) {
            saveResource("testMenu.yml",false);
        }
        getServer().getPluginCommand("nustarlib").setExecutor(new Commands());
        loadManager();
        console("§a[NuStarLib]核心库已加载");
        console("§a[NuStarLib]by NuStar");
    }
    public void loadManager() {
        menuManager = new MenuManager();
    }
    public static NuStarLib getInstance() {
        return instance;
    }
    public MenuManager getMenuManager() {
        return menuManager;
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
