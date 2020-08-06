package me.totalfreedom.totalfreedommod.command;

<<<<<<< HEAD
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import me.totalfreedom.totalfreedommod.fun.Jumppads;
import me.totalfreedom.totalfreedommod.rank.Rank;
=======
import me.totalfreedom.totalfreedommod.fun.Jumppads;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
>>>>>>> devel
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH)
<<<<<<< HEAD
@CommandParameters(description = "Manage jumppads", usage = "/<command> <on | off | info | sideways <on | off>>", aliases = "launchpads,jp")
public class Command_jumppads extends FreedomCommand
{
=======
@CommandParameters(description = "Manage jumppads", usage = "/<command> <on | off | info | sideways <on | off> | strength <strength (1-10)>>", aliases = "launchpads,jp")
public class Command_jumppads extends FreedomCommand
{

>>>>>>> devel
    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 0 || args.length > 2)
        {
            return false;
        }

        if (args.length == 1)
        {
            if (args[0].equalsIgnoreCase("info"))
            {
<<<<<<< HEAD
                msg("Jumppads: " + (plugin.jp.players.get(playerSender).isOn() ? "Enabled" : "Disabled"), ChatColor.BLUE);
                msg("Sideways: " + (plugin.jp.players.get(playerSender) == Jumppads.JumpPadMode.NORMAL_AND_SIDEWAYS ? "Enabled" : "Disabled"), ChatColor.BLUE);
=======
                msg("Jumppads: " + (plugin.jp.getMode().isOn() ? "Enabled" : "Disabled"), ChatColor.BLUE);
                msg("Sideways: " + (plugin.jp.getMode() == Jumppads.JumpPadMode.NORMAL_AND_SIDEWAYS ? "Enabled" : "Disabled"), ChatColor.BLUE);
                msg("Strength: " + (plugin.jp.getStrength() * 10 - 1), ChatColor.BLUE);
>>>>>>> devel
                return true;
            }

            if ("off".equals(args[0]))
            {
<<<<<<< HEAD
                if (plugin.jp.players.get(playerSender) == Jumppads.JumpPadMode.OFF)
                {
                    msg("Your jumppads are already disabled.");
                    return true;
                }
                msg("Disabled your jumppads.", ChatColor.GRAY);
                plugin.jp.players.put(playerSender, Jumppads.JumpPadMode.OFF);
            }
            else
            {
                if (plugin.jp.players.get(playerSender) != Jumppads.JumpPadMode.OFF)
                {
                    msg("Your jumppads are already enabled.");
                    return true;
                }
                msg("Enabled your jumpppads.", ChatColor.GRAY);
                plugin.jp.players.put(playerSender, Jumppads.JumpPadMode.MADGEEK);
=======
                FUtil.adminAction(sender.getName(), "Disabling Jumppads", false);
                plugin.jp.setMode(Jumppads.JumpPadMode.OFF);
            }
            else
            {
                FUtil.adminAction(sender.getName(), "Enabling Jumppads", false);
                plugin.jp.setMode(Jumppads.JumpPadMode.MADGEEK);
>>>>>>> devel
            }
        }
        else
        {
<<<<<<< HEAD
            if (plugin.jp.players.get(playerSender) == Jumppads.JumpPadMode.OFF)
            {
                msg("Your jumppads are currently disabled, please enable them before changing jumppads settings.");
=======
            if (plugin.jp.getMode() == Jumppads.JumpPadMode.OFF)
            {
                msg("Jumppads are currently disabled, please enable them before changing jumppads settings.");
>>>>>>> devel
                return true;
            }

            if (args[0].equalsIgnoreCase("sideways"))
            {
                if ("off".equals(args[1]))
                {
<<<<<<< HEAD
                    if (plugin.jp.players.get(playerSender) == Jumppads.JumpPadMode.MADGEEK)
                    {
                        msg("Your jumppads are already set to normal mode.");
                        return true;
                    }
                    msg("Set Jumppads mode to: Normal", ChatColor.GRAY);
                    plugin.jp.players.put(playerSender, Jumppads.JumpPadMode.MADGEEK);
                }
                else
                {
                    if (plugin.jp.players.get(playerSender) == Jumppads.JumpPadMode.NORMAL_AND_SIDEWAYS)
                    {
                        msg("Your jumppads are already set to normal and sideways mode.");
                        return true;
                    }
                    msg("Set Jumppads mode to: Normal and Sideways", ChatColor.GRAY);
                    plugin.jp.players.put(playerSender, Jumppads.JumpPadMode.NORMAL_AND_SIDEWAYS);
                }
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<String> getTabCompleteOptions(CommandSender sender, Command command, String alias, String[] args)
    {
        if (!plugin.al.isAdmin(sender))
        {
            return Collections.emptyList();
        }
        if (args.length == 1)
        {
            return Arrays.asList("on", "off", "info", "sideways");
        }
        else if (args.length == 2)
        {
            if (args[0].equals("sideways"))
            {
                return Arrays.asList("on", "off");
            }
        }

        return Collections.emptyList();
=======
                    FUtil.adminAction(sender.getName(), "Setting Jumppads mode to: Madgeek", false);
                    plugin.jp.setMode(Jumppads.JumpPadMode.MADGEEK);
                }
                else
                {
                    FUtil.adminAction(sender.getName(), "Setting Jumppads mode to: Normal and Sideways", false);
                    plugin.jp.setMode(Jumppads.JumpPadMode.NORMAL_AND_SIDEWAYS);
                }
            }
            else if (args[0].equalsIgnoreCase("strength"))
            {
                final float strength;
                try
                {
                    strength = Float.parseFloat(args[1]);
                }
                catch (NumberFormatException ex)
                {
                    msg("Invalid Strength");
                    return true;
                }

                if (strength > 10 || strength < 1)
                {
                    msg("Invalid Strength: The strength may be 1 through 10.");
                    return true;
                }

                FUtil.adminAction(sender.getName(), "Setting Jumppads strength to: " + String.valueOf(strength), false);
                plugin.jp.setStrength((strength / 10) + 0.1F);
            }
            else
            {
                return false;
            }
        }

        return true;
>>>>>>> devel
    }
}
