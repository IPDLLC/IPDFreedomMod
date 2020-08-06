package me.totalfreedom.totalfreedommod.command;

<<<<<<< HEAD
import me.totalfreedom.totalfreedommod.config.ConfigEntry;
=======
>>>>>>> devel
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

<<<<<<< HEAD
@CommandPermissions(level = Rank.SENIOR_ADMIN, source = SourceType.BOTH, blockHostConsole = true)
@CommandParameters(description = "Wipe the flatlands map. Requires manual restart after command is used.", usage = "/<command>")
public class Command_wipeflatlands extends FreedomCommand
{
    @Override
    public boolean run(final CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (!ConfigEntry.FLATLANDS_GENERATE.getBoolean())
        {
            msg("Flatlands generation is disabled, therefore it cannot be wiped.");
            return true;
        }

=======
@CommandPermissions(level = Rank.SENIOR_ADMIN, source = SourceType.ONLY_CONSOLE, blockHostConsole = true)
@CommandParameters(description = "Wipe the flatlands map. Requires manual restart after command is used.", usage = "/<command>")
public class Command_wipeflatlands extends FreedomCommand
{

    @Override
    public boolean run(final CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
>>>>>>> devel
        plugin.sf.setSavedFlag("do_wipe_flatlands", true);

        FUtil.bcastMsg("Server is going offline for flatlands wipe.", ChatColor.GRAY);

<<<<<<< HEAD
        if (plugin.wgb.isEnabled())
        {
            plugin.wgb.wipeRegions(plugin.wm.flatlands.getWorld());
        }

=======
>>>>>>> devel
        for (Player player : server.getOnlinePlayers())
        {
            player.kickPlayer("Server is going offline for flatlands wipe, come back in a few minutes.");
        }

<<<<<<< HEAD
        if (!plugin.amp.enabled)
        {
            server.shutdown();
        }
        else
        {
            plugin.amp.restartServer();
        }
        return true;
    }
}
=======
        server.shutdown();

        return true;
    }
}
>>>>>>> devel
