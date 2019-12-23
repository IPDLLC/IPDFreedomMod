package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.admin.Admin;
import me.totalfreedom.totalfreedommod.banning.Ban;
import me.totalfreedom.totalfreedommod.config.ConfigEntry;
import me.totalfreedom.totalfreedommod.punishments.Punishment;
import me.totalfreedom.totalfreedommod.punishments.PunishmentType;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import static net.coreprotect.model.Config.username;
import net.pravian.aero.util.Ips;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

@CommandPermissions(level = Rank.SYSTEM_ADMIN, source = SourceType.BOTH, blockHostConsole = true)
@CommandParameters(description = "admin boutta be fucked in the ass.", usage = "/<command> <playername>")
public class Command_obliterate extends FreedomCommand
{
    @Override
    public boolean run(final CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length != 1)
        {
            return false;
        }

        final Player player = getPlayer(args[0]);

        if (player == null)
        {
            sender.sendMessage(FreedomCommand.PLAYER_NOT_FOUND);
            return true;
        }

        FUtil.adminAction(sender.getName(), "Orbital Cannoning " + player.getName(), true);

        final String ip = player.getAddress().getAddress().getHostAddress().trim();

        // Remove from admin
        Admin admin = getAdmin(player);
        if (admin != null)
        {
            FUtil.adminAction(sender.getName(), "Removing " + player.getName() + " from the admin list", true);
            admin.setActive(false);
            plugin.al.save();
            plugin.al.updateTables();
            if (plugin.dc.enabled && ConfigEntry.DISCORD_ROLE_SYNC.getBoolean())
            {
                plugin.dc.syncRoles(admin);
            }
        }

        // yee yee juice
        player.setWhitelisted(false);
        

        // Deop
        player.setOp(false);
        
        // Ban player
        Ban ban = Ban.forPlayer(player, sender);
        ban.setReason("&cDid that feel nice?");
        for (String playerIp : plugin.pl.getData(player).getIps())
        {
            ban.addIp(playerIp);
        }
        plugin.bm.addBan(ban);
        // Set gamemode to survival
        player.setGameMode(GameMode.SURVIVAL);

        // Clear inventory
        player.closeInventory();
        player.getInventory().clear();

        // Ignite player
        player.setFireTicks(10000);

        // Generate explosion
        player.getWorld().createExplosion(player.getLocation(), 0F, false);
        player.getWorld().createExplosion(player.getLocation(), 0F, false);
        player.getWorld().createExplosion(player.getLocation(), 0F, false);
        player.getWorld().createExplosion(player.getLocation(), 0F, false);
        player.getWorld().createExplosion(player.getLocation(), 0F, false);
        player.getWorld().createExplosion(player.getLocation(), 0F, false);
        player.getWorld().createExplosion(player.getLocation(), 0F, false);
        

        // Log doom
        plugin.pul.logPunishment(new Punishment(player.getName(), Ips.getIp(player), sender.getName(), PunishmentType.OBLITERATION, null));

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                // strike lightning
                player.getWorld().strikeLightningEffect(player.getLocation());

                // kill (if not done already)
                player.setHealth(0.0);
            }
        }.runTaskLater(plugin, 2L * 20L);

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                // message
                FUtil.bcastMsg(player.getName() + " was obliterated by the Orbital Cannon", ChatColor.WHITE);
                FUtil.adminAction(sender.getName(), "Banning " + player.getName() + ", IP: " + ip, true);
                FUtil.bcastMsg("Ah, that feels better.", ChatColor.AQUA);
                
        
        final StringBuilder adminNotice = new StringBuilder()
                .append(ChatColor.DARK_AQUA)
                .append("[STAFF] ")
                .append(ChatColor.WHITE)
                .append(sender.getName())
                .append(" Orbital Cannoned ")
                .append(player.getName());
        plugin.al.messageAllAdmins(adminNotice.toString());

                // generate explosion
                player.getWorld().createExplosion(player.getLocation(), 0F, false);

                // kick player
                player.kickPlayer(ChatColor.RED + "git gud");
            }
        }.runTaskLater(plugin, 3L * 20L);

        return true;
    }
}
