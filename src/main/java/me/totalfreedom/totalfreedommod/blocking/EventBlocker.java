package me.totalfreedom.totalfreedommod.blocking;

import me.totalfreedom.totalfreedommod.FreedomService;
import me.totalfreedom.totalfreedommod.TotalFreedomMod;
import me.totalfreedom.totalfreedommod.config.ConfigEntry;
<<<<<<< HEAD
import me.totalfreedom.totalfreedommod.util.Groups;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.Entity;
=======
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Projectile;
>>>>>>> devel
import org.bukkit.entity.Tameable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBurnEvent;
<<<<<<< HEAD
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockRedstoneEvent;
=======
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockIgniteEvent;
>>>>>>> devel
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
<<<<<<< HEAD
import org.bukkit.event.entity.FireworkExplodeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
=======
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
>>>>>>> devel

public class EventBlocker extends FreedomService
{

    public EventBlocker(TotalFreedomMod plugin)
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

    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockBurn(BlockBurnEvent event)
    {
        if (!ConfigEntry.ALLOW_FIRE_SPREAD.getBoolean())
        {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockIgnite(BlockIgniteEvent event)
    {
        if (!ConfigEntry.ALLOW_FIRE_PLACE.getBoolean())
        {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockFromTo(BlockFromToEvent event)
    {
        if (!ConfigEntry.ALLOW_FLUID_SPREAD.getBoolean())
        {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onEntityExplode(EntityExplodeEvent event)
    {
        if (!ConfigEntry.ALLOW_EXPLOSIONS.getBoolean())
        {
<<<<<<< HEAD
            event.blockList().clear();
=======
            event.setCancelled(true);
>>>>>>> devel
            return;
        }

        event.setYield(0.0F);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onExplosionPrime(ExplosionPrimeEvent event)
    {
        if (!ConfigEntry.ALLOW_EXPLOSIONS.getBoolean())
        {
            event.setCancelled(true);
            return;
        }

        event.setRadius(ConfigEntry.EXPLOSIVE_RADIUS.getDouble().floatValue());
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onEntityCombust(EntityCombustEvent event)
    {
        if (!ConfigEntry.ALLOW_EXPLOSIONS.getBoolean())
        {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onEntityDeath(EntityDeathEvent event)
    {
        if (ConfigEntry.AUTO_ENTITY_WIPE.getBoolean())
        {
            event.setDroppedExp(0);
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
<<<<<<< HEAD
=======
    public void onProjectileHit(ProjectileHitEvent event)
    {
        if (ConfigEntry.ALLOW_EXPLOSIONS.getBoolean())
        {
            Projectile entity = event.getEntity();
            if (event.getEntityType() == EntityType.ARROW)
            {
                entity.getWorld().createExplosion(entity.getLocation(), 2F);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
>>>>>>> devel
    public void onEntityDamage(EntityDamageEvent event)
    {
        switch (event.getCause())
        {
            case LAVA:
            {
                if (!ConfigEntry.ALLOW_LAVA_DAMAGE.getBoolean())
                {
                    event.setCancelled(true);
                    return;
                }
            }
        }

        if (ConfigEntry.ENABLE_PET_PROTECT.getBoolean())
        {
            Entity entity = event.getEntity();
            if (entity instanceof Tameable)
            {
<<<<<<< HEAD
                if (((Tameable)entity).isTamed())
=======
                if (((Tameable) entity).isTamed())
>>>>>>> devel
                {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerDropItem(PlayerDropItemEvent event)
    {
        if (!ConfigEntry.AUTO_ENTITY_WIPE.getBoolean())
        {
            return;
        }

<<<<<<< HEAD
        if (event.getPlayer().getWorld().getEntities().size() > 750 && !plugin.al.isAdmin(event.getPlayer()))
=======
        if (event.getPlayer().getWorld().getEntities().size() > 750)
>>>>>>> devel
        {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onLeavesDecay(LeavesDecayEvent event)
    {
        event.setCancelled(true);
    }

<<<<<<< HEAD
    @EventHandler(priority = EventPriority.HIGH)
    public void onFireworkExplode(FireworkExplodeEvent event)
    {
        if (!ConfigEntry.ALLOW_FIREWORK_EXPLOSION.getBoolean())
        {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockPistonRetract(BlockPistonRetractEvent event)
    {
        if (!ConfigEntry.ALLOW_REDSTONE.getBoolean())
        {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockPistonExtend(BlockPistonExtendEvent event)
    {
        if (!ConfigEntry.ALLOW_REDSTONE.getBoolean())
        {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onBlockRedstone(BlockRedstoneEvent event)
    {
        if (!ConfigEntry.ALLOW_REDSTONE.getBoolean())
        {
            event.setNewCurrent(0);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerRespawn(PlayerRespawnEvent event)
    {
        double maxHealth = event.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
        if (maxHealth < 1)
        {
            for (AttributeModifier attributeModifier : event.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getModifiers())
            {
                event.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).removeModifier(attributeModifier);
            }
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onBlockDispense(BlockDispenseEvent event)
    {
        ItemStack item = event.getItem();
        if (Groups.SHULKER_BOXES.contains(item.getType()))
        {
            BlockStateMeta blockStateMeta = (BlockStateMeta)item.getItemMeta();
            ShulkerBox shulkerBox = (ShulkerBox)blockStateMeta.getBlockState();
            for (ItemStack itemStack : shulkerBox.getInventory().getContents())
            {
                if (itemStack != null)
                {
                    event.setCancelled(true);
                    break;
                }
            }
        }
    }
=======
>>>>>>> devel
}
