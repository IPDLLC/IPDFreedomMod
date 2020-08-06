package me.totalfreedom.totalfreedommod.util;

import java.util.HashSet;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
<<<<<<< HEAD
=======
import org.bukkit.material.MaterialData;
>>>>>>> devel

@SuppressWarnings("deprecation")
public class DepreciationAggregator
{
<<<<<<< HEAD
=======

>>>>>>> devel
    public static Block getTargetBlock(LivingEntity entity, HashSet<Material> transparent, int maxDistance)
    {
        return entity.getTargetBlock(transparent, maxDistance);
    }

    public static OfflinePlayer getOfflinePlayer(Server server, String name)
    {
        return server.getOfflinePlayer(name);
    }

<<<<<<< HEAD
=======
    public static Material getMaterial(int id)
    {
        return Material.getMaterial(id);
    }

    public static byte getData_MaterialData(MaterialData md)
    {
        return md.getData();
    }

    public static void setData_MaterialData(MaterialData md, byte data)
    {
        md.setData(data);
    }

    public static byte getData_Block(Block block)
    {
        return block.getData();
    }

    public static void setData_Block(Block block, byte data)
    {
        block.setData(data);
    }

    public static org.bukkit.material.Lever makeLeverWithData(byte data)
    {
        return new org.bukkit.material.Lever(Material.LEVER, data);
    }

    public static int getTypeId_Block(Block block)
    {
        return block.getTypeId();
    }

>>>>>>> devel
    public static String getName_EntityType(EntityType et)
    {
        return et.getName();
    }
}
