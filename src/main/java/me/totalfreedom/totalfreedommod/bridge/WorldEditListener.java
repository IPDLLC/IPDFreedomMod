package me.totalfreedom.totalfreedommod.bridge;

import me.totalfreedom.totalfreedommod.TotalFreedomMod;
<<<<<<< HEAD
import me.totalfreedom.worldedit.LimitChangedEvent;
import me.totalfreedom.worldedit.SelectionChangedEvent;
=======
import me.totalfreedom.totalfreedommod.util.FUtil;
import me.totalfreedom.worldedit.LimitChangedEvent;
import me.totalfreedom.worldedit.SelectionChangedEvent;

>>>>>>> devel
import net.pravian.aero.component.PluginListener;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

public class WorldEditListener extends PluginListener<TotalFreedomMod>
{
<<<<<<< HEAD
=======

>>>>>>> devel
    public WorldEditListener(TotalFreedomMod plugin)
    {
        super(plugin);
    }

    @EventHandler
    public void onSelectionChange(final SelectionChangedEvent event)
    {
        final Player player = event.getPlayer();

        if (plugin.al.isAdmin(player))
        {
            return;
        }

        if (plugin.pa.isInProtectedArea(
                event.getMinVector(),
                event.getMaxVector(),
                event.getWorld().getName()))
        {
<<<<<<< HEAD
=======

>>>>>>> devel
            player.sendMessage(ChatColor.RED + "The region that you selected contained a protected area. Selection cleared.");
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onLimitChanged(LimitChangedEvent event)
    {
<<<<<<< HEAD
        Player player = event.getPlayer();
        Player target = event.getTarget();
=======
        final Player player = event.getPlayer();
>>>>>>> devel

        if (plugin.al.isAdmin(player))
        {
            return;
        }

<<<<<<< HEAD
        if (!player.equals(target))
        {
            player.sendMessage(ChatColor.RED + "Only admins can change the limit for other players!");
            event.setCancelled(true);
            return;
        }

        if (event.getLimit() < 0 || event.getLimit() > 200000)
        {
            player.sendMessage(ChatColor.RED + "You cannot set your limit higher than 200000 or to -1!");
            event.setCancelled(true);
            return;
        }
    }
=======
        if (!event.getPlayer().equals(event.getTarget()))
        {
            player.sendMessage(ChatColor.RED + "Only admins can change the limit for other players!");
            event.setCancelled(true);
        }

        if (event.getLimit() < 0 || event.getLimit() > 10000)
        {
            player.setOp(false);
            FUtil.bcastMsg(event.getPlayer().getName() + " tried to set their WorldEdit limit to " + event.getLimit() + " and has been de-opped", ChatColor.RED);
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + "You cannot set your limit higher than 10000 or to -1!");
        }
    }

>>>>>>> devel
}
