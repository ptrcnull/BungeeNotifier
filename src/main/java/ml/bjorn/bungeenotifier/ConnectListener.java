package ml.bjorn.bungeenotifier;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ConnectListener implements Listener {
    private BungeeNotifier plugin;

    ConnectListener(BungeeNotifier plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(ServerConnectEvent event) {
        System.out.println(event.getPlayer().getName());

        TextComponent message = new TextComponent();

        TextComponent player = new TextComponent(event.getPlayer().getDisplayName());
        player.setColor(ChatColor.YELLOW);
        message.addExtra(player);

        TextComponent joined = new TextComponent(" joined ");
        joined.setColor(ChatColor.DARK_AQUA);
        message.addExtra(joined);

        TextComponent server = new TextComponent(event.getTarget().getName());
        server.setColor(ChatColor.AQUA);
        message.addExtra(server);

        if (event.getPlayer().getServer() != null) {
            TextComponent from = new TextComponent(" from ");
            from.setColor(ChatColor.DARK_AQUA);
            message.addExtra(from);

            TextComponent origin = new TextComponent(event.getPlayer().getServer().getInfo().getName());
            origin.setColor(ChatColor.AQUA);
            message.addExtra(origin);
        }

        plugin.getProxy().getPlayers().forEach(proxiedPlayer -> {
            if (proxiedPlayer.hasPermission("bungeenotifier.notify")) {
                proxiedPlayer.sendMessage(message);
            }
        });
//      event.getTarget().getName();
    }
}
