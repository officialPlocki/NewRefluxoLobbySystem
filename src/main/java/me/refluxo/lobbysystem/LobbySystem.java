package me.refluxo.lobbysystem;

import me.refluxo.moduleloader.ModuleLoader;
import me.refluxo.moduleloader.module.Module;
import me.refluxo.moduleloader.module.ModuleManager;
import me.refluxo.moduleloader.module.PluginModule;
import me.refluxo.moduleloader.util.mysql.MySQLService;
import org.bukkit.plugin.Plugin;

@Module(moduleName = "LobbySystem")
public final class LobbySystem extends PluginModule {

    @Override
    public void enableModule() {

    }

    @Override
    public void disableModule() {

    }

    @Override
    public Plugin getPlugin() {
        return super.getPlugin();
    }

    @Override
    public ModuleManager getModuleManager() {
        return super.getModuleManager();
    }

    @Override
    public MySQLService getMySQLService() {
        return super.getMySQLService();
    }

    @Override
    public ModuleLoader getModuleLoader() {
        return super.getModuleLoader();
    }

}
