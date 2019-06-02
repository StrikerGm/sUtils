package me.strikergm.cmds;

import me.strikergm.items.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class cmd implements CommandExecutor, Listener {

    public boolean onCommand(CommandSender s, Command c, String lb, String[] args) {
        Player p = (Player) s;
        if (c.getName().equalsIgnoreCase("cheque")) {
            if (args.length == 0) {
                p.sendMessage("de /cheque <nick> <papel>");
            }
            if (args.length == 1) {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target == null) {
                    p.sendMessage("o nick nao esta no servidor");
                    return true;
                }
            }
            Player target = Bukkit.getPlayerExact(args[0]);
            if (args.length == 2) {
                if (args[1].equalsIgnoreCase("papel")) {
                    ItemStack papel = new ItemBuilder(Material.PAPER).setDisplayName("§eCheque de §f$§a15.000 ").setLore("", " §e Ao clicar em qualquer lugar ", " §e com o cheque na mão", " §e ele e automaticamente depositado", " §e no seu saldo!", "", " §7 Faça um bom uso dele.").build();
                    target.getInventory().addItem(papel);
                    target.sendMessage(" O Jogador " + p.getName() + " te deu o bagui");
                } else if (args[1].equalsIgnoreCase("papel2")) {
                    ItemStack papel = new ItemBuilder(Material.PAPER).setDisplayName("§eCheque de §f$§a25.000 ").setLore("", " §e Ao clicar em qualquer lugar ", " §e com o cheque na mão", " §e ele e automaticamente depositado", " §e no seu saldo!", "", " §7 Faça um bom uso dele.").build();
                    target.getInventory().addItem(papel);
                    target.sendMessage(" O Jogador " + p.getName() + " te deu o bagui");
                } else if (args[1].equalsIgnoreCase("papel3")) {
                    ItemStack papel = new ItemBuilder(Material.PAPER).setDisplayName("§eCheque de §f$§a50.000 ").setLore("", " §e Ao clicar em qualquer lugar ", " §e com o cheque na mão", " §e ele e automaticamente depositado", " §e no seu saldo!", "", " §7 Faça um bom uso dele.").build();
                    target.getInventory().addItem(papel);
                    target.sendMessage(" O Jogador " + p.getName() + " te deu o bagui");
                } else {
                    p.sendMessage("qual papel seria?");
                }
            }
        }
        return false;
    }

    @EventHandler
    public void clickevent(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (p.getInventory().getItem(0) == null) {
            return;
        }
        if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            if (p.getInventory().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§eCheque de §f$§a15.000 ")) {
                p.sendMessage("papel de 15k foi usado");
            }
            if (p.getInventory().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§eCheque de §f$§a25.000 ")) {
                p.sendMessage("papel de 25k foi usado");
            }
            if (p.getInventory().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§eCheque de §f$§a50.000 ")) {
                p.sendMessage("papel de 50k foi usado");
            }
            if (p.getInventory().getItemInHand().getAmount() <= 1) {
                p.setItemInHand(new ItemStack(Material.AIR));
                return;
            }
        }
            p.getInventory().getItemInHand().setAmount(p.getInventory().getItemInHand().getAmount() - 1);
            return;
    }
}