package ru.danstudio.ematrap;

import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.flags.Flag;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.flags.registry.FlagConflictException;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Objects;

public final class EmaTrap extends JavaPlugin {

    public static EmaTrap instance;

    public StateFlag FLAG;

    public YamlConfiguration messages;

    public YamlConfiguration items;

    public void onLoad() {
        if (WorldGuard.getInstance().getFlagRegistry().get("ematrap-use") == null)
            try {
                StateFlag flag = new StateFlag("ematrap-use", true);
                WorldGuard.getInstance().getFlagRegistry().register(flag);
                FLAG = flag;
            } catch (FlagConflictException e) {
                Flag<?> existing = WorldGuard.getInstance().getFlagRegistry().get("ematrap-use");
                if (existing instanceof StateFlag)
                    FLAG = (StateFlag)existing;
            }
    }

    @Override
    public void onEnable() {

        instance = this;
        saveResource("messages.yml", false);
        saveResource("items.yml", false);
        saveResource("config.yml", false);
        this.messages = YamlConfiguration.loadConfiguration(new File(getDataFolder(), "messages.yml"));
        this.items = YamlConfiguration.loadConfiguration(new File(getDataFolder(), "items.yml"));
        (Objects.requireNonNull(getCommand("ematrap"))).setExecutor(new EmaTrapCommand());
        Bukkit.getPluginManager().registerEvents(new EventListener(), this);

    }

    @Override
    public void onDisable() {
        Bukkit.getScheduler().cancelTasks(this);
    }

    public String translateString(String path) {
        return (Objects.requireNonNull(this.messages.getString("prefix")) + (Objects.requireNonNull(this.messages.getString(path)))).replace("&", "§");
    }

}
