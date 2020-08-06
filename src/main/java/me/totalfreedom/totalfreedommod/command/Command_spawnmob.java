package me.totalfreedom.totalfreedommod.command;

<<<<<<< HEAD
import java.util.List;
import java.util.Set;
import me.totalfreedom.totalfreedommod.rank.Rank;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
=======
import me.totalfreedom.totalfreedommod.rank.Rank;
import org.bukkit.ChatColor;
import org.bukkit.Location;
>>>>>>> devel
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.OP, source = SourceType.ONLY_IN_GAME)
<<<<<<< HEAD
@CommandParameters(description = "Spawn an entity.", usage = "/<command> <entitytype> [amount]", aliases = "spawnentity")
public class Command_spawnmob extends FreedomCommand
{
    @Override
    protected boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length > 0 && args[0].equalsIgnoreCase("list"))
        {
            List<EntityType> types = EnumUtils.getEnumList(EntityType.class);
            String typeList = StringUtils.join(types, ", ").toLowerCase();
            msg(typeList);
            return true;
        }

=======
@CommandParameters(description = "Make an announcement", usage = "/<command> <mobtype> [amount]")
public class Command_spawnmob extends FreedomCommand
{

    @Override
    protected boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
>>>>>>> devel
        if (args.length < 1)
        {
            return false;
        }

        EntityType type = null;
        for (EntityType loop : EntityType.values())
        {
<<<<<<< HEAD
            if (loop != null && loop.name().equalsIgnoreCase(args[0]))
=======
            if (loop.getName().equalsIgnoreCase(args[0]))
>>>>>>> devel
            {
                type = loop;
                break;
            }
        }

        if (type == null)
        {
            msg("Unknown entity type: " + args[0], ChatColor.RED);
            return true;
        }

        if (!type.isSpawnable() || !type.isAlive())
        {
<<<<<<< HEAD
            msg("Can not spawn entity type: " + type.name().toLowerCase());
=======
            msg("Can not spawn entity type: " + type.getName());
>>>>>>> devel
            return true;
        }

        int amount = 1;
        if (args.length > 1)
        {
            try
            {
                amount = Integer.parseInt(args[1]);
            }
            catch (NumberFormatException nfex)
            {
                msg("Invalid amount: " + args[1], ChatColor.RED);
                return true;
            }
        }

        if (amount > 10 || amount < 1)
        {
            msg("Invalid amount: " + args[1] + ". Must be 1-10.", ChatColor.RED);
            return true;
        }

<<<<<<< HEAD
        Location l = playerSender.getTargetBlock((Set<Material>)null, 30).getLocation().add(0, 1, 0);
        World w = playerSender.getWorld();
        msg("Spawning " + amount + " " + type.name().toLowerCase() + (amount > 1 ? "s." : "."));

        for (int i = 0; i < amount; i++)
=======
        Location l = playerSender.getLocation();
        World w = playerSender.getWorld();
        msg("Spawning " + amount + " of " + type.getName());

        for (int i = 0; i < amount; amount++)
>>>>>>> devel
        {
            w.spawnEntity(l, type);
        }
        return true;
    }
<<<<<<< HEAD
=======

>>>>>>> devel
}
