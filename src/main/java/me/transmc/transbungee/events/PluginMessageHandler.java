package me.transmc.transbungee.events;


import me.TransMC.TransMC.TransMC;
import me.transmc.transbungee.TransBungee;
import me.transmc.transbungee.api.BungeeApi;
import me.transmc.transbungee.api.C;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Map;

public class PluginMessageHandler implements Listener {



    private BungeeApi api = TransBungee.getApi();
    private TransBungee bungee = TransBungee.getInstance();
    private TransMC core = TransMC.getInstance();

    @EventHandler
    public void onPluginMessage(PluginMessageEvent e) {
        if (e.getTag().equalsIgnoreCase("trans:bungee")) {
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(e.getData()));

            try {
                String channel = in.readUTF();

                if (channel.equalsIgnoreCase("_broadcast")) {
                    String message = in.readUTF();

                    Map<String, ServerInfo> servers = TransBungee.getInstance().getProxy().getServers();

                    for (Map.Entry<String, ServerInfo> en : servers.entrySet()) {
                        String name = en.getKey();
                        ServerInfo all = TransBungee.getInstance().getProxy().getServerInfo(name);
                        api.sendToBukkit(channel, message, all);
                    }
                } else if (channel.equalsIgnoreCase("locate")) {
                    final ProxiedPlayer target = bungee.getProxy().getPlayer(in.readUTF());
                    final ProxiedPlayer sender = bungee.getProxy().getPlayer(in.readUTF());

                    if (!target.isConnected()) {
                        sender.sendMessage(C.prefix("Target player is not online or cannot be located."));
                    } else {
                        final String serverName = target.getServer().getInfo().getName();

                        sender.sendMessage(C.prefix(target.getName() + " has been located on: " + serverName));
                    }
                } else if (channel.equalsIgnoreCase("private_message")) {
                    final ProxiedPlayer target = bungee.getProxy().getPlayer(in.readUTF());
                    final ProxiedPlayer sender = bungee.getProxy().getPlayer(in.readUTF());
                    final String msg = in.readUTF();

                    if (!target.isConnected()) {
                        sender.sendMessage(C.prefix("Target player is not online."));
                    } else {
                        api.sendConversationMessage(sender, target, msg);
                    }
                } else if (channel.equalsIgnoreCase("private_message_reply")) {
                    final ProxiedPlayer sender = bungee.getProxy().getPlayer(in.readUTF());
                    final ProxiedPlayer lastSender = bungee.getProxy().getPlayer(in.readUTF());
                    final String msg = in.readUTF();

                    api.sendConversationMessage(sender, lastSender, msg);

                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
