package me.totalfreedom.totalfreedommod.command;

import java.util.Random;
import me.totalfreedom.totalfreedommod.punishments.Punishment;
import me.totalfreedom.totalfreedommod.punishments.PunishmentType;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import net.pravian.aero.util.Ips;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
@CommandPermissions(level = Rank.SENIOR_ADMIN, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "GTA V Orbital cannon.", usage = "/<command> <playername>")
public class Command_orbital extends FreedomCommand
{
     public static void orbital(CommandSender sender, Player player)
    {
        orbital(sender, player, null);
    }

    public static void orbital(CommandSender sender, Player player, String reason)
    {
        FUtil.bcastMsg(player.getName() + " was obliterated by the Orbital Cannon.", ChatColor.RESET);


        

       
        // Clear inventory
        player.getInventory().clear();

        // Strike with lightning effect
        final Location targetPos = player.getLocation();
        final World world = player.getWorld();
        
            
                final Location strike_pos = new Location(world, targetPos.getBlockX(), targetPos.getBlockY(), targetPos.getBlockZ());
                world.strikeLightning(strike_pos);
                for(int i =1;i < 5;i++)
                {
                    final Location boom_pos = new Location(world, targetPos.getBlockX() + new Random().nextInt(i), targetPos.getBlockY() + new Random().nextInt(i), targetPos.getBlockZ() - new Random().nextInt(i));
                    world.createExplosion(boom_pos, 0.0F);
                    world.spawnParticle(Particle.EXPLOSION_HUGE, boom_pos, i);
                }
            

        // Kill
        player.setHealth(0.0);
        
        
    }

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length < 1)
        {
            return false;
        }

        final Player player = getPlayer(args[0]);

        String reason = null;
        if (args.length > 1)
        {
            reason = StringUtils.join(args, " ", 1, args.length);
        }

        if (player == null)
        {
            msg(FreedomCommand.PLAYER_NOT_FOUND);
            return true;
        }

        orbital(sender, player, reason);

        
        return true;
    }
}
