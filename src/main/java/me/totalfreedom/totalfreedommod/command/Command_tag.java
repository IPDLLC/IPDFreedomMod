package me.totalfreedom.totalfreedommod.command;

import java.util.Arrays;
import java.util.List;
<<<<<<< HEAD
import me.totalfreedom.totalfreedommod.admin.Admin;
import me.totalfreedom.totalfreedommod.masterbuilder.MasterBuilder;
import me.totalfreedom.totalfreedommod.player.FPlayer;
import me.totalfreedom.totalfreedommod.playerverification.VPlayer;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.apache.commons.lang3.ArrayUtils;
=======
import me.totalfreedom.totalfreedommod.player.FPlayer;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
>>>>>>> devel
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.OP, source = SourceType.BOTH)
<<<<<<< HEAD
@CommandParameters(description = "Sets yourself a prefix", usage = "/<command> [-s[ave]] <set <tag..> | list | off | clear <player> | clearall>")
public class Command_tag extends FreedomCommand
{
    public static final List<String> FORBIDDEN_WORDS = Arrays.asList(
            "admin", "owner", "moderator", "developer", "console", "dev", "staff", "mod", "sra", "tca", "sta", "sa");

    public boolean save = false;
=======
@CommandParameters(description = "Sets yourself a prefix", usage = "/<command> <set <tag..> | off | clear <player> | clearall>")
public class Command_tag extends FreedomCommand
{

    public static final List<String> FORBIDDEN_WORDS = Arrays.asList(new String[]
    {
        "admin", "owner", "moderator", "developer", "console"
    });
>>>>>>> devel

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
<<<<<<< HEAD
        if (args.length < 1)
        {
            return false;
        }

        if (args[0].equals("-s") || args[0].equals("-save"))
        {
            if (!plugin.al.isAdmin(playerSender) && !plugin.mbl.isMasterBuilder(playerSender) && !plugin.pv.getVerificationPlayer(playerSender).getEnabled())
            {
                msg("Only admins, Master Builders, and players with verification enabled can save their tags.", ChatColor.RED);
                return true;
            }
            save = true;
            args = ArrayUtils.remove(args, 0);
        }

=======
>>>>>>> devel
        if (args.length == 1)
        {
            if ("list".equalsIgnoreCase(args[0]))
            {
                msg("Tags for all online players:");

                for (final Player player : server.getOnlinePlayers())
                {
                    final FPlayer playerdata = plugin.pl.getPlayer(player);
                    if (playerdata.getTag() != null)
                    {
                        msg(player.getName() + ": " + playerdata.getTag());
                    }
                }

                return true;
            }
<<<<<<< HEAD

=======
>>>>>>> devel
            else if ("clearall".equalsIgnoreCase(args[0]))
            {
                if (!plugin.al.isAdmin(sender))
                {
                    noPerms();
                    return true;
                }

                FUtil.adminAction(sender.getName(), "Removing all tags", false);

                int count = 0;
                for (final Player player : server.getOnlinePlayers())
                {
                    final FPlayer playerdata = plugin.pl.getPlayer(player);
                    if (playerdata.getTag() != null)
                    {
                        count++;
                        playerdata.setTag(null);
                    }
                }

                msg(count + " tag(s) removed.");

                return true;
            }
            else if ("off".equalsIgnoreCase(args[0]))
            {
                if (senderIsConsole)
                {
                    msg("\"/tag off\" can't be used from the console. Use \"/tag clear <player>\" or \"/tag clearall\" instead.");
                }
                else
                {
                    plugin.pl.getPlayer(playerSender).setTag(null);
<<<<<<< HEAD
                    if (save)
                    {
                        save(playerSender, null);
                    }
                    msg("Your tag has been removed." + (save ? " (Saved)" : ""));
                }
=======
                    msg("Your tag has been removed.");
                }

>>>>>>> devel
                return true;
            }
            else
            {
                return false;
            }
        }
        else if (args.length >= 2)
        {
            if ("clear".equalsIgnoreCase(args[0]))
            {
                if (!plugin.al.isAdmin(sender))
                {
                    noPerms();
                    return true;
                }

                final Player player = getPlayer(args[1]);

                if (player == null)
                {
                    msg(FreedomCommand.PLAYER_NOT_FOUND);
                    return true;
                }

                plugin.pl.getPlayer(player).setTag(null);
<<<<<<< HEAD

                if (save)
                {
                    save(player, null);
                }
                msg("Removed " + player.getName() + "'s tag." + (save ? " (Saved)" : ""));
=======
                msg("Removed " + player.getName() + "'s tag.");
>>>>>>> devel

                return true;
            }
            else if ("set".equalsIgnoreCase(args[0]))
            {
                final String inputTag = StringUtils.join(args, " ", 1, args.length);
<<<<<<< HEAD
                final String strippedTag = StringUtils.replaceEachRepeatedly(StringUtils.strip(inputTag),
                        new String[]
                                {
                                        "" + ChatColor.COLOR_CHAR, "&k"
                                },
                        new String[]
                                {
                                        "", ""
                                });
                final String outputTag = FUtil.colorize(strippedTag);

                int tagLimit = (plugin.al.isAdmin(sender) ? 30 : 20);

                final String rawTag = ChatColor.stripColor(strippedTag).toLowerCase();

                if (rawTag.length() > tagLimit)
                {
                    msg("That tag is too long (Max is " + String.valueOf(tagLimit) + " characters).");
                    return true;
                }

                if (!plugin.al.isAdmin(sender))
                {
=======
                final String outputTag = FUtil.colorize(StringUtils.replaceEachRepeatedly(StringUtils.strip(inputTag),
                        new String[]
                        {
                            "" + ChatColor.COLOR_CHAR, "&k"
                        },
                        new String[]
                        {
                            "", ""
                        })) + ChatColor.RESET;

                if (!plugin.al.isAdmin(sender))
                {
                    final String rawTag = ChatColor.stripColor(outputTag).toLowerCase();

                    if (rawTag.length() > 20)
                    {
                        msg("That tag is too long (Max is 20 characters).");
                        return true;
                    }

>>>>>>> devel
                    for (String word : FORBIDDEN_WORDS)
                    {
                        if (rawTag.contains(word))
                        {
                            msg("That tag contains a forbidden word.");
                            return true;
                        }
                    }
                }

                plugin.pl.getPlayer(playerSender).setTag(outputTag);
<<<<<<< HEAD
                if (save)
                {
                    save(playerSender, outputTag);
                }
                msg("Tag set to '" + outputTag + ChatColor.GRAY + "'." + (save ? " (Saved)" : ""));
=======
                msg("Tag set to '" + outputTag + "'.");

>>>>>>> devel
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
<<<<<<< HEAD

    public void save(Player player, String tag)
    {
        if (plugin.al.isAdmin(player))
        {
            Admin admin = plugin.al.getAdmin(player);
            admin.setTag(tag);
            plugin.al.save();
            plugin.al.updateTables();
        }

        else if (plugin.mbl.isMasterBuilder(player))
        {
            MasterBuilder masterBuilder = plugin.mbl.getMasterBuilder(player);
            masterBuilder.setTag(tag);
            plugin.mbl.save();
            plugin.mbl.updateTables();
        }

        else if (plugin.pv.getVerificationPlayer(player).getEnabled())
        {
            VPlayer vPlayer = plugin.pv.getVerificationPlayer(player);
            vPlayer.setTag(tag);
            plugin.pv.saveVerificationData(vPlayer);
        }
    }
=======
>>>>>>> devel
}
