/*
 * Cleanroom Generator
 * Copyright (C) 2011-2012 nvx
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
<<<<<<< HEAD

package me.totalfreedom.totalfreedommod.world;

import java.util.Arrays;
import java.util.Random;
import me.totalfreedom.totalfreedommod.config.ConfigEntry;
import me.totalfreedom.totalfreedommod.util.FLog;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;
import static java.lang.System.arraycopy;

public class CleanroomChunkGenerator extends ChunkGenerator
{
    private static final String GENERATION_PARAMETERS = ConfigEntry.FLATLANDS_GENERATE_PARAMS.getString();

    private Material[] materials;

    public CleanroomChunkGenerator()
    {
        this(GENERATION_PARAMETERS);
=======
package me.totalfreedom.totalfreedommod.world;

import static java.lang.System.arraycopy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

@SuppressWarnings("deprecation")
public class CleanroomChunkGenerator extends ChunkGenerator
{

    private static final Logger log = Bukkit.getLogger();
    private short[] layer;
    private byte[] layerDataValues;

    public CleanroomChunkGenerator()
    {
        this("64,stone");
>>>>>>> devel
    }

    public CleanroomChunkGenerator(String id)
    {
        if (id != null)
        {
            try
            {
                int y = 0;

<<<<<<< HEAD
                materials = new Material[128]; // Default to 128, will be resized later if required
                materials[y++] = Material.BEDROCK;
=======
                layer = new short[128]; // Default to 128, will be resized later if required
                layerDataValues = null;

                if ((id.length() > 0) && (id.charAt(0) == '.')) // Is the first character a '.'? If so, skip bedrock generation.
                {
                    id = id.substring(1); // Skip bedrock then and remove the .
                }
                else // Guess not, bedrock at layer0 it is then.
                {
                    layer[y++] = (short) Material.BEDROCK.getId();
                }
>>>>>>> devel

                if (id.length() > 0)
                {
                    String tokens[] = id.split("[,]");

                    if ((tokens.length % 2) != 0)
                    {
                        throw new Exception();
                    }

                    for (int i = 0; i < tokens.length; i += 2)
                    {
                        int height = Integer.parseInt(tokens[i]);
                        if (height <= 0)
                        {
<<<<<<< HEAD
                            FLog.warning("[CleanroomGenerator] Invalid height '" + tokens[i] + "'. Using 64 instead.");
=======
                            log.warning("[CleanroomGenerator] Invalid height '" + tokens[i] + "'. Using 64 instead.");
>>>>>>> devel
                            height = 64;
                        }

                        String materialTokens[] = tokens[i + 1].split("[:]", 2);
<<<<<<< HEAD

                        if (materialTokens.length == 2)
                        {
                            FLog.warning("[CleanroomGenerator] Data values are no longer supported in 1.13. Defaulting to the base material for " + materialTokens[0]);
                        }

                        Material mat = Material.matchMaterial(materialTokens[0]);
                        if (mat == null)
                        {
                            FLog.warning("[CleanroomGenerator] Invalid Block ID '" + materialTokens[0] + "'. Defaulting to stone. (Integer IDs were removed in 1.13)");
                            mat = Material.STONE;
=======
                        byte dataValue = 0;
                        if (materialTokens.length == 2)
                        {
                            try
                            {
                                // Lets try to read the data value
                                dataValue = Byte.parseByte(materialTokens[1]);
                            }
                            catch (Exception e)
                            {
                                log.warning("[CleanroomGenerator] Invalid Data Value '" + materialTokens[1] + "'. Defaulting to 0.");
                                dataValue = 0;
                            }
                        }
                        Material mat = Material.matchMaterial(materialTokens[0]);
                        if (mat == null)
                        {
                            try
                            {
                                // Mabe it's an integer?
                                mat = Material.getMaterial(Integer.parseInt(materialTokens[0]));
                            }
                            catch (Exception e)
                            {
                                // Well, I guess it wasn't an integer after all... Awkward...
                            }

                            if (mat == null)
                            {
                                log.warning("[CleanroomGenerator] Invalid Block ID '" + materialTokens[0] + "'. Defaulting to stone.");
                                mat = Material.STONE;
                            }
>>>>>>> devel
                        }

                        if (!mat.isBlock())
                        {
<<<<<<< HEAD
                            FLog.warning("[CleanroomGenerator] Error, '" + materialTokens[0] + "' is not a block. Defaulting to stone.");
                            mat = Material.STONE;
                        }

                        if (y + height > materials.length)
                        {
                            Material[] newMaterials = new Material[Math.max(y + height, materials.length * 2)];

                            arraycopy(materials, 0, newMaterials, 0, y);
                            materials = newMaterials;
                        }

                        Arrays.fill(materials, y, y + height, mat);
=======
                            log.warning("[CleanroomGenerator] Error, '" + materialTokens[0] + "' is not a block. Defaulting to stone.");
                            mat = Material.STONE;
                        }

                        if (y + height > layer.length)
                        {
                            short[] newLayer = new short[Math.max(y + height, layer.length * 2)];
                            arraycopy(layer, 0, newLayer, 0, y);
                            layer = newLayer;
                            if (layerDataValues != null)
                            {
                                byte[] newLayerDataValues = new byte[Math.max(y + height, layerDataValues.length * 2)];
                                arraycopy(layerDataValues, 0, newLayerDataValues, 0, y);
                                layerDataValues = newLayerDataValues;
                            }
                        }

                        Arrays.fill(layer, y, y + height, (short) mat.getId());
                        if (dataValue != 0)
                        {
                            if (layerDataValues == null)
                            {
                                layerDataValues = new byte[layer.length];
                            }
                            Arrays.fill(layerDataValues, y, y + height, dataValue);
                        }
>>>>>>> devel
                        y += height;
                    }
                }

                // Trim to size
<<<<<<< HEAD
                if (materials.length > y)
                {
                    Material[] newMaterials = new Material[y];
                    arraycopy(materials, 0, newMaterials, 0, y);
                    materials = newMaterials;
=======
                if (layer.length > y)
                {
                    short[] newLayer = new short[y];
                    arraycopy(layer, 0, newLayer, 0, y);
                    layer = newLayer;
                }
                if (layerDataValues != null && layerDataValues.length > y)
                {
                    byte[] newLayerDataValues = new byte[y];
                    arraycopy(layerDataValues, 0, newLayerDataValues, 0, y);
                    layerDataValues = newLayerDataValues;
>>>>>>> devel
                }
            }
            catch (Exception e)
            {
<<<<<<< HEAD
                FLog.severe("[CleanroomGenerator] Error parsing CleanroomGenerator ID '" + id + "'. using defaults '64,1': " + e.toString());
                e.printStackTrace();

                materials = new Material[65];
                materials[0] = Material.BEDROCK;
                Arrays.fill(materials, 1, 65, Material.STONE);
=======
                log.severe("[CleanroomGenerator] Error parsing CleanroomGenerator ID '" + id + "'. using defaults '64,1': " + e.toString());
                e.printStackTrace();
                layerDataValues = null;
                layer = new short[65];
                layer[0] = (short) Material.BEDROCK.getId();
                Arrays.fill(layer, 1, 65, (short) Material.STONE.getId());
>>>>>>> devel
            }
        }
        else
        {
<<<<<<< HEAD
            materials = new Material[65];
            materials[0] = Material.BEDROCK;
            Arrays.fill(materials, 1, 65, Material.STONE);
=======
            layerDataValues = null;
            layer = new short[65];
            layer[0] = (short) Material.BEDROCK.getId();
            Arrays.fill(layer, 1, 65, (short) Material.STONE.getId());
>>>>>>> devel
        }
    }

    @Override
<<<<<<< HEAD
    public ChunkData generateChunkData(World world, Random random, int x, int z, BiomeGrid biome)
    {
        int maxHeight = world.getMaxHeight();
        if (materials.length > maxHeight)
        {
            FLog.warning("[CleanroomGenerator] Error, chunk height " + materials.length + " is greater than the world max height (" + maxHeight + "). Trimming to world max height.");
            Material[] newMaterials = new Material[maxHeight];
            arraycopy(materials, 0, newMaterials, 0, maxHeight);
            materials = newMaterials;
        }

        ChunkData result = createChunkData(world);

        for (int y = 0; y < materials.length; y++)
        {
            result.setRegion(0, y, 0, 16, y + 1, 16, materials[y]);
=======
    public short[][] generateExtBlockSections(World world, Random random, int x, int z, BiomeGrid biomes)
    {
        int maxHeight = world.getMaxHeight();
        if (layer.length > maxHeight)
        {
            log.warning("[CleanroomGenerator] Error, chunk height " + layer.length + " is greater than the world max height (" + maxHeight + "). Trimming to world max height.");
            short[] newLayer = new short[maxHeight];
            arraycopy(layer, 0, newLayer, 0, maxHeight);
            layer = newLayer;
        }
        short[][] result = new short[maxHeight / 16][]; // 16x16x16 chunks
        for (int i = 0; i < layer.length; i += 16)
        {
            result[i >> 4] = new short[4096];
            for (int y = 0; y < Math.min(16, layer.length - i); y++)
            {
                Arrays.fill(result[i >> 4], y * 16 * 16, (y + 1) * 16 * 16, layer[i + y]);
            }
>>>>>>> devel
        }

        return result;
    }

    @Override
<<<<<<< HEAD
=======
    public List<BlockPopulator> getDefaultPopulators(World world)
    {
        if (layerDataValues != null)
        {
            return Arrays.asList((BlockPopulator) new CleanroomBlockPopulator(layerDataValues));
        }
        else
        {
            // This is the default, but just in case default populators change to stock minecraft populators by default...
            return new ArrayList<>();
        }
    }

    @Override
>>>>>>> devel
    public Location getFixedSpawnLocation(World world, Random random)
    {
        if (!world.isChunkLoaded(0, 0))
        {
            world.loadChunk(0, 0);
        }

        if ((world.getHighestBlockYAt(0, 0) <= 0) && (world.getBlockAt(0, 0, 0).getType() == Material.AIR)) // SPACE!
        {
            return new Location(world, 0, 64, 0); // Lets allow people to drop a little before hitting the void then shall we?
        }

        return new Location(world, 0, world.getHighestBlockYAt(0, 0), 0);
    }
}
