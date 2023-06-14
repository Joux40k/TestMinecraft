package de.joux.firstplugin1.command;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.TabExecutor;

import java.util.Iterator;
import java.util.function.Consumer;

public class FindCommand  extends Command implements TabExecutor {


    public FindCommand(String name, String... aliases) {
        super(name, null, aliases);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer pp) {
            if (!pp.hasPermission("firstplugin.find")) {
                pp.sendMessage(new TextComponent("no permission"));
                return;
            }
            if (args.length == 0) {
               pp.sendMessage(new TextComponent(pp.getServer().getInfo().getName()));
            } else if (args.length == 1) {
                ProxiedPlayer player = ProxyServer.getInstance().getPlayer(args[0]);
                if (player == null) {
                    pp.sendMessage(new TextComponent("Player is offline"));
                } else {
                    pp.sendMessage(new TextComponent(player.getName() + " is playing on: " + player.getServer().getInfo().getName()));
                }
            }
        } else{
            sender.sendMessage(new TextComponent("can only be accessed by player"));
        }
    }

    @Override
    public Iterable<String> onTabComplete(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer pp){
            if (!pp.hasPermission("firstplugin.find")) {
                pp.sendMessage(new TextComponent("no permission"));
                return null;
            }
            Iterable<String> nameList = new Iterable<String>() {
                @Override
                public void forEach(Consumer<? super String> action) {
                    Iterable.super.forEach(action);
                }
            }
            }
        }
    }
}
