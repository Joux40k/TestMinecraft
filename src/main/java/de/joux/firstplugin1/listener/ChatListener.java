package de.joux.firstplugin1.listener;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

public class ChatListener implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onChat(ChatEvent chatEvent) {
        //ProxiedPlayer wird in pp gecastet
        if (chatEvent.getSender() instanceof ProxiedPlayer pp){
            if ("hello".equals(chatEvent.getMessage())) {
                pp.sendMessage("hello world");
                chatEvent.setCancelled(true);
            }
            if ("hi".equals(chatEvent.getMessage())) {
                pp.sendMessage(new TextComponent(""));
                chatEvent.setMessage("hallo");
            }


        }

    }


}
