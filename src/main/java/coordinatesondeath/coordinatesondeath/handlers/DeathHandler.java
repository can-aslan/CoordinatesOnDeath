package coordinatesondeath.coordinatesondeath.handlers;

import coordinatesondeath.coordinatesondeath.CoordinatesOnDeath;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathHandler implements Listener {
    final String PREFIX = ChatColor.AQUA + "[" + ChatColor.GREEN + "CoordinatesOnDeath" + ChatColor.AQUA + "] " + ChatColor.GOLD;
    public DeathHandler(CoordinatesOnDeath plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Location eyeLocation = event.getEntity().getEyeLocation();
        String deathMsg = (
                " died at X = " + eyeLocation.getBlockX()
                + ", Y = " + eyeLocation.getBlockY()
                + ", Z = " + eyeLocation.getBlockZ() + ".");

        Bukkit.getLogger().info((PREFIX + ((Player) event.getEntity()).getDisplayName()) + deathMsg);
        event.getEntity().sendMessage(PREFIX + "You" + deathMsg);
    }
}
