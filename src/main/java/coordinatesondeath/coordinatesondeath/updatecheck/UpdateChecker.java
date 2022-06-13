package coordinatesondeath.coordinatesondeath.updatecheck;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;

public class UpdateChecker {
    private final JavaPlugin plugin;

    public UpdateChecker(JavaPlugin pl) {
        plugin = pl;
    }

    public void getVersion(final Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            try (InputStream inputStream = new URL("https://api.spigotmc.org/legacy/update.php?resource=102587").openStream(); Scanner scan = new Scanner(inputStream)) {
                if (scan.hasNext()) {
                    consumer.accept(scan.next());
                }
            }
            catch (IOException e) {
                plugin.getLogger().info("ERROR: Cannot check for updates: " + e.getMessage());
            }
        });

    }
}
