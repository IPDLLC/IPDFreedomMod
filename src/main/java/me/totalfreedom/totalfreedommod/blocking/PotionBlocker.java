package me.totalfreedom.totalfreedommod.blocking;

<<<<<<< HEAD
import java.util.Collection;
import me.totalfreedom.totalfreedommod.FreedomService;
import me.totalfreedom.totalfreedommod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.entity.LingeringPotion;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.LingeringPotionSplashEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
=======
import me.totalfreedom.totalfreedommod.FreedomService;
import me.totalfreedom.totalfreedommod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.PotionSplashEvent;
>>>>>>> devel
import org.bukkit.projectiles.ProjectileSource;

public class PotionBlocker extends FreedomService
{

    public static final int POTION_BLOCK_RADIUS_SQUARED = 20 * 20;

    public PotionBlocker(TotalFreedomMod plugin)
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

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onThrowPotion(PotionSplashEvent event)
    {
<<<<<<< HEAD
        ThrownPotion potion = event.getEntity();
        ProjectileSource projectileSource = potion.getShooter();
        Player player = null;
        if (projectileSource instanceof Player)
        {
            player = (Player)projectileSource;
        }

        if (isDeathPotion(potion.getEffects()))
        {
            if (player != null)
            {
                player.sendMessage(ChatColor.RED + "You are not allowed to use death potions.");
            }
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onThrowLingeringPotion(LingeringPotionSplashEvent event)
    {
        LingeringPotion potion = event.getEntity();
        ProjectileSource projectileSource = potion.getShooter();
        Player player = null;
        if (projectileSource instanceof Player)
        {
            player = (Player)projectileSource;
        }

        if (isDeathPotion(potion.getEffects()))
        {
            if (player != null)
            {
                player.sendMessage(ChatColor.RED + "You are not allowed to use death potions.");
            }
            event.setCancelled(true);
        }
    }

    public boolean isDeathPotion(Collection<PotionEffect> effects)
    {
        for (PotionEffect effect : effects)
        {
            if (effect.getType().equals(PotionEffectType.HEAL) && effect.getAmplifier() == 125)
            {
                return true;
            }
        }
        return false;
=======
        ProjectileSource source = event.getEntity().getShooter();

        if (!(source instanceof Player))
        {
            event.setCancelled(true);
            return;
        }

        Player thrower = (Player) source;

        if (plugin.al.isAdmin(thrower))
        {
            return;
        }

        for (Player player : thrower.getWorld().getPlayers())
        {
            if (thrower.getLocation().distanceSquared(player.getLocation()) < POTION_BLOCK_RADIUS_SQUARED)
            {
                thrower.sendMessage(ChatColor.RED + "You cannot use splash potions close to other players.");
                event.setCancelled(true);
                return;
            }
        }

>>>>>>> devel
    }

}
