package com.rihejiu.nustarlib;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0) {
            commandSender.sendMessage("§a/nustarlib open <player> <menuname>");
            return true;
        }
        if (strings[0].equalsIgnoreCase("open")) {
            if (strings.length == 3) {
                NuStarLib.getInstance().getMenuManager().openMenu(strings[2], Bukkit.getPlayer(strings[1]));
                return true;
            }
        }
        if (strings[0].equalsIgnoreCase("test")) {
        }
        return true;
    }
}
