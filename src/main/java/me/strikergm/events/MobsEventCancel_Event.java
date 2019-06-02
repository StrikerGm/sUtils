package me.strikergm.events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.projectiles.ProjectileSource;

public class MobsEventCancel_Event implements Listener {

    @EventHandler
    public void conquista(PlayerAchievementAwardedEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void mobsExplosion(ProjectileLaunchEvent e) {
        ProjectileSource mob = e.getEntity().getShooter();
        if (mob instanceof Wither || mob instanceof Ghast) {
            if (e.getEntity().getType() == EntityType.WITHER_SKULL || e.getEntity().getType() == EntityType.FIREBALL) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void noTeleportEnderman(EntityTeleportEvent e) {
        if(e.getEntity().getType() == EntityType.ENDERMAN) {
            e.setCancelled(true);
        }
    }
}
