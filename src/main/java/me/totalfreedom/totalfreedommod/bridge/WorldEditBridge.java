package me.totalfreedom.totalfreedommod.bridge;

import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.bukkit.BukkitPlayer;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import me.totalfreedom.totalfreedommod.FreedomService;
import me.totalfreedom.totalfreedommod.TotalFreedomMod;
import me.totalfreedom.totalfreedommod.util.FLog;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class WorldEditBridge extends FreedomService
{
<<<<<<< HEAD
    private final WorldEditListener listener;
    //
    private WorldEditPlugin worldeditPlugin = null;
=======

    private final WorldEditListener listener;
    //
    private WorldEditPlugin worldedit = null;
>>>>>>> devel

    public WorldEditBridge(TotalFreedomMod plugin)
    {
        super(plugin);
        listener = new WorldEditListener(plugin);
    }

    @Override
    protected void onStart()
    {
        listener.register();
    }

    @Override
    protected void onStop()
    {
        listener.unregister();
    }

<<<<<<< HEAD
    public WorldEditPlugin getWorldEditPlugin()
    {
        if (worldeditPlugin == null)
        {
            try
            {
                Plugin we = server.getPluginManager().getPlugin("WorldEdit");
                if (we != null)
                {
                    if (we instanceof WorldEditPlugin)
                    {
                        worldeditPlugin = (WorldEditPlugin)we;
                    }
                }
            }
            catch (Exception ex)
            {
                FLog.severe(ex);
            }
        }

        return worldeditPlugin;
    }

=======
>>>>>>> devel
    public void undo(Player player, int count)
    {
        try
        {
            LocalSession session = getPlayerSession(player);
            if (session != null)
            {
                final BukkitPlayer bukkitPlayer = getBukkitPlayer(player);
                if (bukkitPlayer != null)
                {
                    for (int i = 0; i < count; i++)
                    {
                        session.undo(session.getBlockBag(bukkitPlayer), bukkitPlayer);
                    }
                }
            }
        }
        catch (Exception ex)
        {
            FLog.severe(ex);
        }
    }

<<<<<<< HEAD
    public void redo(Player player, int count)
    {
        try
        {
            LocalSession session = getPlayerSession(player);
            if (session != null)
            {
                final BukkitPlayer bukkitPlayer = getBukkitPlayer(player);
                if (bukkitPlayer != null)
                {
                    for (int i = 0; i < count; i++)
                    {
                        session.redo(session.getBlockBag(bukkitPlayer), bukkitPlayer);
                    }
                }
            }
        }
        catch (Exception ex)
        {
            FLog.severe(ex);
        }
=======
    private WorldEditPlugin getWorldEditPlugin()
    {
        if (worldedit == null)
        {
            try
            {
                Plugin we = server.getPluginManager().getPlugin("WorldEdit");
                if (we != null)
                {
                    if (we instanceof WorldEditPlugin)
                    {
                        worldedit = (WorldEditPlugin) we;
                    }
                }
            }
            catch (Exception ex)
            {
                FLog.severe(ex);
            }
        }

        return worldedit;
>>>>>>> devel
    }

    public void setLimit(Player player, int limit)
    {
        try
        {
            final LocalSession session = getPlayerSession(player);
            if (session != null)
            {
                session.setBlockChangeLimit(limit);
            }
        }
        catch (Exception ex)
        {
            FLog.severe(ex);
        }

    }

<<<<<<< HEAD
    public int getDefaultLimit()
    {
        final WorldEditPlugin wep = getWorldEditPlugin();
        if (wep == null)
        {
            return 0;
        }

        return wep.getLocalConfiguration().defaultChangeLimit;

    }

    public int getMaxLimit()
    {
        final WorldEditPlugin wep = getWorldEditPlugin();
        if (wep == null)
        {
            return 0;
        }

        return wep.getLocalConfiguration().maxChangeLimit;

    }

=======
>>>>>>> devel
    private LocalSession getPlayerSession(Player player)
    {
        final WorldEditPlugin wep = getWorldEditPlugin();
        if (wep == null)
        {
            return null;
        }

        try
        {
            return wep.getSession(player);
        }
        catch (Exception ex)
        {
            FLog.severe(ex);
            return null;
        }
    }

    private BukkitPlayer getBukkitPlayer(Player player)
    {
        final WorldEditPlugin wep = getWorldEditPlugin();
        if (wep == null)
        {
            return null;
        }

        try
        {
            return wep.wrapPlayer(player);
        }
        catch (Exception ex)
        {
            FLog.severe(ex);
            return null;
        }
    }
}
