package me.strikergm.main;

import com.tjplaysnow.discord.object.Bot;
import me.strikergm.cmds.Alerta_Command;
import me.strikergm.cmds.Clearchat_Command;
import me.strikergm.cmds.cmd;
import me.strikergm.events.Agendamentos_Event;
import me.strikergm.events.JoinQuit_Event;
import me.strikergm.events.MobsEventCancel_Event;
import me.strikergm.events.uChat_Event;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    ConsoleCommandSender console = Bukkit.getConsoleSender();
    public Configs config = new Configs("config.yml", this);
    public Configs log = new Configs("log.yml", this);
    public static Bot bot;
    public final String TOKEN = "[Insert Token Here]";
    public final String PREFIX = "!";

    public static Main getInstance() {

        return (Main) getPlugin(Main.class);
    }

    @Override
    public void onEnable() {
        registros();
        Agendamentos_Event.agendamento1();
        bot = new Bot("NTU5MjAyOTQwNjQ5NDcyMDAy.XNTTHg.LMPsOuENGsFTkOhBROeO7WNBIb0", "!");
        config.saveDefaultConfig();
        console.sendMessage("");
        console.sendMessage("§ePlugin §6RedeRoyale-Utils §finiciado!");
        console.sendMessage("");
    }

    @Override
    public void onDisable() {

        console.sendMessage("");
        console.sendMessage("§ePlugin §6RedeRoyale-Utils §fdesligado!");
        console.sendMessage("");
    }

    public void reload() {
        onDisable();
        onEnable();
    }

    public void registros() {

        getCommand("cheque").setExecutor(new cmd());
        getCommand("redeolimpia").setExecutor(new RedeRoyale_Command());
        getCommand("clearchat").setExecutor(new Clearchat_Command());
        getCommand("alerta").setExecutor(new Alerta_Command());
        Bukkit.getPluginManager().registerEvents(new JoinQuit_Event(), this);
        Bukkit.getPluginManager().registerEvents(new MobsEventCancel_Event(), this);
        Bukkit.getPluginManager().registerEvents(new cmd(), this);
        Bukkit.getPluginManager().registerEvents(new uChat_Event(), this);
    }
}
