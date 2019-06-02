package me.strikergm.cmds;

import com.tjplaysnow.discord.object.Bot;
import me.strikergm.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Alerta_Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String lb, String[] args) {
        Player p = (Player) s;
        if (c.getName().equalsIgnoreCase("alerta")) {
            if (p.hasPermission("sUtils.admin")) {
                if (args.length < 1) {
                    p.sendMessage(Main.getInstance().config.getString("Mensagens.comando_incorreto").replace("&", "§"));
                    return true;
                }
                String alerta = String.join(" ", args).replace("&", "§");
                for (String mensagem : Main.getInstance().config.getStringList("Mensagens.Alerta_Command")) {

                    p.sendMessage(mensagem.replace("&", "§").replace("%mensagem%", alerta));
                }
                Bukkit.getConsoleSender().sendMessage("§cAlerta: §e" + p.getName() + " usou o /alerta !");
                Main.bot.getBot().getTextChannelById("582364161674182666").sendMessage("**"+ p.getName() +" usou o /alerta!** \n**Mensagem: " + alerta +"**").queue();

            } else {
                p.sendMessage(Main.getInstance().config.getString("Mensagens.sem_perm").replace("&", "§"));
            }
        }
        return false;
    }
}
