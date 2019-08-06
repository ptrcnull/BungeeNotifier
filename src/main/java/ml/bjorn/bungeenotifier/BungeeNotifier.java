package ml.bjorn.bungeenotifier;

import net.md_5.bungee.api.plugin.Plugin;

public final class BungeeNotifier extends Plugin {

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerListener(this, new ConnectListener(this));
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
