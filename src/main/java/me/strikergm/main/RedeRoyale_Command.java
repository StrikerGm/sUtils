package me.strikergm.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;


public class RedeRoyale_Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command c, String lb, String[] args) {
        if (s instanceof ConsoleCommandSender) {
            Bukkit.getConsoleSender().sendMessage("§c Este comando e apenas para jogadores!");
            return true;
        }

        if (c.getName().equalsIgnoreCase("redeolimpia")) {
            Player p = (Player) s;
            if (p.hasPermission("sUtils.master")) {
                if (args.length == 0) {
                    for (String status : Main.getInstance().config.getStringList("Mensagens.rederoyale_principal")) {
                        p.sendMessage(status.replace("&", "§"));
                    }
                    return false;
                }
                if (args[0].equalsIgnoreCase("reload")) {
                    for (String status : Main.getInstance().config.getStringList("Mensagens.rederoyale_reload")) {
                        p.sendMessage(status.replace("&", "§"));
                    }
                }
                if (args[0].equalsIgnoreCase("autor")) {
                    for (String status : Main.getInstance().config.getStringList("Mensagens.rederoyale_autor")) {
                        p.sendMessage(status.replace("&", "§"));
                    }
                }
                if (args[0].equalsIgnoreCase("status")) {
                    for (String status : Main.getInstance().config.getStringList("Mensagens.rederoyale_status")) {
                        p.sendMessage(status.replace("&", "§"));
                    }
                }
            } else {
                for (String status : Main.getInstance().config.getStringList("Mensagens.sem_perm")) {
                    p.sendMessage(status.replace("&", "§"));
                }
            }
        }
        return false;
    }
}
