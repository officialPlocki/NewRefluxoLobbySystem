package me.refluxo.lobbysystem.commands;

import me.refluxo.lobbysystem.util.LocationManager;
import me.refluxo.moduleloader.module.ModuleCommand;
import me.refluxo.moduleloader.module.ModuleCommandExecutor;
import me.refluxo.serverlibrary.util.player.PlayerAPI;
import me.refluxo.serverlibrary.util.player.PlayerManager;
import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@ModuleCommand(command = "setlocation", usage = "/setlocation <location>", tabCompleterIsEnabled = false, permissions = {"refluxo.lobby.setlocation"}, aliases = {"setl", "sl", "setpos", "setposition"}, description = "Sets Lobby Positions")
public class SetLocationCommand extends ModuleCommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        var playerManager = new PlayerManager();
        if(sender.hasPermission("refluxo.lobby.setlocation")) {
            if(args.length == 1) {
                playerManager.getPlayer((Player) sender).sendMessage(PlayerAPI.MessageType.WARNING, ChatMessageType.ACTION_BAR, "Du hast die Position " + args[0] + " gesetzt.");
                new LocationManager().saveLocation(args[0], ((Player) sender).getLocation());
            } else {
                playerManager.getPlayer((Player) sender).sendMessage(PlayerAPI.MessageType.ERROR, ChatMessageType.ACTION_BAR, "Bitte gebe einen Namen für die Position an!");
            }
        } else {
            playerManager.getPlayer((Player) sender).sendMessage(PlayerAPI.MessageType.ERROR, ChatMessageType.ACTION_BAR, "Du hast dazu keine Rechte.");
        }
        return false;
    }

}
