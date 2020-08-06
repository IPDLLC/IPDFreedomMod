package me.totalfreedom.totalfreedommod.command;

import java.util.ArrayList;
import java.util.List;
import me.totalfreedom.totalfreedommod.config.ConfigEntry;
import me.totalfreedom.totalfreedommod.rank.Displayable;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.IMPOSTOR, source = SourceType.BOTH)
<<<<<<< HEAD
@CommandParameters(description = "Lists the real names of all online players.", usage = "/<command> [-a | -i | -f | -v]", aliases = "who,lsit")
public class Command_list extends FreedomCommand
{
    public boolean run(final CommandSender sender, final Player playerSender, final Command cmd, final String commandLabel, final String[] args, final boolean senderIsConsole)
=======
@CommandParameters(description = "Lists the real names of all online players.", usage = "/<command> [-a | -i | -f]", aliases = "who")
public class Command_list extends FreedomCommand
{

    private static enum ListFilter
    {

        PLAYERS,
        ADMINS,
        FAMOUS_PLAYERS,
        IMPOSTORS;
    }

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
>>>>>>> devel
    {
        if (args.length > 1)
        {
            return false;
        }
<<<<<<< HEAD
        if (FUtil.isFromHostConsole(sender.getName()))
        {
            List<String> names = new ArrayList<>();
=======

        if (FUtil.isFromHostConsole(sender.getName()))
        {
            final List<String> names = new ArrayList<>();
>>>>>>> devel
            for (Player player : server.getOnlinePlayers())
            {
                names.add(player.getName());
            }
            msg("There are " + names.size() + "/" + server.getMaxPlayers() + " players online:\n" + StringUtils.join(names, ", "), ChatColor.WHITE);
            return true;
        }
<<<<<<< HEAD
        ListFilter listFilter;
        if (args.length == 1)
        {
            String s = args[0];
            switch (s)
            {
                case "-a":
                {
                    listFilter = ListFilter.ADMINS;
                    break;
                }
                case "-v":
                {
                    checkRank(Rank.SUPER_ADMIN);
                    listFilter = ListFilter.VANISHED_ADMINS;
                    break;
                }
                case "-i":
                {
                    listFilter = ListFilter.IMPOSTORS;
                    break;
                }
                case "-f":
                {
                    listFilter = ListFilter.FAMOUS_PLAYERS;
                    break;
                }
                default:
                {
                    return false;
                }
=======

        final ListFilter listFilter;
        if (args.length == 1)
        {
            switch (args[0])
            {
                case "-a":
                    listFilter = ListFilter.ADMINS;
                    break;
                case "-i":
                    listFilter = ListFilter.IMPOSTORS;
                    break;
                case "-f":
                    listFilter = ListFilter.FAMOUS_PLAYERS;
                    break;
                default:
                    return false;
>>>>>>> devel
            }
        }
        else
        {
            listFilter = ListFilter.PLAYERS;
        }
<<<<<<< HEAD
        StringBuilder onlineStats = new StringBuilder();
        StringBuilder onlineUsers = new StringBuilder();
        onlineStats.append(ChatColor.BLUE).append("There are ").append(ChatColor.RED).append(server.getOnlinePlayers().size() - Command_vanish.VANISHED.size())
                .append(ChatColor.BLUE)
                .append(" out of a maximum ")
                .append(ChatColor.RED)
                .append(server.getMaxPlayers())
                .append(ChatColor.BLUE)
                .append(" players online.");
        List<String> n = new ArrayList<>();
        for (Player p : server.getOnlinePlayers())
        {
            if (listFilter == ListFilter.ADMINS && !plugin.al.isAdmin(p))
            {
                continue;
            }
            if (listFilter == ListFilter.ADMINS && Command_vanish.VANISHED.contains(p))
            {
                continue;
            }
            if (listFilter == ListFilter.VANISHED_ADMINS && !Command_vanish.VANISHED.contains(p))
            {
                continue;
            }
            if (listFilter == ListFilter.IMPOSTORS && !plugin.al.isAdminImpostor(p))
            {
                continue;
            }
            if (listFilter == ListFilter.FAMOUS_PLAYERS && !ConfigEntry.FAMOUS_PLAYERS.getList().contains(p.getName().toLowerCase()))
            {
                continue;
            }
            if (listFilter == ListFilter.PLAYERS && Command_vanish.VANISHED.contains(p))
=======

        final StringBuilder onlineStats = new StringBuilder();
        final StringBuilder onlineUsers = new StringBuilder();

        onlineStats.append(ChatColor.BLUE).append("There are ").append(ChatColor.RED).append(server.getOnlinePlayers().size());
        onlineStats.append(ChatColor.BLUE).append(" out of a maximum ").append(ChatColor.RED).append(server.getMaxPlayers());
        onlineStats.append(ChatColor.BLUE).append(" players online.");

        final List<String> names = new ArrayList<>();
        for (Player player : server.getOnlinePlayers())
        {
            if (listFilter == ListFilter.ADMINS && !plugin.al.isAdmin(player))
            {
                continue;
            }

            if (listFilter == ListFilter.IMPOSTORS && !plugin.al.isAdminImpostor(player))
            {
                continue;
            }

            if (listFilter == ListFilter.FAMOUS_PLAYERS && !ConfigEntry.FAMOUS_PLAYERS.getList().contains(player.getName().toLowerCase()))
>>>>>>> devel
            {
                continue;
            }

<<<<<<< HEAD
            final Displayable display = plugin.rm.getDisplay(p);
            if (!senderIsConsole && plugin.al.isAdmin(playerSender) && plugin.al.getAdmin(playerSender).getOldTags())
            {
                n.add(getOldPrefix(display) + p.getName());
            }
            else
            {
                n.add(display.getColoredTag() + p.getName());
            }
        }
        String playerType = listFilter.toString().toLowerCase().replace('_', ' ');
        onlineUsers.append("Connected ")
                .append(playerType)
                .append(": ")
                .append(StringUtils.join(n, ChatColor.WHITE + ", "));
=======
            Displayable display = plugin.rm.getDisplay(player);

            names.add(display.getColoredTag() + player.getName());
        }

        String playerType = listFilter == null ? "players" : listFilter.toString().toLowerCase().replace('_', ' ');

        onlineUsers.append("Connected ");
        onlineUsers.append(playerType + ": ");
        onlineUsers.append(StringUtils.join(names, ChatColor.WHITE + ", "));

>>>>>>> devel
        if (senderIsConsole)
        {
            sender.sendMessage(ChatColor.stripColor(onlineStats.toString()));
            sender.sendMessage(ChatColor.stripColor(onlineUsers.toString()));
        }
        else
        {
            sender.sendMessage(onlineStats.toString());
            sender.sendMessage(onlineUsers.toString());
        }
<<<<<<< HEAD
        n.clear();
        return true;
    }

    public String getOldPrefix(Displayable display)
    {
        ChatColor color = display.getColor();

        if (color.equals(ChatColor.AQUA))
        {
            color = ChatColor.GOLD;
        }
        else if (color.equals(ChatColor.GOLD))
        {
            color = ChatColor.LIGHT_PURPLE;
        }

        String prefix = "[" + display.getAbbr() + "]";

        return color + prefix;
    }

    private enum ListFilter
    {
        PLAYERS,
        ADMINS,
        VANISHED_ADMINS,
        FAMOUS_PLAYERS,
        IMPOSTORS
=======

        return true;
>>>>>>> devel
    }
}
