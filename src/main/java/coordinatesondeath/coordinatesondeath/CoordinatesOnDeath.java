package coordinatesondeath.coordinatesondeath;

import coordinatesondeath.coordinatesondeath.handlers.DeathHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class CoordinatesOnDeath extends JavaPlugin {
    final String PREFIX = "[CoordinatesOnDeath] ";
    @Override
    public void onEnable() {
        Bukkit.getLogger().info(PREFIX + "CoordinatesOnDeath enabled.");
        new DeathHandler(this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(PREFIX + "CoordinatesOnDeath disabled.");
    }
}
