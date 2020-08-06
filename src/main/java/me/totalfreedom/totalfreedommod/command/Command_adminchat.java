package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.player.FPlayer;
import me.totalfreedom.totalfreedommod.rank.Rank;
<<<<<<< HEAD
=======
import me.totalfreedom.totalfreedommod.util.FUtil;
>>>>>>> devel
import org.apache.commons.lang3.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

<<<<<<< HEAD
@CommandPermissions(level = Rank.MODERATOR, source = SourceType.BOTH)
=======
@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH)
>>>>>>> devel
@CommandParameters(
        description = "AdminChat - Talk privately with other admins. Using <command> itself will toggle AdminChat on and off for all messages.",
        usage = "/<command> [message...]",
        aliases = "o,ac")
public class Command_adminchat extends FreedomCommand
{
<<<<<<< HEAD
=======

>>>>>>> devel
    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 0)
        {
            if (senderIsConsole)
            {
                msg("Only in-game players can toggle AdminChat.");
                return true;
            }

            FPlayer userinfo = plugin.pl.getPlayer(playerSender);
            userinfo.setAdminChat(!userinfo.inAdminChat());
            msg("Toggled Admin Chat " + (userinfo.inAdminChat() ? "on" : "off") + ".");
        }
        else
        {
            plugin.cm.adminChat(sender, StringUtils.join(args, " "));
        }
<<<<<<< HEAD
        return true;
    }
}
=======

        return true;
    }
}
>>>>>>> devel
