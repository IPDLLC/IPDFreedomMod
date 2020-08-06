package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

<<<<<<< HEAD
@CommandPermissions(level = Rank.MODERATOR, source = SourceType.BOTH)
@CommandParameters(description = "Warns a player.", usage = "/<command> <player> <reason>")
public class Command_warn extends FreedomCommand
{
=======
@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH, blockHostConsole = true)
@CommandParameters(description = "Warns a player.", usage = "/<command> <player> <reason>")
public class Command_warn extends FreedomCommand
{

>>>>>>> devel
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
                msg(ChatColor.RED + "Please, don't try to warn yourself.");
                return true;
            }
        }

        if (plugin.al.isAdmin(player))
        {
            msg(ChatColor.RED + "You can not warn admins");
            return true;
        }

        String warnReason = StringUtils.join(ArrayUtils.subarray(args, 1, args.length), " ");
<<<<<<< HEAD
        msg(player, ChatColor.RED + "[WARNING] You received a warning: " + warnReason);
        msg(ChatColor.GREEN + "You have successfully warned " + player.getName());
        final StringBuilder adminNotice = new StringBuilder()
                .append(ChatColor.RED)
                .append(sender.getName())
                .append(" - ")
                .append("Warning: ")
                .append(player.getName())
                .append(" - Reason: ")
                .append(ChatColor.YELLOW)
                .append(warnReason);
        plugin.al.messageAllAdmins(adminNotice.toString());
        plugin.pl.getPlayer(player).incrementWarnings();
=======

        msg(player, ChatColor.RED + "[WARNING] You received a warning: " + warnReason);
        msg(ChatColor.GREEN + "You have successfully warned " + player.getName());

        plugin.pl.getPlayer(player).incrementWarnings();

>>>>>>> devel
        return true;
    }
}
