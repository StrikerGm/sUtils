package me.strikergm.metodos;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;
import net.minecraft.server.v1_8_R3.PlayerConnection;

public class AcTionBarETitle {

    public static void sendActionBar(Player player, String message) {
        PacketPlayOutChat packet = new PacketPlayOutChat(
                IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + message + "\"}"), (byte) 2);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }
    public static void EnviarTitle(Player player, String title, String subtitle, int fadeIn, int stay, int fadeOut) {

        CraftPlayer craftplayer = (CraftPlayer) player;

        PlayerConnection connection = craftplayer.getHandle().playerConnection;

        IChatBaseComponent titleJSON = ChatSerializer.a("{'text': '" + title + "'}");

        IChatBaseComponent subtitleJSON = ChatSerializer.a("{'text': '" + subtitle + "'}");

        PacketPlayOutTitle titlePacket = new PacketPlayOutTitle(EnumTitleAction.TITLE, titleJSON, fadeIn, stay,
                fadeOut);

        PacketPlayOutTitle subtitlePacket = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, subtitleJSON);

        connection.sendPacket(titlePacket);

        connection.sendPacket(subtitlePacket);

    }
}
