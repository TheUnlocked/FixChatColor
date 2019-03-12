package unlocked.fixchatcolors;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Team;

public class FixChatColors extends JavaPlugin implements Listener{
    Server server;

    @Override
    public void onEnable() {
        server = getServer();

        server.getPluginManager().registerEvents(this,this);
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onChatEvent(AsyncPlayerChatEvent e){
        if (e.getPlayer() == null)
            return;

        Team team = e.getPlayer().getScoreboard().getPlayerTeam(e.getPlayer());

        if (team == null)
            return;

        e.setFormat("<" + team.getColor() + "%1$s" + ChatColor.RESET + "> %2$s");
    }
}
