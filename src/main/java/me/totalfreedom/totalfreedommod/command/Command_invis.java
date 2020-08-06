package me.totalfreedom.totalfreedommod.command;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Collections;
=======
>>>>>>> devel
import java.util.List;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH)
<<<<<<< HEAD
@CommandParameters(description = "Shows (optionally clears) invisible players", usage = "/<command> [clear]")
public class Command_invis extends FreedomCommand
{
=======
@CommandParameters(description = "Shows (and optionally clears) invisisible players", usage = "/<command> [clear]")
public class Command_invis extends FreedomCommand
{

>>>>>>> devel
    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        boolean clear = false;
<<<<<<< HEAD

=======
>>>>>>> devel
        if (args.length >= 1)
        {
            if (args[0].equalsIgnoreCase("clear"))
            {
<<<<<<< HEAD
                FUtil.adminAction(sender.getName(), "Clearing all invisibility potion effects from all players", true);
=======
                FUtil.adminAction(sender.getName(), "Clearing invisibility for all players", false);
>>>>>>> devel
                clear = true;
            }
            else
            {
                return false;
            }
        }

<<<<<<< HEAD
        List<String> players = new ArrayList<String>();
=======
        List<String> players = new ArrayList<>();
>>>>>>> devel
        int clears = 0;

        for (Player player : server.getOnlinePlayers())
        {
            if (player.hasPotionEffect(PotionEffectType.INVISIBILITY))
            {
                players.add(player.getName());
                if (clear && !plugin.al.isAdmin(player))
                {
<<<<<<< HEAD
                    player.removePotionEffect((PotionEffectType.INVISIBILITY));
=======
                    player.removePotionEffect(PotionEffectType.INVISIBILITY);
>>>>>>> devel
                    clears++;
                }
            }
        }

        if (players.isEmpty())
        {
            msg("There are no invisible players");
            return true;
        }
<<<<<<< HEAD
        if (clear)
        {
            msg("Cleared " + clears + " players");
=======

        if (clear)
        {
            msg("Cleared invisibility effect from " + clears + " players");
>>>>>>> devel
        }
        else
        {
            msg("Invisible players (" + players.size() + "): " + StringUtils.join(players, ", "));
        }
<<<<<<< HEAD
        return true;
    }

    @Override
    public List<String> getTabCompleteOptions(CommandSender sender, Command command, String alias, String[] args)
    {
        if (args.length == 1 && plugin.al.isAdmin(sender))
        {
            return Collections.singletonList("clear");
        }

        return Collections.emptyList();
    }
}
=======

        return true;
    }
}
>>>>>>> devel
