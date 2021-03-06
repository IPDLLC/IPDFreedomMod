package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.TELNET_ADMIN, source = SourceType.ONLY_CONSOLE)
@CommandParameters(description = "Kicks everyone and stops the server.", usage = "/<command> [reason]")
public class Command_stop extends FreedomCommand
{
    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        FUtil.bcastMsg("Server is going offline!", ChatColor.LIGHT_PURPLE);

        String reason = "Server is restarting or has crashed. Please reconnect in around 20 seconds.";

        if (args.length > 0)
        {
            reason = StringUtils.join(args, " ");
        }

        for (Player player : server.getOnlinePlayers())
        {
            player.kickPlayer(reason);
        }

        server.shutdown();

        return true;
    }
}
