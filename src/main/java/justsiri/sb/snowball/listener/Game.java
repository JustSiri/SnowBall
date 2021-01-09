package justsiri.sb.snowball.listener;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

public class Game implements Listener {

    @EventHandler
    public void onShoot(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Snowball) {
            Snowball snowball = (Snowball) event.getEntity();
            if (snowball.getShooter() instanceof Player) {
                Player player = (Player) snowball.getShooter();
                if (event.getHitEntity() instanceof Player) {
                    Player victim = (Player) event.getHitEntity();
                    if (!(victim.getGameMode().equals(GameMode.CREATIVE) || victim.getGameMode().equals(GameMode.SPECTATOR))) {
                        if (victim.getHealth() < 2) {
                            victim.setHealth(0);
                        }
                        victim.setHealth(victim.getHealth() - 2);
                        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5f, 0.5f);
                        player.sendMessage("플레이어 " + victim.getDisplayName() + "님의 체력: " + (int) victim.getHealth());
                        //[Eng version] player.sendMessage("Player " + victim.getDisplayName() + "'s health: " + (int) victim.getHealth());
                    }
                }
            }
        }
    }

    @EventHandler
    public void damage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            if (event.getDamager() instanceof Player) {
                event.setCancelled(true);
            }
        }
    }

}
