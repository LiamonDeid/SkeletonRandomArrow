package org.liamondeid.skeletonsrandomarrow;

import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import java.util.Random;

public final class SkeletonsRandomArrow extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        
    }

    @EventHandler
    public void skeletonShoot(EntityShootBowEvent event) {

        if (event.getEntity().getType() != EntityType.SKELETON) return;

        Arrow arrow = (Arrow) event.getProjectile();

        int value = getConfig().getInt("n");
        Random random = new Random();

        if(random.nextInt(value) != 1) return;

        PotionType[] potionTypes = PotionType.values();
        arrow.setBasePotionData(new PotionData(potionTypes[random.nextInt(potionTypes.length)]));

    }
}
