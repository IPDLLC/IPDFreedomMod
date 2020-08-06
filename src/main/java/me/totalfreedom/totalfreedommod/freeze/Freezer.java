package me.totalfreedom.totalfreedommod.freeze;

import lombok.Getter;
import me.totalfreedom.totalfreedommod.FreedomService;
import me.totalfreedom.totalfreedommod.TotalFreedomMod;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerMoveEvent;

public class Freezer extends FreedomService
{

    @Getter
    private boolean globalFreeze = false;

    public Freezer(TotalFreedomMod plugin)
    {
        super(plugin);
    }

    @Override
    protected void onStart()
    {
        globalFreeze = false;
    }

    @Override
    protected void onStop()
    {
    }

<<<<<<< HEAD
=======
    public void setGlobalFreeze(boolean frozen)
    {
        this.globalFreeze = frozen;
    }

>>>>>>> devel
    public void purge()
    {
        this.globalFreeze = false;

        for (Player player : server.getOnlinePlayers())
        {
            plugin.pl.getPlayer(player).getFreezeData().setFrozen(false);
        }
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onPlayerMove(PlayerMoveEvent event)
    {
        final Player player = event.getPlayer();

        if (plugin.al.isAdmin(player))
        {
            return;
        }

        final FreezeData fd = plugin.pl.getPlayer(player).getFreezeData();
        if (!fd.isFrozen() && !globalFreeze)
        {
            return;
        }

        FUtil.setFlying(player, true);

<<<<<<< HEAD
        Location loc = player.getLocation();
=======
        Location loc = fd.getLocation();
>>>>>>> devel
        if (loc == null)
        {
            loc = event.getFrom();
        }

        event.setTo(loc);
    }

<<<<<<< HEAD
    public boolean isGlobalFreeze()
    {
        return this.globalFreeze;
    }

    public void setGlobalFreeze(boolean frozen)
    {
        this.globalFreeze = frozen;
    }
=======
>>>>>>> devel
}
