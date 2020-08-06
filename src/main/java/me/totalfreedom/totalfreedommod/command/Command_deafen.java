package me.totalfreedom.totalfreedommod.command;

import java.util.Random;
import me.totalfreedom.totalfreedommod.rank.Rank;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@CommandPermissions(level = Rank.SENIOR_ADMIN, source = SourceType.BOTH, blockHostConsole = true)
@CommandParameters(description = "Make some noise.", usage = "/<command>")
public class Command_deafen extends FreedomCommand
{
<<<<<<< HEAD
    private static final double STEPS = 10.0;
    private static final Random random = new Random();

    private static Location randomOffset(Location a, double magnitude)
    {
        return a.clone().add(randomDoubleRange(-1.0, 1.0) * magnitude, randomDoubleRange(-1.0, 1.0) * magnitude, randomDoubleRange(-1.0, 1.0) * magnitude);
    }

    private static Double randomDoubleRange(double min, double max)
    {
        return min + (random.nextDouble() * ((max - min) + 1.0));
    }
=======

    private static final Random random = new Random();
    public static final double STEPS = 10.0;
>>>>>>> devel

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        for (final Player player : server.getOnlinePlayers())
        {
            for (double percent = 0.0; percent <= 1.0; percent += (1.0 / STEPS))
            {
<<<<<<< HEAD
                final float pitch = (float)(percent * 2.0);
=======
                final float pitch = (float) (percent * 2.0);
>>>>>>> devel

                new BukkitRunnable()
                {
                    @Override
                    public void run()
                    {
                        player.playSound(randomOffset(player.getLocation(), 5.0), Sound.values()[random.nextInt(Sound.values().length)], 100.0f, pitch);
                    }
                }.runTaskLater(plugin, Math.round(20.0 * percent * 2.0));
            }
        }

        return true;
    }
<<<<<<< HEAD
=======

    private static Location randomOffset(Location a, double magnitude)
    {
        return a.clone().add(randomDoubleRange(-1.0, 1.0) * magnitude, randomDoubleRange(-1.0, 1.0) * magnitude, randomDoubleRange(-1.0, 1.0) * magnitude);
    }

    private static Double randomDoubleRange(double min, double max)
    {
        return min + (random.nextDouble() * ((max - min) + 1.0));
    }
>>>>>>> devel
}
