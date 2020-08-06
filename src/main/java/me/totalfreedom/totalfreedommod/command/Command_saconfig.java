package me.totalfreedom.totalfreedommod.command;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import me.totalfreedom.totalfreedommod.admin.Admin;
import me.totalfreedom.totalfreedommod.config.ConfigEntry;
import me.totalfreedom.totalfreedommod.masterbuilder.MasterBuilder;
import me.totalfreedom.totalfreedommod.player.FPlayer;
import me.totalfreedom.totalfreedommod.playerverification.VPlayer;
=======
import java.util.Date;
import me.totalfreedom.totalfreedommod.admin.Admin;
import me.totalfreedom.totalfreedommod.player.FPlayer;
>>>>>>> devel
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import net.pravian.aero.util.Ips;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.OP, source = SourceType.BOTH)
<<<<<<< HEAD
@CommandParameters(description = "Manage admins.", usage = "/<command> <list | clean | reload | setrank <username> <rank> | <add | remove | info> <username>>")
public class Command_saconfig extends FreedomCommand
{
=======
@CommandParameters(description = "Manage admins.", usage = "/<command> <list | clean | reload | | setrank <username> <rank> | <add | remove | info> <username>>")
public class Command_saconfig extends FreedomCommand
{

>>>>>>> devel
    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length < 1)
        {
            return false;
        }

        switch (args[0])
        {
            case "list":
            {
<<<<<<< HEAD
                msg("Admins: " + StringUtils.join(plugin.al.getAdminNames(), ", "), ChatColor.GOLD);
=======
                msg("Superadmins: " + StringUtils.join(plugin.al.getAdminNames(), ", "), ChatColor.GOLD);

>>>>>>> devel
                return true;
            }

            case "clean":
            {
<<<<<<< HEAD
=======
                checkConsole();
>>>>>>> devel
                checkRank(Rank.TELNET_ADMIN);

                FUtil.adminAction(sender.getName(), "Cleaning admin list", true);
                plugin.al.deactivateOldEntries(true);
<<<<<<< HEAD
                msg("Admins: " + StringUtils.join(plugin.al.getAdminNames(), ", "), ChatColor.GOLD);
=======
                msg("Superadmins: " + StringUtils.join(plugin.al.getAdminNames(), ", "), ChatColor.GOLD);
>>>>>>> devel

                return true;
            }

            case "reload":
            {
                checkRank(Rank.SUPER_ADMIN);

                FUtil.adminAction(sender.getName(), "Reloading the admin list", true);
                plugin.al.load();
                msg("Admin list reloaded!");
                return true;
            }

            case "setrank":
            {
<<<<<<< HEAD
                checkNotHostConsole();
                checkRank(Rank.SENIOR_CONSOLE);
                
                
=======
                checkConsole();
                checkNotHostConsole();
                checkRank(Rank.SENIOR_CONSOLE);
>>>>>>> devel

                if (args.length < 3)
                {
                    return false;
                }

                Rank rank = Rank.findRank(args[2]);
                if (rank == null)
                {
                    msg("Unknown rank: " + rank);
                    return true;
                }

                if (rank.isConsole())
                {
                    msg("You cannot set players to a console rank");
                    return true;
                }

<<<<<<< HEAD
                if (!rank.isAtLeast(Rank.MODERATOR))
                {
                    msg("Rank must be Moderator or higher.", ChatColor.RED);
=======
                if (!rank.isAtLeast(Rank.SUPER_ADMIN))
                {
                    msg("Rank must be superadmin or higher.", ChatColor.RED);
>>>>>>> devel
                    return true;
                }

                Admin admin = plugin.al.getEntryByName(args[1]);
                if (admin == null)
                {
                    msg("Unknown admin: " + args[1]);
                    return true;
                }

                FUtil.adminAction(sender.getName(), "Setting " + admin.getName() + "'s rank to " + rank.getName(), true);

                admin.setRank(rank);
                plugin.al.save();

<<<<<<< HEAD
                Player player = getPlayer(admin.getName());
                if (player != null)
                {
                    plugin.rm.updateDisplay(player);
                }

                if (plugin.dc.enabled && ConfigEntry.DISCORD_ROLE_SYNC.getBoolean())
                {
                    plugin.dc.syncRoles(admin);
                }

=======
>>>>>>> devel
                msg("Set " + admin.getName() + "'s rank to " + rank.getName());
                return true;
            }

            case "info":
            {
                if (args.length < 2)
                {
                    return false;
                }

                checkRank(Rank.SUPER_ADMIN);

                Admin admin = plugin.al.getEntryByName(args[1]);

                if (admin == null)
                {
                    final Player player = getPlayer(args[1]);
                    if (player != null)
                    {
                        admin = plugin.al.getAdmin(player);
                    }
                }

                if (admin == null)
                {
<<<<<<< HEAD
                    msg("Admin not found: " + args[1]);
=======
                    msg("Superadmin not found: " + args[1]);
>>>>>>> devel
                }
                else
                {
                    msg(admin.toString());
                }

                return true;
            }

            case "add":
            {
                if (args.length < 2)
                {
                    return false;
                }

<<<<<<< HEAD
                checkRank(Rank.TELNET_CONSOLE);

                // Player already an admin?
                final Player player = getPlayer(args[1]);

                if (player == null)
                {
                    msg(FreedomCommand.PLAYER_NOT_FOUND);
                    return true;
                }

=======
                checkConsole();
                checkRank(Rank.TELNET_ADMIN);

                // Player already an admin?
                final Player player = getPlayer(args[1]);
>>>>>>> devel
                if (player != null && plugin.al.isAdmin(player))
                {
                    msg("That player is already admin.");
                    return true;
                }

                // Find the old admin entry
                String name = player != null ? player.getName() : args[1];
                Admin admin = null;
                for (Admin loopAdmin : plugin.al.getAllAdmins().values())
                {
                    if (loopAdmin.getName().equalsIgnoreCase(name))
                    {
                        admin = loopAdmin;
                        break;
                    }
                }

<<<<<<< HEAD
                if (plugin.pv.isPlayerImpostor(player))
                {
                    msg("This player was labeled as a player impostor and is not an admin, therefore they cannot be added to the admin list.", ChatColor.RED);
                    return true;
                }

                if (admin == null) // New admin
                {
                    if (plugin.mbl.isMasterBuilderImpostor(player))
                    {
                        msg("This player was labeled as a Master Builder impostor and is not an admin, therefore they cannot be added to the admin list.", ChatColor.RED);
                        return true;
                    }
=======
                if (admin == null) // New admin
                {
>>>>>>> devel
                    if (player == null)
                    {
                        msg(FreedomCommand.PLAYER_NOT_FOUND);
                        return true;
                    }

                    FUtil.adminAction(sender.getName(), "Adding " + player.getName() + " to the admin list", true);
                    plugin.al.addAdmin(new Admin(player));
<<<<<<< HEAD
                    admin = new Admin(player);
                    if (player != null)
                    {
                        plugin.rm.updateDisplay(player);
                    }
                    // Attempt to find Discord account
                    if (plugin.mbl.isMasterBuilder(player))
                    {
                        MasterBuilder masterBuilder = plugin.mbl.getMasterBuilder(player);
                        admin.setDiscordID(masterBuilder.getDiscordID());
                    }
                    else if (plugin.pv.getVerificationPlayer(admin.getName()) != null)
                    {
                        VPlayer vPlayer = plugin.pv.getVerificationPlayer(admin.getName());
                        if (vPlayer.getDiscordId() != null)
                        {
                            admin.setDiscordID(vPlayer.getDiscordId());
                        }
                    }
                }
                else // Existing admin
                {
                    FUtil.adminAction(sender.getName(), "Re-adding " + admin.getName() + " to the admin list", true);
=======
                }
                else // Existing admin
                {
                    FUtil.adminAction(sender.getName(), "Readding " + admin.getName() + " to the admin list", true);
>>>>>>> devel

                    if (player != null)
                    {
                        admin.setName(player.getName());
                        admin.addIp(Ips.getIp(player));
                    }

<<<<<<< HEAD
                    // Handle master builders
                    if (!plugin.mbl.isMasterBuilder(player))
                    {
                        MasterBuilder masterBuilder = null;
                        for (MasterBuilder loopMasterBuilder : plugin.mbl.getAllMasterBuilders().values())
                        {
                            if (loopMasterBuilder.getName().equalsIgnoreCase(name))
                            {
                                masterBuilder = loopMasterBuilder;
                                break;
                            }
                        }

                        if (masterBuilder != null)
                        {
                            if (player != null)
                            {
                                masterBuilder.setName(player.getName());
                                masterBuilder.addIp(Ips.getIp(player));
                            }

                            masterBuilder.setLastLogin(new Date());

                            plugin.mbl.save();
                            plugin.mbl.updateTables();
                        }
                    }

                    admin.setActive(true);
                    admin.setLastLogin(new Date());

                    // Attempt to find Discord account
                    if (plugin.mbl.isMasterBuilder(player))
                    {
                        MasterBuilder masterBuilder = plugin.mbl.getMasterBuilder(player);
                        admin.setDiscordID(masterBuilder.getDiscordID());
                    }
                    else if (plugin.pv.getVerificationPlayer(admin.getName()) != null)
                    {
                        VPlayer vPlayer = plugin.pv.getVerificationPlayer(admin.getName());
                        if (vPlayer.getDiscordId() != null)
                        {
                            admin.setDiscordID(vPlayer.getDiscordId());
                        }
                    }

                    plugin.al.save();
                    plugin.al.updateTables();
                    if (player != null)
                    {
                        plugin.rm.updateDisplay(player);
                    }

                    if (plugin.dc.enabled && ConfigEntry.DISCORD_ROLE_SYNC.getBoolean())
                    {
                        plugin.dc.syncRoles(admin);
                    }
=======
                    admin.setActive(true);
                    admin.setLastLogin(new Date());

                    plugin.al.save();
                    plugin.al.updateTables();
>>>>>>> devel
                }

                if (player != null)
                {
                    final FPlayer fPlayer = plugin.pl.getPlayer(player);
                    if (fPlayer.getFreezeData().isFrozen())
                    {
                        fPlayer.getFreezeData().setFrozen(false);
                        msg(player.getPlayer(), "You have been unfrozen.");
                    }
<<<<<<< HEAD

                    if (!player.isOp())
                    {
                        player.setOp(true);
                        player.sendMessage(YOU_ARE_OP);
                    }
                    plugin.pv.removeEntry(player.getName()); // Admins can't have player verification entries
=======
>>>>>>> devel
                }

                return true;
            }

            case "remove":
            {
                if (args.length < 2)
                {
                    return false;
                }

<<<<<<< HEAD
                checkRank(Rank.TELNET_CLAN_CONSOLE);
=======
                checkConsole();
                checkRank(Rank.TELNET_ADMIN);
>>>>>>> devel

                Player player = getPlayer(args[1]);
                Admin admin = player != null ? plugin.al.getAdmin(player) : plugin.al.getEntryByName(args[1]);

                if (admin == null)
                {
<<<<<<< HEAD
                    msg("Admin not found: " + args[1]);
=======
                    msg("Superadmin not found: " + args[1]);
>>>>>>> devel
                    return true;
                }

                FUtil.adminAction(sender.getName(), "Removing " + admin.getName() + " from the admin list", true);
                admin.setActive(false);
                plugin.al.save();
                plugin.al.updateTables();
<<<<<<< HEAD
                if (player != null)
                {
                    plugin.rm.updateDisplay(player);
                }

                if (plugin.dc.enabled && ConfigEntry.DISCORD_ROLE_SYNC.getBoolean())
                {
                    plugin.dc.syncRoles(admin);
                }

=======
>>>>>>> devel
                return true;
            }

            default:
            {
                return false;
            }
        }
    }

<<<<<<< HEAD
    @Override
    public List<String> getTabCompleteOptions(CommandSender sender, Command command, String alias, String[] args)
    {
        if (sender instanceof Player)
        {
            if (args.length == 1)
            {
                List<String> arguments = new ArrayList<>();
                arguments.add("list");
                if (plugin.al.isAdmin(sender))
                {
                    arguments.add("info");
                }
                return arguments;
            }
            else if (args.length == 2 && args[0].equals("info") && plugin.al.isAdmin(sender))
            {
                return plugin.al.getActiveAdminNames();
            }
            return Collections.emptyList();
        }
        else
        {
            if (args.length == 1)
            {
                return Arrays.asList("add", "remove", "clean", "reload", "setrank", "info", "list");
            }
            else if (args.length == 2)
            {
                if (args[0].equals("add") || args[0].equals("remove") || args[0].equals("setrank") || args[0].equals("info"))
                {
                    return FUtil.getPlayerList();
                }
            }
            else if (args.length == 3 && args[0].equals("setrank"))
            {
                return Arrays.asList("moderator", "super_admin", "telnet_admin","telnet_clan_admin", "senior_admin", "system_admin");
            }
        }

        return Collections.emptyList();
    }

    private void checkRank(Rank rank, Rank rank0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void checkRank(Rank rank, Rank rank0, Rank rank1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
=======
>>>>>>> devel
}
