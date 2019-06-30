package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.reporting.Report;
import net.pravian.aero.util.Ips;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.OP, source = SourceType.ONLY_IN_GAME, blockHostConsole = true)
@CommandParameters(description = "Report a player for admins to see.", usage = "/<command> <player> <reason>")
public class Command_report extends FreedomCommand
{
    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length < 2)
        {
            return false;
        }

        Player player = getPlayer(args[0]);

        if (player == null)
        {
            msg(PLAYER_NOT_FOUND);
            return true;
        }

        if (sender instanceof Player)
        {
            if (player.equals(playerSender))
            {
                msg(ChatColor.RED + "Please, don't try to report yourself.");
                return true;
            }
        }

        if (plugin.al.isAdmin(player))
        {
            msg(ChatColor.RED + "You can not report an admin.");
            return true;
        }

        String location = player.getWorld().getName() + ", " + player.getLocation().getBlockX() + ", " + player.getLocation().getBlockY() + ", " + player.getLocation().getBlockZ();
        String report = StringUtils.join(ArrayUtils.subarray(args, 1, args.length), " ");

        plugin.cm.reportAction(playerSender, player, report);
        plugin.rel.logReport(new Report(player.getName(), Ips.getIp(player), sender.getName(), report, location));
        msg(ChatColor.GREEN + "Thank you, your report has been successfully logged.");

        if (plugin.dc.enabled)
        {
            plugin.dc.sendReport(playerSender, player, report);
            msg(ChatColor.RED + "Note: This report has been logged to a Discord channel. As with any report system, spamming reports can lead to you getting banned.");
        }

        return true;
    }
}
