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
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + PREFIX + "CoordinatesOnDeath enabled.");

        // Update checker logic
        new UpdateChecker(this).getVersion(version -> {
            if (this.getDescription().getVersion().equals(version)) Bukkit.getConsoleSender().sendMessage(
                    ChatColor.GREEN
                    + "\n-------------------------------------------------------"
                    + "\n" + PREFIX + "You are running the latest version of CoordinatesOnDeath (" + this.getDescription().getVersion() + ")."
                    + "\n-------------------------------------------------------");
            else Bukkit.getConsoleSender().sendMessage(
                    ChatColor.YELLOW
                    + "\n-------------------------------------------------------"
                    + "\n" + PREFIX + "WARNING: You are running an outdated version of CoordinatesOnDeath (" + this.getDescription().getVersion() + ")! Newest version: " + version + "."
                    + "\n" + PREFIX + "Download the latest version from: https://www.curseforge.com/minecraft/bukkit-plugins/coordinatesondeath"
                    + "\n-------------------------------------------------------");
        });

        // Plugin logic
        new DeathHandler(this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(ChatColor.RED + PREFIX + "CoordinatesOnDeath disabled.");
    }
}
