package ml.bjorn.bungeenotifier;

import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public final class BungeeNotifier extends Plugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    class ConnectListener implements Listener {
        @EventHandler
        public void onPlayerJoin(ServerConnectEvent event) {
            event.getTarget().getName();
        }
    }
}
