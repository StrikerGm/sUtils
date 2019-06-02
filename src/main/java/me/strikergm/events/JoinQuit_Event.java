package me.strikergm.events;

import me.strikergm.metodos.AcTionBarETitle;
import net.sacredlabyrinth.phaed.simpleclans.SimpleClans;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class JoinQuit_Event implements Listener {

    @EventHandler
    public void Join(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage(null);
        if (p.hasPermission("sUtils.joinquit")) {
            if (SimpleClans.getInstance().getClanManager().getClanPlayer(p) == null) {
                Bukkit.getOnlinePlayers().forEach(s -> AcTionBarETitle.sendActionBar(s, "§7§l[] " + PermissionsEx.getUser(p).getPrefix().replace("&", "§") + "§e" + p.getName() + " entrou no servidor!"));
            } else {
                Bukkit.getOnlinePlayers().forEach(s -> AcTionBarETitle.sendActionBar(s, "§7§l[" + SimpleClans.getInstance().getClanManager().getClanPlayer(p).getTag().toUpperCase() + "§7] " + PermissionsEx.getUser(p).getPrefix().replace("&", "§") + "§e" + p.getName() + " entrou no servidor!"));
            }
        }
    }

    @EventHandler
    public void Quit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(null);
        if (p.hasPermission("sUtils.joinquit")) {
            if (SimpleClans.getInstance().getClanManager().getClanPlayer(p) == null) {
                Bukkit.getOnlinePlayers().forEach(s -> AcTionBarETitle.sendActionBar(s, "§7§l[] " + PermissionsEx.getUser(p).getPrefix().replace("&", "§") + "§e" + p.getName() + " saiu do servidor!"));
            } else {
                Bukkit.getOnlinePlayers().forEach(s -> AcTionBarETitle.sendActionBar(s, "§7§l[" + SimpleClans.getInstance().getClanManager().getClanPlayer(p).getTag().toUpperCase() + "§7] " + PermissionsEx.getUser(p).getPrefix().replace("&", "§") + "§e" + p.getName() + " saiu do servidor!"));
            }
        }
    }
}