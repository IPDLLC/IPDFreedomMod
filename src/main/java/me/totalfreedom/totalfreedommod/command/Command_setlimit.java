package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
<<<<<<< HEAD
import org.bukkit.ChatColor;
=======
>>>>>>> devel
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH)
<<<<<<< HEAD
@CommandParameters(description = "Sets everyone's WorldEdit block modification limit to the default limit or to a custom limit.", usage = "/<command> [limit]", aliases = "setl, swl")
public class Command_setlimit extends FreedomCommand
{
    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        int amount = plugin.web.getDefaultLimit();
        if (args.length > 0)
        {
            try
            {
                amount = Math.max(1, Math.min(plugin.web.getMaxLimit(), Integer.parseInt(args[0])));
            }
            catch (NumberFormatException ex)
            {
                msg("Invalid number: " + args[0], ChatColor.RED);
                return true;
            }
        }
        boolean success = false;
        for (final Player player : server.getOnlinePlayers())
        {
            try
            {
                plugin.web.setLimit(player, amount);
                success = true;
            }
            catch (NoClassDefFoundError | NullPointerException ex)
            {
                msg("WorldEdit is not enabled on this server.");
                success = false;
            }
        }
        if (success)
        {
            FUtil.adminAction(sender.getName(), "Setting everyone's WorldEdit block modification limit to " + amount + ".", true);
=======
@CommandParameters(description = "Sets everyone's Worldedit block modification limit to the default.", usage = "/<command>", aliases = "setl,swl")
public class Command_setlimit extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        FUtil.adminAction(sender.getName(), "Setting everyone's Worldedit block modification limit to 2500.", true);
        for (final Player player : server.getOnlinePlayers())
        {
            plugin.web.setLimit(player, 2500);
>>>>>>> devel
        }
        return true;
    }
}
