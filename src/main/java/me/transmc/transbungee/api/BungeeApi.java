package me.transmc.transbungee.api;

import net.md_5.bungee.api.config.ServerInfo;

import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;

public class BungeeApi {

    public void sendToBukkit(final String channel, final String message, final ServerInfo server) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        DataOutputStream out = new DataOutputStream(stream);

        try {
            out.writeUTF(channel);
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        server.sendData("trans:return", stream.toByteArray());
    }
}
