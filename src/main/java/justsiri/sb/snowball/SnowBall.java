package justsiri.sb.snowball;

import justsiri.sb.snowball.listener.Game;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SnowBall extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new Game(), this);
    }
}
