package me.totalfreedom.totalfreedommod.fun;

import com.google.common.collect.Maps;
<<<<<<< HEAD
import java.util.HashMap;
=======
>>>>>>> devel
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import me.totalfreedom.totalfreedommod.FreedomService;
import me.totalfreedom.totalfreedommod.TotalFreedomMod;
<<<<<<< HEAD
import me.totalfreedom.totalfreedommod.util.Groups;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
=======
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
>>>>>>> devel
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class Jumppads extends FreedomService
{
<<<<<<< HEAD
    public static final double DAMPING_COEFFICIENT = 0.8;
    //
    private final Map<Player, Boolean> pushMap = Maps.newHashMap();
    public HashMap<Player, JumpPadMode> players = new HashMap<>();
    //
    @Getter
    @Setter
    private double strength = 1 + 0.1F;
=======

    public static final Material BLOCK_ID = Material.WOOL;
    public static final double DAMPING_COEFFICIENT = 0.8;
    //
    private final Map<Player, Boolean> pushMap = Maps.newHashMap();
    //
    @Getter
    @Setter
    private JumpPadMode mode = JumpPadMode.MADGEEK;
    @Getter
    @Setter
    private double strength = 0.4;
>>>>>>> devel

    public Jumppads(TotalFreedomMod plugin)
    {
        super(plugin);
    }

    @Override
    public void onStart()
    {
<<<<<<< HEAD
=======

>>>>>>> devel
    }

    @Override
    public void onStop()
    {
<<<<<<< HEAD
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        if (!players.containsKey(event.getPlayer()))
        {
            players.put(event.getPlayer(), JumpPadMode.OFF);
        }
=======

>>>>>>> devel
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event)
    {
<<<<<<< HEAD
        if (players.get(event.getPlayer()) == JumpPadMode.OFF)
=======
        if (mode == JumpPadMode.OFF)
>>>>>>> devel
        {
            return;
        }

        final Player player = event.getPlayer();
        final Block block = event.getTo().getBlock();
        final Vector velocity = player.getVelocity().clone();

<<<<<<< HEAD
        if (players.get(event.getPlayer()) == JumpPadMode.MADGEEK)
=======
        if (mode == JumpPadMode.MADGEEK)
>>>>>>> devel
        {
            Boolean canPush = pushMap.get(player);
            if (canPush == null)
            {
                canPush = true;
            }
<<<<<<< HEAD
            if (Groups.WOOL_COLORS.contains(block.getRelative(0, -1, 0).getType()))
=======
            if (block.getRelative(0, -1, 0).getType() == BLOCK_ID)
>>>>>>> devel
            {
                if (canPush)
                {
                    velocity.multiply(strength + 0.85).multiply(-1.0);
                }
                canPush = false;
            }
            else
            {
                canPush = true;
            }
            pushMap.put(player, canPush);
        }
        else
        {
<<<<<<< HEAD
            if (Groups.WOOL_COLORS.contains(block.getRelative(0, -1, 0).getType()))
=======
            if (block.getRelative(0, -1, 0).getType() == BLOCK_ID)
>>>>>>> devel
            {
                velocity.add(new Vector(0.0, strength, 0.0));
            }

<<<<<<< HEAD
            if (players.get(event.getPlayer()) == JumpPadMode.NORMAL_AND_SIDEWAYS)
            {
                if (Groups.WOOL_COLORS.contains(block.getRelative(1, 0, 0).getType()))
=======
            if (mode == JumpPadMode.NORMAL_AND_SIDEWAYS)
            {
                if (block.getRelative(1, 0, 0).getType() == BLOCK_ID)
>>>>>>> devel
                {
                    velocity.add(new Vector(-DAMPING_COEFFICIENT * strength, 0.0, 0.0));
                }

<<<<<<< HEAD
                if (Groups.WOOL_COLORS.contains(block.getRelative(-1, 0, 0).getType()))
=======
                if (block.getRelative(-1, 0, 0).getType() == BLOCK_ID)
>>>>>>> devel
                {
                    velocity.add(new Vector(DAMPING_COEFFICIENT * strength, 0.0, 0.0));
                }

<<<<<<< HEAD
                if (Groups.WOOL_COLORS.contains(block.getRelative(0, 0, 1).getType()))
=======
                if (block.getRelative(0, 0, 1).getType() == BLOCK_ID)
>>>>>>> devel
                {
                    velocity.add(new Vector(0.0, 0.0, -DAMPING_COEFFICIENT * strength));
                }

<<<<<<< HEAD
                if (Groups.WOOL_COLORS.contains(block.getRelative(0, 0, -1).getType()))
=======
                if (block.getRelative(0, 0, -1).getType() == BLOCK_ID)
>>>>>>> devel
                {
                    velocity.add(new Vector(0.0, 0.0, DAMPING_COEFFICIENT * strength));
                }
            }
        }

        if (!player.getVelocity().equals(velocity))
        {
            player.setFallDistance(0.0f);
            player.setVelocity(velocity);
        }
    }

<<<<<<< HEAD
    public enum JumpPadMode
    {
        OFF(false), NORMAL_AND_SIDEWAYS(true), MADGEEK(true);
        private final boolean on;

        JumpPadMode(boolean on)
=======
    public static enum JumpPadMode
    {

        OFF(false), NORMAL(true), NORMAL_AND_SIDEWAYS(true), MADGEEK(true);
        private final boolean on;

        private JumpPadMode(boolean on)
>>>>>>> devel
        {
            this.on = on;
        }

        public boolean isOn()
        {
            return on;
        }
    }
}
