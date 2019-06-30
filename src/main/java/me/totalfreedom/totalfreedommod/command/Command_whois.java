package me.totalfreedom.totalfreedommod.command;

import java.math.RoundingMode;
import java.text.NumberFormat;
import me.totalfreedom.totalfreedommod.player.FPlayer;
import me.totalfreedom.totalfreedommod.rank.Rank;
import net.pravian.aero.util.Ips;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.OP, source = SourceType.BOTH)
@CommandParameters(description = "See details of a player", usage = "/<command> <player>")
public class Command_whois extends FreedomCommand
{
    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length < 1)
        {
            return false;
        }

        Player player = Bukkit.getPlayer(args[0]);

        if (player == null)
        {
            msg(FreedomCommand.PLAYER_NOT_FOUND);
            return true;
        }

        FPlayer fPlayer = plugin.pl.getPlayer(player);

        NumberFormat format = NumberFormat.getInstance();
        format.setRoundingMode(RoundingMode.DOWN);
        format.setMaximumFractionDigits(1);
        String formattedHealth = format.format(player.getHealth()) + "/" + format.format(player.getMaxHealth());

        msg("--- WhoIs: " + player.getName() + " ---");
        if (plugin.esb.getNickname(player.getName()) != null)
        {
            msg(" - Nickname: " + plugin.esb.getNickname(player.getName()));
        }
        msg(" - Health: " + formattedHealth);
        String location = player.getWorld().getName() + ", " +
                player.getLocation().getBlockX() + ", " +
                player.getLocation().getBlockY() + ", " +
                player.getLocation().getBlockZ();
        msg(" - Location: " + location);
        if (plugin.al.isAdmin(sender))
        {
            msg(" - IP Address: " + Ips.getIp(player));
        }
        msg(" - Playtime: " + plugin.esb.getPlaytime(player.getName()));
        msg(" - AFK: " + (plugin.esb.isAFK(player.getName()) ? "true, for " + plugin.esb.getAFKDuration(player.getName()) : "false"));
        msg(" - Gamemode: " + player.getGameMode().toString().toLowerCase());
        msg(" - Flying: " + player.isFlying());
        msg(" - God mode: " + plugin.esb.getGodMode(player.getName()));
        msg(" - Muted: " + fPlayer.isMuted());
        msg(" - Caged: " + fPlayer.getCageData().isCaged());
        return true;
    }
}