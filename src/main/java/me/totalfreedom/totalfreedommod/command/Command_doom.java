package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.admin.Admin;
import me.totalfreedom.totalfreedommod.banning.Ban;
<<<<<<< HEAD
import me.totalfreedom.totalfreedommod.config.ConfigEntry;
import me.totalfreedom.totalfreedommod.punishments.Punishment;
import me.totalfreedom.totalfreedommod.punishments.PunishmentType;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import net.pravian.aero.util.Ips;
=======
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
>>>>>>> devel
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

<<<<<<< HEAD
@CommandPermissions(level = Rank.TELNET_CLAN_ADMIN, source = SourceType.BOTH, blockHostConsole = true)
@CommandParameters(description = "For the bad admins", usage = "/<command> <playername>")
public class Command_doom extends FreedomCommand
{
=======
@CommandPermissions(level = Rank.SENIOR_ADMIN, source = SourceType.ONLY_CONSOLE, blockHostConsole = true)
@CommandParameters(description = "For the bad admins", usage = "/<command> <playername>")
public class Command_doom extends FreedomCommand
{

>>>>>>> devel
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

        FUtil.adminAction(sender.getName(), "Casting oblivion over " + player.getName(), true);
        FUtil.bcastMsg(player.getName() + " will be completely obliviated!", ChatColor.RED);

        final String ip = player.getAddress().getAddress().getHostAddress().trim();

<<<<<<< HEAD
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
=======
        // Remove from superadmin
        Admin admin = getAdmin(player);
        if (admin != null)
        {
            FUtil.adminAction(sender.getName(), "Removing " + player.getName() + " from the superadmin list", true);
            plugin.al.removeAdmin(admin);
>>>>>>> devel
        }

        // Remove from whitelist
        player.setWhitelisted(false);

        // Deop
        player.setOp(false);
<<<<<<< HEAD
        
        // Ban player
        Ban ban = Ban.forPlayer(player, sender);
        ban.setReason("&cWhat an idiot you are, fuck you.");
=======

        // Ban player
        Ban ban = Ban.forPlayer(player, sender);
        ban.setReason("&cFUCKOFF");
>>>>>>> devel
        for (String playerIp : plugin.pl.getData(player).getIps())
        {
            ban.addIp(playerIp);
        }
        plugin.bm.addBan(ban);
<<<<<<< HEAD
=======

>>>>>>> devel
        // Set gamemode to survival
        player.setGameMode(GameMode.SURVIVAL);

        // Clear inventory
        player.closeInventory();
        player.getInventory().clear();

        // Ignite player
        player.setFireTicks(10000);

        // Generate explosion
        player.getWorld().createExplosion(player.getLocation(), 0F, false);

        // Shoot the player in the sky
        player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));

<<<<<<< HEAD
        // Log doom
        plugin.pul.logPunishment(new Punishment(player.getName(), Ips.getIp(player), sender.getName(), PunishmentType.DOOM, null));

=======
>>>>>>> devel
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                // strike lightning
<<<<<<< HEAD
                player.getWorld().strikeLightningEffect(player.getLocation());
=======
                player.getWorld().strikeLightning(player.getLocation());
>>>>>>> devel

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
                FUtil.adminAction(sender.getName(), "Banning " + player.getName() + ", IP: " + ip, true);
<<<<<<< HEAD
        final StringBuilder adminNotice = new StringBuilder()
                .append(ChatColor.DARK_AQUA)
                .append("[STAFF] ")
                .append(ChatColor.WHITE)
                .append(sender.getName())
                .append(" has doom'd ")
                .append(player.getName());
        plugin.al.messageAllAdmins(adminNotice.toString());
=======
>>>>>>> devel

                // generate explosion
                player.getWorld().createExplosion(player.getLocation(), 0F, false);

                // kick player
                player.kickPlayer(ChatColor.RED + "FUCKOFF, and get your shit together!");
            }
        }.runTaskLater(plugin, 3L * 20L);

        return true;
    }
}
