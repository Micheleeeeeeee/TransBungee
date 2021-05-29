package me.transmc.transbungee.events;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.md_5.bungee.api.connection.Connection;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Event;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class PluginMessageHandler implements Listener {


    @EventHandler // Lol
    public void on(PluginMessageEvent e) {

        DataInputStream di = new DataInputStream(new ByteArrayInputStream(e.getData()));

        try {
            System.out.println(di.readUTF());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        final String subChannel = "";
//        while (true) {
//            try {
//                if (!(di.available() > 0)) break;
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//            String subChannel = null;
//            try {
//                subChannel = di.readUTF();
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//        }
//
//        if (subChannel.equalsIgnoreCase("find")) {
//
//            if (e.getSender() instanceof Server) {
//
//                final Server server = (Server) e.getSender();
//            }
//
//            if (e.getSender() instanceof ProxiedPlayer) {
//                final ProxiedPlayer player = (ProxiedPlayer) e.getSender();
//                player.sendMessage("Fat Juicy Cock");
//            }
//
//        }
    }
}
