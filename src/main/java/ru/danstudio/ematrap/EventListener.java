package ru.danstudio.ematrap;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.bukkit.Location;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import ru.danstudio.ematrap.utils.ItemsUtils;
import ru.danstudio.ematrap.utils.ParticlesUtils;
import ru.danstudio.ematrap.utils.PlastGenerator;
import ru.danstudio.ematrap.utils.TrapGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EventListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getItem() != null)) {

            Player player = event.getPlayer();
            Location location = player.getLocation();
            ArrayList<BlockState> resetList = new ArrayList<>();
            ItemStack item = event.getItem();

            if (item.getItemMeta().getLocalizedName().equals("ematrap")) {
                event.setCancelled(true);
                if (!player.hasCooldown(item.getType())) {
                    ApplicableRegionSet regions = WorldGuard.getInstance().getPlatform().getRegionContainer().createQuery().getApplicableRegions(BukkitAdapter.adapt(player.getLocation()));
                    for (ProtectedRegion pregion : regions) {
                        if (pregion.getFlag(WorldGuard.getInstance().getFlagRegistry().get("ematrap-use")) == StateFlag.State.DENY)
                            return;
                    }
                    switch (item.getType()) {
                        case FIRE_CHARGE:
                            player.setCooldown(item.getType(), EmaTrap.instance.items.getInt("smerch.cooldown") * 20);
                            ParticlesUtils.createSmerch(player);
                            break;
                        case SUGAR:
                            player.setCooldown(item.getType(), EmaTrap.instance.items.getInt("dust.cooldown") * 20);
                            ParticlesUtils.createDust(player);
                            break;
                        case ENDER_EYE:
                            player.setCooldown(item.getType(), EmaTrap.instance.items.getInt("diz.cooldown") * 20);
                            ParticlesUtils.createDiz(player);
                            break;
                        case NETHERITE_SCRAP:
                            player.setCooldown(item.getType(), EmaTrap.instance.items.getInt("trap.cooldown") * 20);
                            new TrapGenerator(location, event, resetList, player).run();
                            break;
                        case DRIED_KELP:
                            player.setCooldown(item.getType(), EmaTrap.instance.items.getInt("plast.cooldown") * 20);
                            new PlastGenerator(location, event, resetList, player).run();
                            break;
                    }
                    (Objects.requireNonNull(item)).setAmount(item.getAmount() - 1);
                }
            }
        }
    }

}
