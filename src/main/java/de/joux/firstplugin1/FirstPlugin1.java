package de.joux.firstplugin1;

import de.joux.firstplugin1.command.FindCommand;
import de.joux.firstplugin1.listener.ChatListener;
import net.md_5.bungee.api.plugin.Plugin;

public final class FirstPlugin1 extends Plugin {

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerListener(this, new ChatListener());
        getProxy().getPluginManager().registerCommand(this, new FindCommand("firstpluginfind", "find"));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
