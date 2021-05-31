package me.transmc.transbungee.modules.find;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class FindCommand extends Command {

  public FindCommand() { super("findp"); }

  @Override
  public void execute(CommandSender sender, String[] args) {

    if (!(sender instanceof ProxiedPlayer)) {
      System.out.println("Only players may execute this command.");
    }

    ProxiedPlayer p = (ProxiedPlayer)sender;
  }
}
