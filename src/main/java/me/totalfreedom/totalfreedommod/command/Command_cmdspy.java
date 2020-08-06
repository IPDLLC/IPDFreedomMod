package me.totalfreedom.totalfreedommod.command;

<<<<<<< HEAD
import me.totalfreedom.totalfreedommod.admin.Admin;
=======
import me.totalfreedom.totalfreedommod.player.FPlayer;
>>>>>>> devel
import me.totalfreedom.totalfreedommod.rank.Rank;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

<<<<<<< HEAD
@CommandPermissions(level = Rank.MODERATOR, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Spy on commands", usage = "/<command>", aliases = "commandspy")
public class Command_cmdspy extends FreedomCommand
{
=======
@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Spy on commands", usage = "/<command>", aliases = "commandspy")
public class Command_cmdspy extends FreedomCommand
{

>>>>>>> devel
    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {

<<<<<<< HEAD
        Admin admin = plugin.al.getAdmin(playerSender);
        admin.setCommandSpy(!admin.getCommandSpy());
        plugin.al.save();
        plugin.al.updateTables();
        msg("CommandSpy " + (admin.getCommandSpy() ? "enabled." : "disabled."));
=======
        FPlayer playerdata = plugin.pl.getPlayer(playerSender);
        playerdata.setCommandSpy(!playerdata.cmdspyEnabled());
        msg("CommandSpy " + (playerdata.cmdspyEnabled() ? "enabled." : "disabled."));
>>>>>>> devel

        return true;
    }
}
