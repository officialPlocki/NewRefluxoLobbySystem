package me.refluxo.lobbysystem.util;

import me.refluxo.moduleloader.util.files.FileBuilder;
import me.refluxo.moduleloader.util.files.YamlConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.io.IOException;

public class LocationManager {

    /**
     * This function saves a location to a file
     *
     * @param name The name of the location.
     * @param location The location to save
     */
    public void saveLocation(String name, Location location) {
        FileBuilder builder = new FileBuilder("plugins/ModuleLoader/modules/LobbySystem/locations.yml");
        YamlConfiguration yml = builder.getYaml();
        if(!builder.getFile().exists()) {
            try {
                builder.getFile().createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        yml.set(name + ".X", location.getX());
        yml.set(name + ".Y", location.getY());
        yml.set(name + ".Z", location.getZ());
        yml.set(name + ".YAW", location.getYaw());
        yml.set(name + ".PITCH", location.getPitch());
        yml.set(name + ".WORLD", location.getWorld().getName());
        builder.save();
    }

    /**
     * This function returns a Location object that is stored in the locations.yml file
     *
     * @param name The name of the location.
     * @return A Location object.
     */
    public Location getLocation(String name) {
        FileBuilder builder = new FileBuilder("plugins/ModuleLoader/modules/LobbySystem/locations.yml");
        YamlConfiguration yml = builder.getYaml();
        if(!builder.getFile().exists()) {
            try {
                builder.getFile().createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new Location(Bukkit.getWorld(yml.getString(name + ".WORLD")), yml.getDouble(name + ".X"), yml.getDouble(name + ".Y"), yml.getDouble(name + ".Z"), (float) yml.getDouble(name + ".YAW"), (float) yml.getDouble(name + ".PITCH"));
    }

}
