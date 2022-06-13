package coordinatesondeath.coordinatesondeath;

import coordinatesondeath.coordinatesondeath.handlers.DeathHandler;
import coordinatesondeath.coordinatesondeath.updatecheck.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class CoordinatesOnDeath extends JavaPlugin {
    final String PREFIX = "[CoordinatesOnDeath] ";
    @Override
    public void onEnable() {
        Bukkit.getLogger().info(PREFIX + "CoordinatesOnDeath enabled.");
        // Update checker logic
        new UpdateChecker(this).getVersion(version -> {
            if (this.getDescription().getVersion().equals(version)) getLogger().info("You are running the latest version of CoordinatesOnDeath (" + this.getDescription().getVersion() + ").");
            else getLogger().info("WARNING: You are running an outdated version of CoordinatesOnDeath (" + this.getDescription().getVersion() + ")! Newest version: " + version + ".");
        });

        // Plugin logic
        new DeathHandler(this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(PREFIX + "CoordinatesOnDeath disabled.");
    }
}
