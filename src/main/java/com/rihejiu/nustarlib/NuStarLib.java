package com.rihejiu.nustarlib;

import com.rihejiu.nustarlib.listeners.Monitor;
import com.rihejiu.nustarlib.managers.MenuManager;
import com.rihejiu.nustarlib.utils.web.HttpType;
import com.rihejiu.nustarlib.utils.web.NuStarHTTP;
import com.rihejiu.nustarlib.utils.web.OkHttp;
import com.rihejiu.nustarlib.utils.web.UnirestHttp;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.openjdk.nashorn.api.scripting.NashornScriptEngineFactory;

import javax.script.ScriptEngineManager;
import java.io.File;

public final class NuStarLib extends JavaPlugin {
    private static MenuManager menuManager;
    private static NuStarLib instance;
    private NuStarHTTP nustarHTTP;
    private Object scriptEngine;
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
        loadLibrary();
        if (Bukkit.getVersion().contains("1.12") || Bukkit.getVersion().contains("1.8")) {
            ScriptEngineManager manager = new ScriptEngineManager();
            scriptEngine = manager.getEngineByName("JavaScript");
        } else {
            NashornScriptEngineFactory factory = new NashornScriptEngineFactory();
            scriptEngine = factory.getScriptEngine();
        }
        instance = this;
        File testMenu = new File(getDataFolder(),"testMenu.yml");
        if (!testMenu.exists()) {
            saveResource("testMenu.yml",false);
        }
        getServer().getPluginManager().registerEvents(new Monitor(), this);
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
    private void loadLibrary() {
        nustarHTTP = new UnirestHttp();
    }
    public NuStarHTTP getNuStarHTTP(HttpType type) {
        if (type == HttpType.OKHTTP) {
            nustarHTTP = new OkHttp();
        } else if (type == HttpType.UNIREST) {
            nustarHTTP = new UnirestHttp();
        }
        return nustarHTTP;
    }
    public Object getScriptEngine() {
        return scriptEngine;
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
