package me.totalfreedom.totalfreedommod.command;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
import me.totalfreedom.totalfreedommod.banning.Ban;
import me.totalfreedom.totalfreedommod.player.PlayerData;
import me.totalfreedom.totalfreedommod.punishments.Punishment;
import me.totalfreedom.totalfreedommod.punishments.PunishmentType;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
=======
import me.totalfreedom.totalfreedommod.banning.Ban;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import net.pravian.aero.util.Ips;
>>>>>>> devel
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

<<<<<<< HEAD
@CommandPermissions(level = Rank.MODERATOR, source = SourceType.BOTH, blockHostConsole = true)
@CommandParameters(description = "Bans a player", usage = "/<command> <username> [reason] [-nrb]", aliases = "ban")
public class Command_gtfo extends FreedomCommand
{
    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
=======
@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH, blockHostConsole = true)
@CommandParameters(description = "Makes someone GTFO (deop and ip ban by username).", usage = "/<command> <partialname>")
public class Command_gtfo extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {

>>>>>>> devel
        if (args.length == 0)
        {
            return false;
        }

<<<<<<< HEAD
        final String username;
        final List<String> ips = new ArrayList<>();

        final Player player = getPlayer(args[0]);
        if (player == null)
        {
            final PlayerData entry = plugin.pl.getData(args[0]);

            if (entry == null)
            {
                msg("Can't find that user. If target is not logged in, make sure that you spelled the name exactly.");
                return true;
            }

            username = entry.getUsername();
            ips.addAll(entry.getIps());
        }
        else
        {
            final PlayerData entry = plugin.pl.getData(player);
            username = player.getName();
            ips.addAll(entry.getIps());

            // Deop
            player.setOp(false);

            // Gamemode survival
            player.setGameMode(GameMode.SURVIVAL);

            // Clear inventory
            player.getInventory().clear();

            // Strike with lightning
            final Location targetPos = player.getLocation();
            for (int x = -1; x <= 1; x++)
            {
                for (int z = -1; z <= 1; z++)
                {
                    final Location strike_pos = new Location(targetPos.getWorld(), targetPos.getBlockX() + x, targetPos.getBlockY(), targetPos.getBlockZ() + z);
                    targetPos.getWorld().strikeLightning(strike_pos);
                }
            }

            // Kill player
            player.setHealth(0.0);
        }

        String reason = null;
        Boolean cancelRollback = false;
        if (args.length >= 2)
        {
            if (args[args.length - 1].equalsIgnoreCase("-nrb"))
            {
                cancelRollback = true;
                if (args.length >= 3)
                {
                    reason = StringUtils.join(ArrayUtils.subarray(args, 1, args.length - 1), " ");
                }
            }
            else
            {
                reason = StringUtils.join(ArrayUtils.subarray(args, 1, args.length), " ");
            }
        }

        // Checks if CoreProtect is loaded and installed, and skips the rollback and uses CoreProtect directly
        if (!cancelRollback)
        {
            if (!plugin.cpb.isEnabled())
            {
                // Undo WorldEdits
                try
                {
                    plugin.web.undo(player, 15);
                }
                catch (NoClassDefFoundError | NullPointerException ex)
                {
                }

                // Rollback
                plugin.rb.rollback(username);
            }
            else
            {
                plugin.cpb.rollback(username);
            }
        }

        if (player != null)
        {
            FUtil.bcastMsg(player.getName() + " has been a VERY naughty, naughty boy.", ChatColor.RED);
        }

        // Ban player
        Ban ban = Ban.forPlayerName(username, sender, null, reason);
        for (String ip : ips)
        {
            ban.addIp(ip);
        }
        plugin.bm.addBan(ban);

        // Broadcast
        String ip = FUtil.getFuzzyIp(player.getAddress().getAddress().getHostAddress());
        final StringBuilder bcast = new StringBuilder()
                .append(ChatColor.RED)
                .append("Banning: ")
                .append(username)
                .append(", IPs: ")
                .append(ip);

        FUtil.bcastMsg(bcast.toString());
        final StringBuilder adminNotice = new StringBuilder()
                .append(ChatColor.DARK_AQUA)
                .append("[STAFF] ")
                .append(ChatColor.WHITE)
                .append(sender.getName())
                .append(" has banned ")
                .append(username)
                .append(" for ")
                .append(reason);
        plugin.al.messageAllAdmins(adminNotice.toString());

        // Kick player
        if (player != null)
        {
            player.kickPlayer(ban.bakeKickMessage());
        }

        // Log ban
        plugin.pul.logPunishment(new Punishment(username, ips.get(0), sender.getName(), PunishmentType.BAN, reason));

        return true;
    }
}
=======
        final Player player = getPlayer(args[0]);

        if (player == null)
        {
            msg(FreedomCommand.PLAYER_NOT_FOUND, ChatColor.RED);
            return true;
        }

        String reason = null;
        if (args.length >= 2)
        {
            reason = StringUtils.join(ArrayUtils.subarray(args, 1, args.length), " ");
        }

        FUtil.bcastMsg(player.getName() + " has been a VERY naughty, naughty boy.", ChatColor.RED);

        // Undo WorldEdits
        try
        {
            plugin.web.undo(player, 15);
        }
        catch (NoClassDefFoundError ex)
        {
        }

        // Rollback
        plugin.rb.rollback(player.getName());

        // Deop
        player.setOp(false);

        // Gamemode suvival
        player.setGameMode(GameMode.SURVIVAL);

        // Clear inventory
        player.getInventory().clear();

        // Strike with lightning
        final Location targetPos = player.getLocation();
        for (int x = -1; x <= 1; x++)
        {
            for (int z = -1; z <= 1; z++)
            {
                final Location strike_pos = new Location(targetPos.getWorld(), targetPos.getBlockX() + x, targetPos.getBlockY(), targetPos.getBlockZ() + z);
                targetPos.getWorld().strikeLightning(strike_pos);
            }
        }

        String ip = FUtil.getFuzzyIp(Ips.getIp(player));

        // Broadcast
        final StringBuilder bcast = new StringBuilder()
                .append(ChatColor.RED)
                .append("Banning: ")
                .append(player.getName())
                .append(", IP: ")
                .append(ip);
        if (reason != null)
        {
            bcast.append(" - Reason: ").append(ChatColor.YELLOW).append(reason);
        }
        FUtil.bcastMsg(bcast.toString());

        // Ban player
        plugin.bm.addBan(Ban.forPlayerFuzzy(player, sender, null, reason));

        // Kick player
        player.kickPlayer(ChatColor.RED + "GTFO");

        return true;
    }
}
>>>>>>> devel
