package me.totalfreedom.totalfreedommod.blocking;

import me.totalfreedom.totalfreedommod.FreedomService;
import me.totalfreedom.totalfreedommod.TotalFreedomMod;
import me.totalfreedom.totalfreedommod.config.ConfigEntry;
<<<<<<< HEAD
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
=======
>>>>>>> devel
import org.bukkit.entity.Bat;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Giant;
import org.bukkit.entity.HumanEntity;
<<<<<<< HEAD
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
=======
import org.bukkit.entity.Slime;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.CreatureSpawnEvent;
>>>>>>> devel

public class MobBlocker extends FreedomService
{

    public MobBlocker(TotalFreedomMod plugin)
    {
        super(plugin);
    }

    @Override
    protected void onStart()
    {
    }

    @Override
    protected void onStop()
    {
    }

<<<<<<< HEAD
    //fixes crash mobs, credit to Mafrans
    @EventHandler(priority = EventPriority.NORMAL)
    public void onEntitySpawn(EntitySpawnEvent e)
    {
        if (!(e instanceof LivingEntity))
        {
            return;
        }

        Entity entity = e.getEntity();
        if (entity instanceof Attributable)
        {
            if (((Attributable)entity).getAttribute(Attribute.GENERIC_FOLLOW_RANGE).getBaseValue() > 255.0)
            {
                ((Attributable)entity).getAttribute(Attribute.GENERIC_FOLLOW_RANGE).setBaseValue(255.0);
            }
            if (((Attributable)entity).getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getBaseValue() > 10.0)
            {
                ((Attributable)entity).getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(10.0);
            }
        }
    }

=======
>>>>>>> devel
    @EventHandler(priority = EventPriority.NORMAL)
    public void onCreatureSpawn(CreatureSpawnEvent event)
    {
        if (!ConfigEntry.MOB_LIMITER_ENABLED.getBoolean())
        {
            return;
        }

        final Entity spawned = event.getEntity();
<<<<<<< HEAD

=======
>>>>>>> devel
        if (spawned instanceof EnderDragon)
        {
            if (ConfigEntry.MOB_LIMITER_DISABLE_DRAGON.getBoolean())
            {
                event.setCancelled(true);
                return;
            }
        }
        else if (spawned instanceof Ghast)
        {
            if (ConfigEntry.MOB_LIMITER_DISABLE_GHAST.getBoolean())
            {
                event.setCancelled(true);
                return;
            }
        }
        else if (spawned instanceof Slime)
        {
            if (ConfigEntry.MOB_LIMITER_DISABLE_SLIME.getBoolean())
            {
                event.setCancelled(true);
                return;
            }
        }
<<<<<<< HEAD
        else if (spawned instanceof Wither)
        {
            if (ConfigEntry.MOB_LIMITER_DISABLE_DRAGON.getBoolean())
            {
                event.setCancelled(true);
                return;
            }
        }
=======
>>>>>>> devel
        else if (spawned instanceof Giant)
        {
            if (ConfigEntry.MOB_LIMITER_DISABLE_GIANT.getBoolean())
            {
                event.setCancelled(true);
                return;
            }
        }
        else if (spawned instanceof Bat)
        {
            event.setCancelled(true);
            return;
        }

        int mobLimiterMax = ConfigEntry.MOB_LIMITER_MAX.getInteger();

        if (mobLimiterMax <= 0)
        {
            return;
        }

        int mobcount = 0;
        for (Entity entity : event.getLocation().getWorld().getLivingEntities())
        {
<<<<<<< HEAD
            if (!(entity instanceof HumanEntity) && entity instanceof LivingEntity)
=======
            if (!(entity instanceof HumanEntity))
>>>>>>> devel
            {
                mobcount++;
            }
        }

        if (mobcount > mobLimiterMax)
        {
            event.setCancelled(true);
        }
    }
<<<<<<< HEAD
=======

>>>>>>> devel
}
