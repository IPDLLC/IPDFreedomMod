package me.totalfreedom.totalfreedommod.bridge;

<<<<<<< HEAD
import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.LibsDisguises;
import me.totalfreedom.disguise.DisguiseBlocker;
=======
//import me.libraryaddict.disguise.DisallowedDisguises;
//import me.libraryaddict.disguise.LibsDisguises;
//import me.libraryaddict.disguise.DisguiseAPI;
>>>>>>> devel
import me.totalfreedom.totalfreedommod.FreedomService;
import me.totalfreedom.totalfreedommod.TotalFreedomMod;
import me.totalfreedom.totalfreedommod.util.FLog;
import org.bukkit.entity.Player;
<<<<<<< HEAD
=======
import org.bukkit.Bukkit;
>>>>>>> devel
import org.bukkit.plugin.Plugin;

public class LibsDisguisesBridge extends FreedomService
{

<<<<<<< HEAD
    private LibsDisguises libsDisguisesPlugin = null;
=======
   // private LibsDisguises libsDisguisesPlugin = null;
>>>>>>> devel

    public LibsDisguisesBridge(TotalFreedomMod plugin)
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
    }
<<<<<<< HEAD

=======
/*
>>>>>>> devel
    public LibsDisguises getLibsDisguisesPlugin()
    {
        if (libsDisguisesPlugin == null)
        {
            try
            {
                final Plugin libsDisguises = server.getPluginManager().getPlugin("LibsDisguises");
                if (libsDisguises != null)
                {
                    if (libsDisguises instanceof LibsDisguises)
                    {
<<<<<<< HEAD
                        libsDisguisesPlugin = (LibsDisguises)libsDisguises;
=======
                        libsDisguisesPlugin = (LibsDisguises) libsDisguises;
>>>>>>> devel
                    }
                }
            }
            catch (Exception ex)
            {
                FLog.severe(ex);
            }
        }

        return libsDisguisesPlugin;
    }

    public Boolean isDisguised(Player player)
    {
        try
        {
            final LibsDisguises libsDisguises = getLibsDisguisesPlugin();
            if (libsDisguises != null)
            {
                return DisguiseAPI.isDisguised(player);
            }
        }
        catch (Exception ex)
        {
            FLog.severe(ex);
        }
        return null;
    }

    public void undisguiseAll(boolean admins)
    {
        try
        {
            final LibsDisguises libsDisguises = getLibsDisguisesPlugin();

            if (libsDisguises == null)
            {
                return;
            }

            for (Player player : server.getOnlinePlayers())
            {
                if (DisguiseAPI.isDisguised(player))
                {
                    if (!admins && plugin.al.isAdmin(player))
                    {
                        continue;
                    }
                    DisguiseAPI.undisguiseToAll(player);
                }
            }
        }
        catch (Exception ex)
        {
            FLog.severe(ex);
        }
    }

<<<<<<< HEAD
    public boolean isDisguisesEnabled()
    {
        return DisguiseBlocker.enabled;
    }

=======
>>>>>>> devel
    public void setDisguisesEnabled(boolean state)
    {
        final LibsDisguises libsDisguises = getLibsDisguisesPlugin();

        if (libsDisguises == null)
        {
            return;
        }

<<<<<<< HEAD
        libsDisguises.toggleUsability(state);
    }

    public boolean isEnabled()
    {
        final LibsDisguises libsDisguises = getLibsDisguisesPlugin();

        return libsDisguises != null && libsDisguises.isEnabled();
    }
=======
        if (state)
        {
            DisguiseAPI.enableDisguises();
        }
        else
        {
            DisguiseAPI.disableDisguises();
        }
    }

    public boolean isDisguisesEnabled()
    {
        return !DisallowedDisguises.disabled;
    }

    public boolean isPluginEnabled()
    {
        Plugin ld = getLibsDisguisesPlugin();

        if (ld == null)
        {
            return false;
        }

        return ld.isEnabled();
    }*/
>>>>>>> devel
}