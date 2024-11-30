package com.rihejiu.nustarlib.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.StringUtil;

import java.util.*;

public abstract class Command<T extends Plugin> implements TabExecutor {
    protected final T plugin;
    // 所有附属指令
    private final Map<String, Command<T>> subCommands = new HashMap<>();
    // 附属指令的别名
    private final Map<String, Command<T>> subCommandAliases = new HashMap<>();
    public Command(Command<T> parent) {
        this(parent.getPlugin());
    }
    public Command(T plugin) {
        this.plugin = plugin;
    }
    // 添加附属指令
    @SafeVarargs
    public final void addSubCommands(Command<T> ... commands) {
        for (Command<T> command : commands) {
            subCommands.put(command.getName(), command);
            for (String alias : command.getAliases()) {
                subCommandAliases.put(alias, command);
            }
        }
    }
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        // 权限检查
        if (getPermissionNode() != null && !sender.hasPermission(getPermissionNode())) {
            sender.sendMessage("§c你没有权限这么做！");
            return true;
        }
        // 玩家检查
        if (!isConsoleFriendly() && !(sender instanceof org.bukkit.entity.Player)) {
            sender.sendMessage("§c只有玩家能执行这条指令！");
            return true;
        }
        // 检查是否为子命令
        if (args.length > 0 && this.subCommands.get(args[0].toLowerCase()) != null) {
            Command<T> sub = this.subCommands.get(args[0].toLowerCase());
            return sub.onCommand(sender, cmd, label, Arrays.copyOfRange(args, 0, args.length));
        }
        // 检查是否为子命令的别名
        if (args.length > 0 && this.subCommandAliases.get(args[0].toLowerCase()) != null) {
            Command<T> sub = this.subCommandAliases.get(args[0].toLowerCase());
            return sub.onCommand(sender, cmd, label, Arrays.copyOfRange(args, 0, args.length));
        }
        return onCommand(sender, args);
    }
    @Override
    public List<String> onTabComplete(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        // 权限检查
        if (getPermissionNode() != null && !sender.hasPermission(getPermissionNode()))
            return null;
        // 检查是否为子命令
        if (args.length > 1 && this.subCommands.get(args[0].toLowerCase()) != null) {
            Command<T> sub = this.subCommands.get(args[0].toLowerCase());
            return sub.onTabComplete(sender, cmd, label, Arrays.copyOfRange(args, 0, args.length - 1));
        }
        // 检查是否为子命令的别名
        if (args.length > 1 && this.subCommandAliases.get(args[0].toLowerCase()) != null) {
            Command<T> sub = this.subCommandAliases.get(args[0].toLowerCase());
            return sub.onTabComplete(sender, cmd, label, Arrays.copyOfRange(args, 0, args.length - 1));
        }
        // 获取补全
        List<String> result = onTabComplete(sender, args);
        // 获取子命令
        if (result == null && args.length == 1) {
            result = new ArrayList<>();
            StringUtil.copyPartialMatches(args[0], this.subCommands.keySet(), result);
        }
        return result;
    }
    // 命令补全过程
    public abstract List<String> onTabComplete(CommandSender paramCommandSender, String[] paramArrayOfString);
    // 命令执行过程
    public abstract boolean onCommand(CommandSender paramCommandSender, String[] paramArrayOfString);
    // 权限节点
    public abstract String getPermissionNode();
    public abstract String getName();
    public abstract boolean isConsoleFriendly();
    public String[] getAliases() {
        return new String[0];
    }
    protected T getPlugin() {
        return this.plugin;
    }
}
