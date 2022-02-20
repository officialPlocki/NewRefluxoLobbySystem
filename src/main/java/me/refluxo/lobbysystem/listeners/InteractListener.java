package me.refluxo.lobbysystem.listeners;

import me.refluxo.moduleloader.module.ModuleListener;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

@ModuleListener
public class InteractListener implements Listener {

    /**
     * When a player drops an item, cancel the event.
     *
     * @param event The event that was fired.
     */
    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        event.setCancelled(true);
    }

    /**
     * If the entity is not an armor stand, cancel the event
     *
     * @param event The event that was fired.
     */
    @EventHandler
    public void onSpawn(EntitySpawnEvent event) {
        if(!event.getEntityType().equals(EntityType.ARMOR_STAND)) {
            event.setCancelled(true);
            if(!event.getEntity().isDead()) {
                event.getEntity().remove();
            }
        }
    }

    /**
     * This function is called when an entity is damaged
     *
     * @param event The event that is being cancelled.
     */
    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        event.setCancelled(true);
    }

}
