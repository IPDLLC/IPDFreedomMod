package me.totalfreedom.totalfreedommod.command;

<<<<<<< HEAD
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
=======
>>>>>>> devel
import me.totalfreedom.totalfreedommod.config.ConfigEntry;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

<<<<<<< HEAD
@CommandPermissions(level = Rank.MODERATOR, source = SourceType.ONLY_CONSOLE, blockHostConsole = true)
@CommandParameters(description = "Close server to members.", usage = "/<command> [on | off]")
public class Command_adminmode extends FreedomCommand
{
=======
@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.ONLY_CONSOLE, blockHostConsole = true)
@CommandParameters(description = "Close server to non-superadmins.", usage = "/<command> [on | off]")
public class Command_adminmode extends FreedomCommand
{

>>>>>>> devel
    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length != 1)
        {
            return false;
        }

        if (args[0].equalsIgnoreCase("off"))
        {
            ConfigEntry.ADMIN_ONLY_MODE.setBoolean(false);
            FUtil.adminAction(sender.getName(), "Opening the server to all players.", true);
            return true;
        }
        else if (args[0].equalsIgnoreCase("on"))
        {
            ConfigEntry.ADMIN_ONLY_MODE.setBoolean(true);
<<<<<<< HEAD
            FUtil.adminAction(sender.getName(), "Closing the server to all non-staff members.", true);
=======
            FUtil.adminAction(sender.getName(), "Closing the server to non-superadmins.", true);
>>>>>>> devel
            for (Player player : server.getOnlinePlayers())
            {
                if (!isAdmin(player))
                {
<<<<<<< HEAD
                    player.kickPlayer("Server is now closed to all non-staff members.");
=======
                    player.kickPlayer("Server is now closed to non-superadmins.");
>>>>>>> devel
                }
            }
            return true;
        }

        return false;
    }
<<<<<<< HEAD

    @Override
    public List<String> getTabCompleteOptions(CommandSender sender, Command command, String alias, String[] args)
    {
        if (args.length == 1 && plugin.al.isAdmin(sender) && !(sender instanceof Player))
        {
            return Arrays.asList("on", "off");
        }

        return Collections.emptyList();
    }
=======
>>>>>>> devel
}
