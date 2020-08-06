package me.totalfreedom.totalfreedommod.command;

<<<<<<< HEAD
import me.totalfreedom.disguise.DisguiseBlocker;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.command.Command;
=======
//import me.libraryaddict.disguise.DisallowedDisguises;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.command.Command;
import org.bukkit.ChatColor;
>>>>>>> devel
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH)
@CommandParameters(description = "Toggle the disguise plugin", usage = "/<command>", aliases = "dtoggle")
public class Command_disguisetoggle extends FreedomCommand
{
<<<<<<< HEAD
    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (!plugin.ldb.isEnabled())
        {
            msg("LibsDisguises is not enabled.");
            return true;
        }

        FUtil.adminAction(sender.getName(), (DisguiseBlocker.enabled ? "Disabling" : "Enabling") + " disguises", false);
=======

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {/*
        if (!plugin.ldb.isPluginEnabled())
        {
            msg(ChatColor.RED + "LibsDisguises is not enabled.");
            return true;
        }

        FUtil.adminAction(sender.getName(), (DisallowedDisguises.disabled ? "Enabling" : "Disabling") + " " +
                "Disguises", false);
>>>>>>> devel

        if (plugin.ldb.isDisguisesEnabled())
        {
            plugin.ldb.undisguiseAll(true);
            plugin.ldb.setDisguisesEnabled(false);
        }
        else
        {
            plugin.ldb.setDisguisesEnabled(true);
        }

<<<<<<< HEAD
        msg("Disguises are now " + (DisguiseBlocker.enabled ? "enabled." : "disabled."));

=======
        msg("Disguises are now " + (!DisallowedDisguises.disabled ? "enabled." : "disabled."));

        return true;

*/
        
        msg("This command has been disabled for technical reasons. Contact a developer for additional information.");
>>>>>>> devel
        return true;
    }
}
