package me.draimcido.draimdialogues;

import me.draimcido.draimdialogues.Commands.MainCommands;
import me.draimcido.draimdialogues.Commands.TabComplete;
import me.draimcido.draimdialogues.Config.MessageConfig;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class Main extends JavaPlugin {

    public static NamespacedKey npc;
    public static NamespacedKey dialogue;

    public static FileConfiguration config;
    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    public String getConfigString(String path) {
        return this.getConfig().getString(path);
    }

    public String getDialoguesConfigString(String path) {
        return this.getConfig().getString(path);
    }

    public List<String> getConfigStringList(String path) {
        return this.getConfig().getStringList(path);
    }

    public int getConfigInt(String path) {
        return this.getConfig().getInt(path);
    }

    @Override
    public void onEnable() {
        initCommands();
        this.saveDefaultConfig();
        instance = this;
        config = getConfig();
        MessageConfig.getMessage().setUp();
        MessageConfig.getMessage().setUpDialogues();
    }

    @Override
    public void onDisable() {
    }

    public void reloadConfiguration() {
        reloadConfig();
        config = getConfig();
    }

    public void initCommands() {
        getCommand("draimdialogues").setExecutor(new MainCommands(this));
        getCommand("draimdialogues").setTabCompleter(new TabComplete());
    }
}
