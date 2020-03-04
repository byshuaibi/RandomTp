package cc.mcwarzone;

import cc.mcwarzone.command.RandomTpCommands;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class RandomTp extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginCommand("crt").setExecutor(new RandomTpCommands());
        this.getLogger().info("插件启动.");
    }
}
