package me.totalfreedom.totalfreedommod.command;

import java.util.ArrayList;
import java.util.List;
import me.totalfreedom.totalfreedommod.rank.Rank;
<<<<<<< HEAD
=======
import me.totalfreedom.totalfreedommod.util.DepreciationAggregator;
>>>>>>> devel
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH)
@CommandParameters(description = "See who has a block and optionally clears the item.", usage = "/<command> <item> clear", aliases = "wh")
public class Command_whohas extends FreedomCommand
{
<<<<<<< HEAD
=======

>>>>>>> devel
    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length < 1)
        {
            return false;
        }

        final boolean doClear = args.length >= 2 && "clear".equalsIgnoreCase(args[1]);

        final String materialName = args[0];
        Material material = Material.matchMaterial(materialName);
<<<<<<< HEAD

        if (material == null)
        {
            msg("Invalid item: " + materialName, ChatColor.RED);
=======
        if (material == null)
        {
            try
            {
                material = DepreciationAggregator.getMaterial(Integer.parseInt(materialName));
            }
            catch (NumberFormatException ex)
            {
            }
        }

        if (material == null)
        {
            msg("Invalid block: " + materialName, ChatColor.RED);
>>>>>>> devel
            return true;
        }

        final List<String> players = new ArrayList<>();

        for (final Player player : server.getOnlinePlayers())
        {
            if (player.getInventory().contains(material))
            {
                players.add(player.getName());
                if (doClear && !plugin.al.isAdmin(player))
                {
                    player.getInventory().remove(material);
                }
            }
        }

        if (players.isEmpty())
        {
<<<<<<< HEAD
            msg("There are no players with that item.");
=======
            msg("There are no players with that item");
>>>>>>> devel
        }
        else
        {
            msg("Players with item " + material.name() + ": " + StringUtils.join(players, ", "));
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
