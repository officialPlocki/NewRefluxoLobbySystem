package me.refluxo.lobbysystem.listeners;

import me.refluxo.moduleloader.module.ModuleListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

@ModuleListener
public class BuildListener implements Listener {

    /**
     * When a player tries to place a block, cancel the event.
     *
     * @param event The event that was fired.
     */
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        event.setCancelled(true);
    }

    /**
     * When a block is broken, cancel the event.
     *
     * @param event The event that was fired.
     */
    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        event.setCancelled(true);
    }

}
