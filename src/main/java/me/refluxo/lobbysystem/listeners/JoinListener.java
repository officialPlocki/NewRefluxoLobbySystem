package me.refluxo.lobbysystem.listeners;

import me.refluxo.lobbysystem.util.LocationManager;
import me.refluxo.moduleloader.module.ModuleListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

@ModuleListener
public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().teleport(new LocationManager().getLocation("spawn"));
        event.getPlayer().getInventory().clear();
    }

}
