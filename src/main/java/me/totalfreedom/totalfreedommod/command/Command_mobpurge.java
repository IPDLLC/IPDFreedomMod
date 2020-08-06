package me.totalfreedom.totalfreedommod.command;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import me.totalfreedom.totalfreedommod.util.Groups;
import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH)
@CommandParameters(description = "Purge all mobs in all worlds.", usage = "/<command> [name]", aliases = "mp")
public class Command_mobpurge extends FreedomCommand
{
    public static int purgeMobs(EntityType type)
=======
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Ambient;
import org.bukkit.entity.Creature;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH)
@CommandParameters(description = "Purge all mobs in all worlds.", usage = "/<command>", aliases = "mp")
public class Command_mobpurge extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        FUtil.adminAction(sender.getName(), "Purging all mobs", true);
        msg(purgeMobs() + " mobs removed.");
        return true;
    }

    public static int purgeMobs()
>>>>>>> devel
    {
        int removed = 0;
        for (World world : Bukkit.getWorlds())
        {
            for (Entity ent : world.getLivingEntities())
            {
<<<<<<< HEAD
                if (ent instanceof LivingEntity && !(ent instanceof Player))
                {
                    if (type != null && !ent.getType().equals(type))
                    {
                        continue;
                    }
=======
                if (ent instanceof Creature || ent instanceof Ghast || ent instanceof Slime || ent instanceof EnderDragon || ent instanceof Ambient)
                {
>>>>>>> devel
                    ent.remove();
                    removed++;
                }
            }
        }

        return removed;
    }
<<<<<<< HEAD

    public static List<String> getAllMobNames()
    {
        List<String> names = new ArrayList<>();
        for (EntityType entityType : Groups.MOB_TYPES)
        {
            names.add(entityType.name());
        }
        return names;
    }

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        EntityType type = null;
        String mobName = null;
        if (args.length > 0)
        {
            try
            {
                type = EntityType.valueOf(args[0].toUpperCase());
            }
            catch (Exception e)
            {
                msg(args[0] + " is not a valid mob type.", ChatColor.RED);
                return true;
            }

            if (!Groups.MOB_TYPES.contains(type))
            {
                msg(WordUtils.capitalizeFully(type.name().replace("_", " ")) + " is an entity, however it is not a mob.", ChatColor.RED);
                return true;
            }
        }

        if (type != null)
        {
            mobName = WordUtils.capitalizeFully(type.name().replace("_", " "));
        }

        FUtil.adminAction(sender.getName(), "Purging all " + (type != null ? mobName + "s" : "mobs"), true);
        msg(purgeMobs(type) + " " + (type != null ? mobName : "mob") + "s removed.");
        return true;
    }

    @Override
    public List<String> getTabCompleteOptions(CommandSender sender, Command command, String alias, String[] args)
    {
        if (args.length == 1)
        {
            return getAllMobNames();
        }

        return Collections.emptyList();
    }
=======
>>>>>>> devel
}
