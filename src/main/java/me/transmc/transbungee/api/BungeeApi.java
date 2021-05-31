package me.transmc.transbungee.api;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;
import me.TransMC.TransMC.api.C;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class BungeeApi {

  private HashMap<ProxiedPlayer, ProxiedPlayer> conversations = new HashMap<>();

  public void sendToBukkit(final String channel, final String message,
                           final ServerInfo server) {
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

  /**
   * Send a conversation to the ProxiedPlayers
   * and add them to the private messages hashmap
   * (if not already exists)
   * @param from
   * @param to
   * @param msg
   */

  public void sendConversationMessage(final ProxiedPlayer from,
                                      final ProxiedPlayer to,
                                      final String msg) {
    from.sendMessage(me.TransMC.TransMC.api.C.yellow + "From " +
                     me.TransMC.TransMC.api.C.reset + to.getName() +
                     me.TransMC.TransMC.api.C.gray + ": " +
                     me.TransMC.TransMC.api.C.replaceColors(msg));
    to.sendMessage(me.TransMC.TransMC.api.C.yellow + "To " +
                   me.TransMC.TransMC.api.C.reset + from.getName() +
                   me.TransMC.TransMC.api.C.gray + ": " + C.replaceColors(msg));
    conversations.putIfAbsent(to, from);
  }

  /**
   * Get last sender
   * @param recipient
   * @return
   */

  public Optional<ProxiedPlayer> getLastSender(final ProxiedPlayer recipient) {
    return Optional.ofNullable(conversations.get(recipient));
  }

  public HashMap<ProxiedPlayer, ProxiedPlayer> getConverstations() {
    return this.conversations;
  }
}
