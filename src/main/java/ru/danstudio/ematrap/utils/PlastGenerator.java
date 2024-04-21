package ru.danstudio.ematrap.utils;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.flags.Flag;
import com.sk89q.worldguard.protection.flags.Flags;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedCuboidRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import ru.danstudio.ematrap.EmaTrap;

public class PlastGenerator {
    
    private final Location location;
    private final PlayerInteractEvent event;
    private final List<BlockState> resetList;
    private final Player player;

    public PlastGenerator(Location location, PlayerInteractEvent event, List<BlockState> resetList, Player player) {
        this.location = location;
        this.event = event;
        this.resetList = resetList;
        this.player = player;
    }

    public void run() {
        EmaTrap main = EmaTrap.instance;
        int time = main.items.getInt("plast.time");
        Bukkit.getScheduler().runTaskAsynchronously(main, () -> Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)main, () -> {
            this.location.setY(this.location.getY() - 1.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() + 1.0);
            this.location.setZ(this.location.getZ() + 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() + 1.0);
            this.location.setZ(this.location.getZ() + 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() + 0.0);
            this.location.setZ(this.location.getZ() + 1.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() - 1.0);
            this.location.setZ(this.location.getZ() + 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() - 1.0);
            this.location.setZ(this.location.getZ() + 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() - 1.0);
            this.location.setZ(this.location.getZ() + 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() - 1.0);
            this.location.setZ(this.location.getZ() + 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() - 0.0);
            this.location.setZ(this.location.getZ() - 1.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() + 1.0);
            this.location.setZ(this.location.getZ() - 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() - 0.0);
            this.location.setZ(this.location.getZ() + 2.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() - 1.0);
            this.location.setZ(this.location.getZ() - 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() + 2.0);
            this.location.setZ(this.location.getZ() - 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() + 1.0);
            this.location.setZ(this.location.getZ() - 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() + 1.0);
            this.location.setZ(this.location.getZ() - 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() + 0.0);
            this.location.setZ(this.location.getZ() - 3.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() - 1.0);
            this.location.setZ(this.location.getZ() - 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() - 1.0);
            this.location.setZ(this.location.getZ() - 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() - 1.0);
            this.location.setZ(this.location.getZ() - 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() - 1.0);
            this.location.setZ(this.location.getZ() - 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() - 0.0);
            this.location.setZ(this.location.getZ() - 1.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() + 1.0);
            this.location.setZ(this.location.getZ() - 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() + 1.0);
            this.location.setZ(this.location.getZ() - 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() + 1.0);
            this.location.setZ(this.location.getZ() - 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() + 1.0);
            this.location.setZ(this.location.getZ() - 0.0);
            this.createObsidian(this.location);
            this.location.setY(this.location.getY() - 1.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() - 2.0);
            this.location.setZ(this.location.getZ() + 2.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() + 1.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() + 1.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() + 0.0);
            this.location.setZ(this.location.getZ() + 1.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() - 1.0);
            this.location.setZ(this.location.getZ() + 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() - 1.0);
            this.location.setZ(this.location.getZ() + 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() - 1.0);
            this.location.setZ(this.location.getZ() + 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() - 1.0);
            this.location.setZ(this.location.getZ() + 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() - 0.0);
            this.location.setZ(this.location.getZ() - 1.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() + 1.0);
            this.location.setZ(this.location.getZ() - 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() - 0.0);
            this.location.setZ(this.location.getZ() + 2.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() - 1.0);
            this.location.setZ(this.location.getZ() - 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() + 2.0);
            this.location.setZ(this.location.getZ() - 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() + 1.0);
            this.location.setZ(this.location.getZ() - 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() + 1.0);
            this.location.setZ(this.location.getZ() - 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() + 0.0);
            this.location.setZ(this.location.getZ() - 3.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() - 1.0);
            this.location.setZ(this.location.getZ() - 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() - 1.0);
            this.location.setZ(this.location.getZ() - 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() - 1.0);
            this.location.setZ(this.location.getZ() - 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() - 1.0);
            this.location.setZ(this.location.getZ() - 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() - 0.0);
            this.location.setZ(this.location.getZ() - 1.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() + 1.0);
            this.location.setZ(this.location.getZ() - 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() + 1.0);
            this.location.setZ(this.location.getZ() - 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() + 1.0);
            this.location.setZ(this.location.getZ() - 0.0);
            this.createObsidian(this.location);
            this.location.setX(this.location.getX() - 1.0);
            this.location.setZ(this.location.getZ() - 0.0);
            this.createObsidian(this.location);
        }));
        String regionUUID = UUID.randomUUID().toString().substring(0, 7) + "plast";
        int minX = (int)(this.location.getX() - 2.0);
        int minY = (int)this.location.getY();
        int minZ = (int)(this.location.getZ() - 2.0);
        int maxX = (int)(this.location.getX() + 2.0);
        int maxY = (int)(this.location.getY() + 2.0);
        int maxZ = (int)(this.location.getZ() + 2.0);
        BlockVector3 min = BlockVector3.at(minX, minY, minZ);
        BlockVector3 max = BlockVector3.at(maxX, maxY, maxZ);
        ProtectedCuboidRegion region = new ProtectedCuboidRegion(regionUUID, min, max);
        RegionContainer container2 = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionManager regions = container2.get(BukkitAdapter.adapt(this.player.getWorld()));
        if (regions != null) {
            regions.addRegion(region);
        } else {
            Bukkit.getLogger().severe("Ошибка создания региона: " + regionUUID);
        }
        Flag flag = WorldGuard.getInstance().getFlagRegistry().get("ematrap-use");
        StateFlag stateFlag = (StateFlag)flag;
        region.setFlag(stateFlag, StateFlag.State.DENY);
        this.player.playSound(this.location, Sound.valueOf(main.items.getString("plast.sound.name")), (float)main.items.getDouble("plast.sound.volume"), (float)main.items.getDouble("plast.sound.pitch"));
        Bukkit.getScheduler().runTaskAsynchronously(main, () -> Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)main, () -> {
            if (this.location.getChunk().isLoaded()) {
                for (BlockState block : this.resetList) {
                    block.update(true);
                }
                this.resetList.clear();
                RegionManager regionManager = WorldGuard.getInstance().getPlatform().getRegionContainer().get(BukkitAdapter.adapt(this.player.getWorld()));
                if (regionManager != null) {
                    regionManager.removeRegion(region.getId());
                }
            }
        }, (long)time * 20L));
    }

    public void createObsidian(Location location) {
        EmaTrap main = EmaTrap.instance;
        if (!(location.getBlock().getType().equals(Material.CHEST) || location.getBlock().getType().equals(Material.ENDER_CHEST) || location.getBlock().getType().equals(Material.BARREL) || location.getBlock().getType().equals(Material.TRAPPED_CHEST) || location.getBlock().getType().equals(Material.FURNACE) || location.getBlock().getType().equals(Material.SMOKER) || location.getBlock().getType().equals(Material.BLAST_FURNACE) || location.getBlock().getType().equals(Material.ARMOR_STAND) || location.getBlock().getType().equals(Material.ITEM_FRAME) || location.getBlock().getType().equals(Material.HOPPER) || location.getBlock().getType().equals(Material.DROPPER) || location.getBlock().getType().equals(Material.DISPENSER) || location.getBlock().getType().equals(Material.BREWING_STAND) || location.getBlock().getType().equals(Material.valueOf(main.items.getString("plast.materials.block1"))) || location.getBlock().getType().equals(Material.valueOf(main.items.getString("plast.materials.block2"))) || location.getBlock().getType().equals(Material.valueOf(main.items.getString("trap.materials.slab"))))) {
            this.resetList.add(location.getBlock().getState());
            if (new Random().nextInt(100) < main.getConfig().getInt("random.obsidian")) {
                location.getBlock().setType(Material.valueOf(main.items.getString("plast.materials.block1")));
            } else {
                location.getBlock().setType(Material.valueOf(main.items.getString("plast.materials.block2")));
            }
        }
    }
    
}
 
