package ru.danstudio.ematrap;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.danstudio.ematrap.utils.ItemsUtils;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EmaTrapCommand implements CommandExecutor, TabExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        EmaTrap main = EmaTrap.instance;
        if(!sender.hasPermission("ematrap.admin")) {
            sender.sendMessage(main.translateString("errorPermission"));
            return false;
        }
        if(args.length == 0) {
            sender.sendMessage(main.translateString("help"));
            return false;
        }
        if (args[0].equalsIgnoreCase("give")) {
            if (args.length <= 3) {
                sender.sendMessage(main.translateString("give-usage"));
            } else {
                OfflinePlayer t = Bukkit.getOfflinePlayer(args[1]);
                if (!t.isOnline()) {
                    sender.sendMessage(main.translateString("player.offline"));
                    return false;
                }
                ItemStack is;
                switch (args[2]) {
                    case "dust":
                        is = ItemsUtils.dust;
                        break;
                    case "smerch":
                        is = ItemsUtils.smerch;
                        break;
                    case "diz":
                        is = ItemsUtils.diz;
                        break;
                    case "plast":
                        is = ItemsUtils.plast;
                        break;
                    case "trap":
                        is = ItemsUtils.trap;
                        break;
                    default:
                        sender.sendMessage(main.translateString("give-usage"));
                        return false;
                }
                is.setAmount(Integer.parseInt(args[3]));
                ((Player) t).getInventory().addItem(is);
            }
        } else if (args[0].equalsIgnoreCase("reload")) {
            (main).messages = YamlConfiguration.loadConfiguration(new File(main.getDataFolder(), "messages.yml"));
            (main).items = YamlConfiguration.loadConfiguration(new File(main.getDataFolder(), "items.yml"));
            main.reloadConfig();
            sender.sendMessage(main.translateString("reload"));
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(sender.hasPermission("ematrap.admin")) {
            if (args.length <= 1) {
                return Arrays.asList("give", "reload");
            }
            if (args[0].equalsIgnoreCase("give")) {
                if (args.length == 2) {
                    return Bukkit.getOnlinePlayers().stream().map(Player::getName).collect(Collectors.toList());
                }
                if (args.length == 3) {
                    return Arrays.asList("dust", "diz", "smerch", "trap", "plast");
                }
                if (args.length == 4) {
                    return Arrays.asList("1");
                }
            }
        }
        return Collections.emptyList();
    }

}
