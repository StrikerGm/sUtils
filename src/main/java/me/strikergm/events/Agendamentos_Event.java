package me.strikergm.events;

import me.strikergm.main.Main;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class Agendamentos_Event {


    public static TextComponent MSG6() {
        TextComponent msg1 = new TextComponent("\n§cTESTE 1");
        return msg1;
    }

    public static TextComponent MSG7() {
        TextComponent msg1 = new TextComponent("\n§cTESTE 2");
        return msg1;
    }

    public static TextComponent MSG8() {
        TextComponent msg1 = new TextComponent("\n§cTESTE 3");
        return msg1;
    }

    public static void agendamento1() {
        new BukkitRunnable() {
            @Override
            public void run() {
                    Bukkit.spigot().broadcast(TC);
            }
        }.runTaskTimerAsynchronously(Main.getInstance(), 0, 20 * 60 * 1);
    }

    public static TextComponent[] TC = {MSG6(), MSG7(), MSG8()};

}