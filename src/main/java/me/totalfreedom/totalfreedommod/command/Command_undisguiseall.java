package me.totalfreedom.totalfreedommod.command;

<<<<<<< HEAD
import me.totalfreedom.disguise.DisguiseBlocker;
=======
//import me.libraryaddict.disguise.DisallowedDisguises;
>>>>>>> devel
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH)
<<<<<<< HEAD
@CommandParameters(description = "Undisguise all players on the server", usage = "/<command> [-a]", aliases = "uall")
public class Command_undisguiseall extends FreedomCommand
{
    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (!plugin.ldb.isEnabled())
=======
@CommandParameters(description = "Undisguise all players on the server", usage = "/<command>", aliases = "uall")
public class Command_undisguiseall extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    { /*
        if (!plugin.ldb.isPluginEnabled())
>>>>>>> devel
        {
            msg("LibsDisguises is not enabled.");
            return true;
        }

<<<<<<< HEAD
        if (!DisguiseBlocker.enabled)
=======
        if (DisallowedDisguises.disabled)
>>>>>>> devel
        {
            msg("Disguises are not enabled.");
            return true;
        }

<<<<<<< HEAD
        boolean admins = false;

        if (args.length > 0 && args[0].equalsIgnoreCase("-a"))
        {
            admins = true;
        }

        plugin.ldb.undisguiseAll(admins);
        FUtil.adminAction(sender.getName(), "Undisguising all " + (admins ? "players" : "non-admins"), true);
=======
        FUtil.adminAction(sender.getName(), "Undisguising all non-admins", true);

        plugin.ldb.undisguiseAll(false);

        return true;

*/
        
        msg("This command has been disabled for technical reasons. Contact a developer for additional information.");
>>>>>>> devel
        return true;
    }
}
