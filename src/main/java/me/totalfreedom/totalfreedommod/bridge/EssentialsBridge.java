package me.totalfreedom.totalfreedommod.bridge;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.User;
import com.earth2me.essentials.utils.DateUtil;
import com.earth2me.essentials.utils.EnumUtil;
import me.totalfreedom.totalfreedommod.FreedomService;
import me.totalfreedom.totalfreedommod.TotalFreedomMod;
import me.totalfreedom.totalfreedommod.command.Command_vanish;
import me.totalfreedom.totalfreedommod.util.FLog;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class EssentialsBridge extends FreedomService
{

    private Essentials essentialsPlugin = null;

    public EssentialsBridge(TotalFreedomMod plugin)
    {
        super(plugin);
    }

    @Override
    protected void onStart()
    {
    }

    @Override
    protected void onStop()
    {
        Command_vanish.VANISHED.clear();
    }

    public Essentials getEssentialsPlugin()
    {
        if (essentialsPlugin == null)
        {
            try
            {
                final Plugin essentials = server.getPluginManager().getPlugin("Essentials");
                if (essentials != null && essentials instanceof Essentials)
                {
                    essentialsPlugin = (Essentials)essentials;
                }
            }
            catch (Exception ex)
            {
                FLog.severe(ex);
            }
        }
        return essentialsPlugin;
    }

    public User getEssentialsUser(String username)
    {
        try
        {
            Essentials essentials = getEssentialsPlugin();
            if (essentials != null)
            {
                return essentials.getUserMap().getUser(username);
            }
        }
        catch (Exception ex)
        {
            FLog.severe(ex);
        }
        return null;
    }

    public String getPlaytime(String username)
    {
        User user = getEssentialsUser(username);
        Statistic PLAY_ONE_TICK = EnumUtil.getStatistic("PLAY_ONE_MINUTE", "PLAY_ONE_TICK");
        long playtimeMs = System.currentTimeMillis() - (user.getBase().getStatistic(PLAY_ONE_TICK) * 50);
        return DateUtil.formatDateDiff(playtimeMs);
    }

    public boolean isAFK(String username)
    {
        User user = getEssentialsUser(username);
        return user.isAfk();
    }

    public String getAFKDuration(String username)
    {
        User user = getEssentialsUser(username);
        return DateUtil.formatDateDiff(user.getAfkSince());
    }

    public void setNickname(String username, String nickname)
    {
        try
        {
            User user = getEssentialsUser(username);
            if (user != null)
            {
                user.setNickname(nickname);
                user.setDisplayNick();
            }
        }
        catch (Exception ex)
        {
            FLog.severe(ex);
        }
    }

    public String getNickname(String username)
    {
        try
        {
            User user = getEssentialsUser(username);
            if (user != null)
            {
                return user.getNickname();
            }
        }
        catch (Exception ex)
        {
            FLog.severe(ex);
        }
        return null;
    }

    public boolean getGodMode(String username)
    {
        try
        {
            User user = getEssentialsUser(username);
            if (user != null)
            {
                return user.isGodModeEnabled();
            }
        }
        catch (Exception ex)
        {
            FLog.severe(ex);
        }
        return false;
    }

    public long getLastActivity(String username)
    {
        try
        {
            User user = getEssentialsUser(username);
            if (user != null)
            {
                return FUtil.getField(user, "lastActivity");
            }
        }
        catch (Exception ex)
        {
            FLog.severe(ex);
        }
        return 0L;
    }

    public void setVanished(String username, boolean vanished)
    {
        try
        {
            User user = getEssentialsUser(username);
            if (user != null)
            {
                user.setVanished(vanished);
            }
        }
        catch (Exception ex)
        {
            FLog.severe(ex);
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerQuit(PlayerQuitEvent event)
    {
        Player player = event.getPlayer();
        if (Command_vanish.VANISHED.contains(player))
        {
            Command_vanish.VANISHED.remove(player);
        }
    }

    public boolean isEnabled()
    {
        final Essentials ess = getEssentialsPlugin();

        return ess != null && ess.isEnabled();
    }
}
