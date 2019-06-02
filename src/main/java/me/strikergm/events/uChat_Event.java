package me.strikergm.events;

import br.net.fabiozumbi12.UltimateChat.Bukkit.API.SendChannelMessageEvent;
import net.sacredlabyrinth.phaed.simpleclans.SimpleClans;
import nuvemplugins.solaryeconomy.app.SolaryEconomy;
import nuvemplugins.solaryeconomy.plugin.Economia;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class uChat_Event implements Listener {

    @EventHandler
    public void placeholders(SendChannelMessageEvent e) {
        SimpleClans sc = SimpleClans.getInstance();
        e.addTag("{simpleclans-tag}", sc.getClanManager().getClanPlayer(e.getSender().getName()).getTag().toUpperCase());
    }
}
