package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SENIOR_ADMIN, source = SourceType.ONLY_CONSOLE, blockHostConsole = true)
@CommandParameters(description = "Wipes all logged reports or reports for a specific user.", usage = "/<command> <username | -a>")
public class Command_wipereports extends FreedomCommand
{
    @Override
    public boolean run(final CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length < 1)
        {
            return false;
        }

        if (args[0].equalsIgnoreCase("-a"))
        {
            FUtil.adminAction(sender.getName(), "Wiping the reports history", true);
            plugin.rel.clear();
            msg("Wiped " + plugin.pul.clear() + " reports.");
        }
        else
        {
            String username = args[0];
            FUtil.adminAction(sender.getName(), "Wiping the report history for " + username, true);
            plugin.rel.clear(username);
            msg("Wiped " + plugin.pul.clear(username) + " reports for " + username + ".");
        }
        return true;
    }
}