package ru.danstudio.ematrap.utils;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.danstudio.ematrap.EmaTrap;

import java.util.ArrayList;
import java.util.List;

public class ItemsUtils {

    public static ItemStack smerch = getItem("smerch", Material.FIRE_CHARGE);

    public static ItemStack dust = getItem("dust", Material.SUGAR);

    public static ItemStack diz = getItem("diz", Material.ENDER_EYE);

    public static ItemStack trap = getItem("trap", Material.NETHERITE_SCRAP);

    public static ItemStack plast = getItem("plast", Material.DRIED_KELP);

    public static ItemStack getItem(String code, Material material) {
        YamlConfiguration items = EmaTrap.instance.items;

        ItemStack item = new ItemStack(material);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(items.getString(code + ".name").replace("&", "§"));

        List<String> loreList = new ArrayList<>();
        for (String line : items.getStringList(code + ".lore"))
            loreList.add(line.replace("&", "§"));
        meta.setLore(loreList);
        meta.setLocalizedName("ematrap");

        item.setItemMeta(meta);
        return item;
    }

}
