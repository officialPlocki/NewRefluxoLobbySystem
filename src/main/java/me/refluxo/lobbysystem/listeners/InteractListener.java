package me.refluxo.lobbysystem.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

@me.refluxo.moduleloader.module.Listener
public class InteractListener implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onSpawn(EntitySpawnEvent event) {
        if(!event.getEntityType().equals(EntityType.ARMOR_STAND)) {
            event.setCancelled(true);
            if(!event.getEntity().isDead()) {
                event.getEntity().remove();
            }
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        event.setCancelled(true);
    }

}
