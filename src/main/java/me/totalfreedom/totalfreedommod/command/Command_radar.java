package me.totalfreedom.totalfreedommod.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import me.totalfreedom.totalfreedommod.rank.Rank;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.NON_OP, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Shows nearby people sorted by distance.", usage = "/<command> [range]")
public class Command_radar extends FreedomCommand
{
<<<<<<< HEAD
=======

>>>>>>> devel
    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Location playerSenderos = playerSender.getLocation();

<<<<<<< HEAD
        List<RadarData> radar_data = new ArrayList<>();
=======
        List<TFM_RadarData> radar_data = new ArrayList<>();
>>>>>>> devel

        for (Player player : playerSenderos.getWorld().getPlayers())
        {
            if (!player.equals(playerSender))
            {
                try
                {
<<<<<<< HEAD
                    radar_data.add(new RadarData(player, playerSenderos.distance(player.getLocation()), player.getLocation()));
=======
                    radar_data.add(new TFM_RadarData(player, playerSenderos.distance(player.getLocation()), player.getLocation()));
>>>>>>> devel
                }
                catch (IllegalArgumentException ex)
                {
                }
            }
        }

        if (radar_data.isEmpty())
        {
            msg("You are the only player in this world. (" + ChatColor.GREEN + "Forever alone..." + ChatColor.YELLOW + ")", ChatColor.YELLOW); //lol
            return true;
        }

<<<<<<< HEAD
        Collections.sort(radar_data, new RadarData());
=======
        Collections.sort(radar_data, new TFM_RadarData());
>>>>>>> devel

        msg("People nearby in " + playerSenderos.getWorld().getName() + ":", ChatColor.YELLOW);

        int countmax = 5;
        if (args.length == 1)
        {
            try
            {
                countmax = Math.max(1, Math.min(64, Integer.parseInt(args[0])));
            }
            catch (NumberFormatException nfex)
            {
            }
        }

<<<<<<< HEAD
        for (RadarData i : radar_data)
=======
        for (TFM_RadarData i : radar_data)
>>>>>>> devel
        {
            msg(String.format("%s - %d",
                    i.player.getName(),
                    Math.round(i.distance)), ChatColor.YELLOW);

            if (--countmax <= 0)
            {
                break;
            }
        }

        return true;
    }

<<<<<<< HEAD
    private class RadarData implements Comparator<RadarData>
=======
    private class TFM_RadarData implements Comparator<TFM_RadarData>
>>>>>>> devel
    {

        public Player player;
        public double distance;
        public Location location;

<<<<<<< HEAD
        public RadarData(Player player, double distance, Location location)
=======
        public TFM_RadarData(Player player, double distance, Location location)
>>>>>>> devel
        {
            this.player = player;
            this.distance = distance;
            this.location = location;
        }

<<<<<<< HEAD
        public RadarData()
=======
        public TFM_RadarData()
>>>>>>> devel
        {
        }

        @Override
<<<<<<< HEAD
        public int compare(RadarData t1, RadarData t2)
=======
        public int compare(TFM_RadarData t1, TFM_RadarData t2)
>>>>>>> devel
        {
            if (t1.distance > t2.distance)
            {
                return 1;
            }
            else if (t1.distance < t2.distance)
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
    }
<<<<<<< HEAD
}
=======

}
>>>>>>> devel
