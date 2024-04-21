package ru.danstudio.ematrap.utils;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import ru.danstudio.ematrap.EmaTrap;

import java.util.Objects;
import java.util.stream.Collectors;

public class ParticlesUtils {

    public static void createSmerch(Player player) {
        final Location location = player.getLocation();
        EmaTrap main = EmaTrap.instance;
        player.playSound(location, Sound.valueOf(main.items.getString("smerch.sound")), (float)(main).items.getDouble("smerch.volume"), 0.1F);
        final int[] points = { main.items.getInt("smerch.particle.amount") };
        final double[] radius = { 0.0D };
        for (Entity entity : location.getWorld().getNearbyEntities(location, (main).items.getInt("smerch.particle.radius"), 4.0D, (main).items.getInt("smerch.particle.radius"))
                .stream().filter(entity -> entity instanceof Player && entity != player)
                .collect(Collectors.toList())) {
            entity.setFireTicks(60);
        }
        (new BukkitRunnable() {
            public void run() {
                if (radius[0] <= (main).items.getInt("smerch.particle.radius")) {
                    for (int i = 0; i < points[0]; i++) {
                        double angle = 6.283185307179586D * i / points[0];
                        Location point = location.clone().add(radius[0] * Math.sin(angle), (main).items.getDouble("smerch.particle.UP"), radius[0] * Math.cos(angle));
                        (Objects.requireNonNull(location.getWorld())).spawnParticle(Particle.valueOf((main).items.getString("smerch.particle.name")), point, (main).items.getInt("smerch.particle.size"), 0.0D, (main).items.getDouble("smerch.particle.UP"), 0.0D, (main).items.getInt("smerch.particle.life"));
                    }
                } else {
                    cancel();
                }
                radius[0] = radius[0] + 0.2D;
            }
        }).runTaskTimerAsynchronously(main, 0L, 1L);
    }

    public static void createDiz(Player player) {
        final Location location = player.getLocation();
        EmaTrap main = EmaTrap.instance;
        player.playSound(location, Sound.valueOf(main.items.getString("diz.sound")), (float)(main).items.getDouble("diz.volume"), 0.1F);
        final int[] points = { (main).items.getInt("diz.particle.amount") };
        final double[] radius = { 0.0D };
        for (Entity entity : location.getWorld().getNearbyEntities(location, (main).items.getInt("diz.particle.radius"), 4.0D, (main).items.getInt("diz.particle.radius"))
                .stream().filter(entity -> entity instanceof Player && entity != player)
                .collect(Collectors.toList())) {
            ((Player) entity).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 0));
            ((Player) entity).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 1));
            ((Player) entity).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 100, 1));
            ((Player) entity).addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 100, 0));
            ((Player) entity).addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 100, 1));
        }
        (new BukkitRunnable() {
            public void run() {
                if (radius[0] <= (main).items.getInt("diz.particle.radius")) {
                    for (int i = 0; i < points[0]; i++) {
                        double angle = 6.283185307179586D * i / points[0];
                        Location point = location.clone().add(radius[0] * Math.sin(angle), (main).items.getDouble("diz.particle.UP"), radius[0] * Math.cos(angle));
                        (Objects.requireNonNull(location.getWorld())).spawnParticle(Particle.valueOf((main).items.getString("diz.particle.name")), point, (main).items.getInt("diz.particle.size"), 0.0D, (main).items.getDouble("diz.particle.UP"), 0.0D, (main).items.getInt("diz.particle.life"));
                    }
                } else {
                    cancel();
                }
                radius[0] = radius[0] + 0.5D;
            }
        }).runTaskTimerAsynchronously(main, 0L, 0L);
    }

    public static void createDust(Player player) {
        final Location location = player.getLocation();
        EmaTrap main = EmaTrap.instance;
        player.playSound(location, Sound.valueOf(main.items.getString("dust.sound")), (float)(main).items.getDouble("dust.volume"), 0.1F);
        final int[] points = { (main).items.getInt("dust.particle.amount") };
        final double[] radius = { 0.0D, 0.0D };
        for (Entity entity : location.getWorld().getNearbyEntities(location, (main).items.getInt("dust.particle.radius"), 4.0D, (main).items.getInt("dust.particle.radius"))
                .stream().filter(entity -> entity instanceof Player && entity != player)
                .collect(Collectors.toList())) {
            ((Player) entity).addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 200, 0));
        }
        (new BukkitRunnable() {
            public void run() {
                if (radius[1] <= (main).items.getInt("dust.particle.radius")) {
                    for (int i = 0; i < points[0]; i++) {
                        double angle = 6.283185307179586D * i / points[0];
                        Location point = location.clone().add(2.5D * Math.sin(angle), (main).items.getDouble("dust.particle.UP"), 2.5D * Math.cos(angle));
                        (Objects.requireNonNull(location.getWorld())).spawnParticle(Particle.valueOf((main).items.getString("dust.particle.name")), point, (main).items.getInt("dust.particle.size"), 0.0D, (main).items.getDouble("dust.particle.UP"), 0.0D, (main).items.getInt("dust.particle.life"));
                    }
                } else {
                    cancel();
                }
                if (radius[0] <= (main).items.getInt("dust.particle2.radius"))
                    for (int i = 0; i < points[0]; i++) {
                        double angle = 6.283185307179586D * i / points[0];
                        Location point = location.clone().add(radius[0] * Math.sin(angle), (main).items.getDouble("dust.particle2.UP"), radius[0] * Math.cos(angle));
                        (Objects.requireNonNull(location.getWorld())).spawnParticle(Particle.valueOf((main).items.getString("dust.particle2.name")), point, (main).items.getInt("dust.particle2.size"), 0.0D, (main).items.getDouble("dust.particle2.UP"), 0.0D, (main).items.getInt("dust.particle2.life"));
                    }
                radius[1] = radius[1] + 0.5D;
                radius[0] = radius[0] + 0.5D;
            }
        }).runTaskTimerAsynchronously(main, 0L, 0L);
    }

}
