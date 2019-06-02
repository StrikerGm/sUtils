package me.strikergm.cmds;

import me.strikergm.main.Main;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Clearchat_Command implements CommandExecutor {

    HashMap<Player, Long> teste2 = new HashMap<>();

    public TextComponent Autor(Player autor, Player commandsender) {
        TextComponent msg1 = new TextComponent("§a Chat foi limpo com sucesso! §7(Passe o mouse aqui). \n ");
        msg1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new BaseComponent[]{new net.md_5.bungee.api.chat.TextComponent(" \n§e   Sistema de Limpeza de Chat! \n \n§e  Autor da limpeza: §7 " + commandsender.getName()
                + " limpou o chat!  \n ")}));
        return msg1;
    }

    @Override
    public boolean onCommand(CommandSender s, Command c, String lb, String[] args) {
        if (s instanceof ConsoleCommandSender) {
            Bukkit.getConsoleSender().sendMessage("§c Este comando e apenas para jogadores!");
            return true;
        }
        if (c.getName().equalsIgnoreCase("clearchat")) {
            Player p = (Player) s;
            if (p.hasPermission("sUtils.moderador")) {
                if (teste2.containsKey(p) && !(System.currentTimeMillis() >= teste2.get(p))) {
                    p.sendMessage("§6[RedeOlimpia] §cVoce precisa esperar §e" + converter(p) + "§e segundo(s)");
                    return false;
                } else teste2.remove(p);
                teste2.put(p, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(10));
                for (int i = 0; i < 500; i++) {
                    Bukkit.getOnlinePlayers().forEach(e -> e.sendMessage(""));
                }
                Bukkit.getOnlinePlayers().forEach(e -> e.spigot().sendMessage(Autor(e, p)));
                Bukkit.getConsoleSender().sendMessage(" §cAlerta: §e" + s.getName() + " limpou o chat!");
            } else {
                p.sendMessage(Main.getInstance().config.getString("sem_perm").replace("&", "§"));
            }
        }
        return false;
    }
    private Long converter(Player p) {
        long tempo = System.currentTimeMillis() - teste2.get(p);
        return 1 + TimeUnit.MILLISECONDS.toSeconds(tempo * -1);
    }
}
