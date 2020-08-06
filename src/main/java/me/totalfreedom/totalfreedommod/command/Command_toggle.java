package me.totalfreedom.totalfreedommod.command;

<<<<<<< HEAD
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import me.totalfreedom.totalfreedommod.GameRuleHandler;
=======
import me.totalfreedom.totalfreedommod.GameRuleHandler.GameRule;
>>>>>>> devel
import me.totalfreedom.totalfreedommod.config.ConfigEntry;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH)
@CommandParameters(description = "Toggles TotalFreedomMod settings", usage = "/<command> [option] [value] [value]")
public class Command_toggle extends FreedomCommand
{
<<<<<<< HEAD
=======

>>>>>>> devel
    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 0)
        {
            msg("Available toggles: ");
            msg("- waterplace");
            msg("- fireplace");
            msg("- lavaplace");
            msg("- fluidspread");
            msg("- lavadmg");
            msg("- firespread");
<<<<<<< HEAD
            msg("- frostwalk");
            msg("- firework");
=======
>>>>>>> devel
            msg("- prelog");
            msg("- lockdown");
            msg("- petprotect");
            msg("- entitywipe");
            msg("- nonuke [range] [count]");
            msg("- explosives [radius]");
<<<<<<< HEAD
            msg("- unsafeenchs");
            return false;
        }

        if (args[0].equalsIgnoreCase("waterplace"))
=======
            return false;
        }

        if (args[0].equals("waterplace"))
>>>>>>> devel
        {
            toggle("Water placement is", ConfigEntry.ALLOW_WATER_PLACE);
            return true;
        }
<<<<<<< HEAD
        else if (args[0].equalsIgnoreCase("frostwalk"))
        {
            toggle("Frost walker enchantment is ", ConfigEntry.ALLOW_FROSTWALKER);
            return true;
        }
        else if (args[0].equalsIgnoreCase("fireplace"))
=======

        if (args[0].equals("fireplace"))
>>>>>>> devel
        {
            toggle("Fire placement is", ConfigEntry.ALLOW_FIRE_PLACE);
            return true;
        }
<<<<<<< HEAD
        else if (args[0].equalsIgnoreCase("lavaplace"))
=======

        if (args[0].equals("lavaplace"))
>>>>>>> devel
        {
            toggle("Lava placement is", ConfigEntry.ALLOW_LAVA_PLACE);
            return true;
        }
<<<<<<< HEAD
        else if (args[0].equalsIgnoreCase("fluidspread"))
=======

        if (args[0].equals("fluidspread"))
>>>>>>> devel
        {
            toggle("Fluid spread is", ConfigEntry.ALLOW_FLUID_SPREAD);
            return true;
        }
<<<<<<< HEAD
        else if (args[0].equalsIgnoreCase("lavadmg"))
=======

        if (args[0].equals("lavadmg"))
>>>>>>> devel
        {
            toggle("Lava damage is", ConfigEntry.ALLOW_LAVA_DAMAGE);
            return true;
        }
<<<<<<< HEAD
        else if (args[0].equalsIgnoreCase("firespread"))
        {
            toggle("Fire spread is", ConfigEntry.ALLOW_FIRE_SPREAD);
            plugin.gr.setGameRule(GameRuleHandler.GameRule.DO_FIRE_TICK, ConfigEntry.ALLOW_FIRE_SPREAD.getBoolean());
            return true;
        }
        else if (args[0].equalsIgnoreCase("prelog"))
=======

        if (args[0].equals("firespread"))
        {
            toggle("Fire spread is", ConfigEntry.ALLOW_FIRE_SPREAD);
            plugin.gr.setGameRule(GameRule.DO_FIRE_TICK, ConfigEntry.ALLOW_FIRE_SPREAD.getBoolean());
            return true;
        }

        if (args[0].equals("prelog"))
>>>>>>> devel
        {
            toggle("Command prelogging is", ConfigEntry.ENABLE_PREPROCESS_LOG);
            return true;
        }
<<<<<<< HEAD
        else if (args[0].equalsIgnoreCase("lockdown"))
        {
            boolean active = !plugin.lp.isLockdownEnabled();
            plugin.lp.setLockdownEnabled(active);
            FUtil.adminAction(sender.getName(), (active ? "A" : "De-a") + "ctivating server lockdown", true);
            return true;
        }
        else if (args[0].equalsIgnoreCase("petprotect"))
=======

        if (args[0].equals("lockdown"))
        {
            boolean active = !plugin.lp.isLockdownEnabled();
            plugin.lp.setLockdownEnabled(active);

            FUtil.adminAction(sender.getName(), (active ? "A" : "De-a") + "ctivating server lockdown", true);
            return true;
        }

        if (args[0].equals("petprotect"))
>>>>>>> devel
        {
            toggle("Tamed pet protection is", ConfigEntry.ENABLE_PET_PROTECT);
            return true;
        }
<<<<<<< HEAD
        else if (args[0].equalsIgnoreCase("entitywipe"))
=======

        if (args[0].equals("entitywipe"))
>>>>>>> devel
        {
            toggle("Automatic entity wiping is", ConfigEntry.AUTO_ENTITY_WIPE);
            return true;
        }
<<<<<<< HEAD
        else if (args[0].equalsIgnoreCase("firework"))
        {
            toggle("Firework explosion is", ConfigEntry.ALLOW_FIREWORK_EXPLOSION);
            return true;
        }
        else if (args[0].equalsIgnoreCase("nonuke"))
=======

        if (args[0].equals("nonuke"))
>>>>>>> devel
        {
            if (args.length >= 2)
            {
                try
                {
                    ConfigEntry.NUKE_MONITOR_RANGE.setDouble(Math.max(1.0, Math.min(500.0, Double.parseDouble(args[1]))));
                }
<<<<<<< HEAD
                catch (NumberFormatException ex)
                {
                }
            }
=======
                catch (NumberFormatException nfex)
                {
                }
            }

>>>>>>> devel
            if (args.length >= 3)
            {
                try
                {
                    ConfigEntry.NUKE_MONITOR_COUNT_BREAK.setInteger(Math.max(1, Math.min(500, Integer.parseInt(args[2]))));
                }
<<<<<<< HEAD
                catch (NumberFormatException ex)
                {
                }
            }
            toggle("Nuke monitor is", ConfigEntry.NUKE_MONITOR_ENABLED);
=======
                catch (NumberFormatException nfex)
                {
                }
            }

            toggle("Nuke monitor is", ConfigEntry.NUKE_MONITOR_ENABLED);

>>>>>>> devel
            if (ConfigEntry.NUKE_MONITOR_ENABLED.getBoolean())
            {
                msg("Anti-freecam range is set to " + ConfigEntry.NUKE_MONITOR_RANGE.getDouble() + " blocks.");
                msg("Block throttle rate is set to " + ConfigEntry.NUKE_MONITOR_COUNT_BREAK.getInteger() + " blocks destroyed per 5 seconds.");
            }
<<<<<<< HEAD
            return true;
        }
        else if (args[0].equalsIgnoreCase("explosives"))
=======

            return true;
        }
        if (args[0].equals("explosives"))
>>>>>>> devel
        {
            if (args.length == 2)
            {
                try
                {
                    ConfigEntry.EXPLOSIVE_RADIUS.setDouble(Math.max(1.0, Math.min(30.0, Double.parseDouble(args[1]))));
                }
                catch (NumberFormatException ex)
                {
<<<<<<< HEAD
                    msg("The input provided is not a valid integer.");
                    return true;
                }
            }
            toggle("Explosions are", ConfigEntry.ALLOW_EXPLOSIONS);
=======
                    msg(ex.getMessage());
                    return true;
                }
            }

            toggle("Explosions are", ConfigEntry.ALLOW_EXPLOSIONS);

>>>>>>> devel
            if (ConfigEntry.ALLOW_EXPLOSIONS.getBoolean())
            {
                msg("Radius set to " + ConfigEntry.EXPLOSIVE_RADIUS.getDouble());
            }
            return true;
        }
<<<<<<< HEAD
        else if (args[0].equalsIgnoreCase("unsafeenchs"))
        {
            toggle("Invalid enchantments are", ConfigEntry.ALLOW_UNSAFE_ENCHANTMENTS);
            return true;
        }
        else
        {
            return false;
        }
    }

    private void toggle(final String name, final ConfigEntry entry)
    {
        msg(name + " now " + (entry.setBoolean(!entry.getBoolean()) ? "enabled." : "disabled."));
    }

    @Override
    public List<String> getTabCompleteOptions(CommandSender sender, Command command, String alias, String[] args)
    {
        if (args.length == 1)
        {
            return Arrays.asList(
                    "waterplace", "fireplace", "lavaplace", "fluidspread", "lavadmg", "firespread", "frostwalk",
                    "firework", "prelog", "lockdown", "petprotect", "entitywipe", "nonuke", "explosives", "unsafeenchs");
        }

        return Collections.emptyList();
    }
}

=======

        return false;
    }

    private void toggle(String name, ConfigEntry entry)
    {
        msg(name + " now " + (entry.setBoolean(!entry.getBoolean()) ? "enabled." : "disabled."));
    }
}
>>>>>>> devel
