package net.ramuremo.savannaworldmanager;

import net.ramuremo.savannaworldmanager.command.WorldLoadCommand;
import net.ramuremo.savannaworldmanager.utility.CommandUtil;
import org.bukkit.plugin.java.JavaPlugin;

public final class SavannaWorldManager extends JavaPlugin {

    @Override
    public void onEnable() {
        CommandUtil.register(
                "savanna-world-manager",
                new WorldLoadCommand()
                );
        getLogger().info("The plugin has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("The plugin has been disabled.");
    }
}
