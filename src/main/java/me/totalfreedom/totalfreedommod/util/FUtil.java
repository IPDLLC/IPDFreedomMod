package me.totalfreedom.totalfreedommod.util;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
<<<<<<< HEAD
import java.util.Iterator;
=======
>>>>>>> devel
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.totalfreedom.totalfreedommod.config.ConfigEntry;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
<<<<<<< HEAD
import org.bukkit.Material;
=======
>>>>>>> devel
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class FUtil
{
<<<<<<< HEAD
    public static final String SAVED_FLAGS_FILENAME = "savedflags.dat";
    // See https://github.com/TotalFreedom/License - None of the listed names may be removed.
    public static final List<String> DEVELOPERS = Arrays.asList("Madgeek1450", "Prozza", "WickedGamingUK", "Arcaknight", "OxLemonxO", "Wild1145", "Catholic_Mario", "LickTheCheese", "G6_", "jucelo");
    public static final List<String> CRIPPLINGDEPRESSION = Arrays.asList("Babeuh");
    public static final List<String> CO_OWNER = Arrays.asList("Greenate");
    public static final Map<String, ChatColor> CHAT_COLOR_NAMES = new HashMap<>();
    public static final List<ChatColor> CHAT_COLOR_POOL = Arrays.asList(
            ChatColor.DARK_RED,
            ChatColor.RED,
            ChatColor.GOLD,
            ChatColor.YELLOW,
            ChatColor.GREEN,
            ChatColor.DARK_GREEN,
            ChatColor.AQUA,
            ChatColor.DARK_AQUA,
            ChatColor.BLUE,
            ChatColor.DARK_BLUE,
            ChatColor.DARK_PURPLE,
            ChatColor.LIGHT_PURPLE);
    private static final Random RANDOM = new Random();
    public static String DATE_STORAGE_FORMAT = "EEE, d MMM yyyy HH:mm:ss Z";
    private static Iterator<ChatColor> CHAT_COLOR_ITERATOR;
=======

    private static final Random RANDOM = new Random();
    //
    public static final String SAVED_FLAGS_FILENAME = "savedflags.dat";
    // See https://github.com/TotalFreedom/License - None of the listed names may be removed.
    public static final List<String> DEVELOPERS = Arrays.asList("Madgeek1450", "Prozza", "Wild1145", "WickedGamingUK", "aggelosQQ");
    public static String DATE_STORAGE_FORMAT = "EEE, d MMM yyyy HH:mm:ss Z";
    public static final Map<String, ChatColor> CHAT_COLOR_NAMES = new HashMap<>();
    public static final List<ChatColor> CHAT_COLOR_POOL = Arrays.asList(
            ChatColor.DARK_BLUE,
            ChatColor.DARK_GREEN,
            ChatColor.DARK_AQUA,
            ChatColor.DARK_RED,
            ChatColor.DARK_PURPLE,
            ChatColor.GOLD,
            ChatColor.BLUE,
            ChatColor.GREEN,
            ChatColor.AQUA,
            ChatColor.RED,
            ChatColor.LIGHT_PURPLE,
            ChatColor.YELLOW);
>>>>>>> devel

    static
    {
        for (ChatColor chatColor : CHAT_COLOR_POOL)
        {
            CHAT_COLOR_NAMES.put(chatColor.name().toLowerCase().replace("_", ""), chatColor);
        }
    }

<<<<<<< HEAD
=======
    private FUtil()
    {
    }

>>>>>>> devel
    public static void cancel(BukkitTask task)
    {
        if (task == null)
        {
            return;
        }

        try
        {
            task.cancel();
        }
        catch (Exception ex)
        {
        }
    }

<<<<<<< HEAD
    public static boolean hasMbConfigPermission(String name)
    {
        return ConfigEntry.SERVER_OWNERS.getStringList().contains(name) || ConfigEntry.SERVER_EXECUTIVES.getStringList().contains(name) || ConfigEntry.SERVER_MASTER_BUILDER_MANAGEMENT.getStringList().contains(name);
    }

    public static List<String> getPlayerList()
    {
        List<String> names = new ArrayList<>();
        for (Player player : Bukkit.getOnlinePlayers())
        {
            names.add(player.getName());
        }
        return names;
    }

    public static List<String> getAllMaterialNames()
    {
        List<String> names = new ArrayList<>();
        for (Material material : Material.values())
        {
            names.add(material.name());
        }
        return names;
    }

=======
>>>>>>> devel
    public static void bcastMsg(String message, ChatColor color)
    {
        FLog.info(message, true);

        for (Player player : Bukkit.getOnlinePlayers())
        {
            player.sendMessage((color == null ? "" : color) + message);
        }
    }

    public static void bcastMsg(String message)
    {
        FUtil.bcastMsg(message, null);
    }

    // Still in use by listeners
    public static void playerMsg(CommandSender sender, String message, ChatColor color)
    {
        sender.sendMessage(color + message);
    }

    // Still in use by listeners
    public static void playerMsg(CommandSender sender, String message)
    {
        FUtil.playerMsg(sender, message, ChatColor.GRAY);
    }

    public static void setFlying(Player player, boolean flying)
    {
        player.setAllowFlight(true);
        player.setFlying(flying);
    }

    public static void adminAction(String adminName, String action, boolean isRed)
    {
        FUtil.bcastMsg(adminName + " - " + action, (isRed ? ChatColor.RED : ChatColor.AQUA));
    }

    public static String formatLocation(Location location)
    {
        return String.format("%s: (%d, %d, %d)",
                location.getWorld().getName(),
                Math.round(location.getX()),
                Math.round(location.getY()),
                Math.round(location.getZ()));
    }

<<<<<<< HEAD
    public static boolean deleteFolder(File file)
=======
    public static boolean deleteFolder(final File file)
>>>>>>> devel
    {
        if (file.exists() && file.isDirectory())
        {
            return FileUtils.deleteQuietly(file);
        }
        return false;
    }

<<<<<<< HEAD
    public static boolean deleteFile(File file)
    {
        if (file.exists() && file.isFile())
        {
            return FileUtils.deleteQuietly(file);
        }
        return false;
    }


    public static void deleteCoreDumps()
    {
        final File[] coreDumps = new File(".").listFiles(file -> file.getName().startsWith("java.core"));
=======
    public static void deleteCoreDumps()
    {
        final File[] coreDumps = new File(".").listFiles(new FileFilter()
        {
            @Override
            public boolean accept(File file)
            {
                return file.getName().startsWith("java.core");
            }
        });
>>>>>>> devel

        for (File dump : coreDumps)
        {
            FLog.info("Removing core dump file: " + dump.getName());
            dump.delete();
        }
    }

    public static Date parseDateOffset(String time)
    {
        Pattern timePattern = Pattern.compile(
                "(?:([0-9]+)\\s*y[a-z]*[,\\s]*)?"
<<<<<<< HEAD
                        + "(?:([0-9]+)\\s*mo[a-z]*[,\\s]*)?"
                        + "(?:([0-9]+)\\s*w[a-z]*[,\\s]*)?"
                        + "(?:([0-9]+)\\s*d[a-z]*[,\\s]*)?"
                        + "(?:([0-9]+)\\s*h[a-z]*[,\\s]*)?"
                        + "(?:([0-9]+)\\s*m[a-z]*[,\\s]*)?"
                        + "(?:([0-9]+)\\s*(?:s[a-z]*)?)?", Pattern.CASE_INSENSITIVE);
=======
                + "(?:([0-9]+)\\s*mo[a-z]*[,\\s]*)?"
                + "(?:([0-9]+)\\s*w[a-z]*[,\\s]*)?"
                + "(?:([0-9]+)\\s*d[a-z]*[,\\s]*)?"
                + "(?:([0-9]+)\\s*h[a-z]*[,\\s]*)?"
                + "(?:([0-9]+)\\s*m[a-z]*[,\\s]*)?"
                + "(?:([0-9]+)\\s*(?:s[a-z]*)?)?", Pattern.CASE_INSENSITIVE);
>>>>>>> devel
        Matcher m = timePattern.matcher(time);
        int years = 0;
        int months = 0;
        int weeks = 0;
        int days = 0;
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        boolean found = false;
        while (m.find())
        {
            if (m.group() == null || m.group().isEmpty())
            {
                continue;
            }
            for (int i = 0; i < m.groupCount(); i++)
            {
                if (m.group(i) != null && !m.group(i).isEmpty())
                {
                    found = true;
                    break;
                }
            }
            if (found)
            {
                if (m.group(1) != null && !m.group(1).isEmpty())
                {
                    years = Integer.parseInt(m.group(1));
                }
                if (m.group(2) != null && !m.group(2).isEmpty())
                {
                    months = Integer.parseInt(m.group(2));
                }
                if (m.group(3) != null && !m.group(3).isEmpty())
                {
                    weeks = Integer.parseInt(m.group(3));
                }
                if (m.group(4) != null && !m.group(4).isEmpty())
                {
                    days = Integer.parseInt(m.group(4));
                }
                if (m.group(5) != null && !m.group(5).isEmpty())
                {
                    hours = Integer.parseInt(m.group(5));
                }
                if (m.group(6) != null && !m.group(6).isEmpty())
                {
                    minutes = Integer.parseInt(m.group(6));
                }
                if (m.group(7) != null && !m.group(7).isEmpty())
                {
                    seconds = Integer.parseInt(m.group(7));
                }
                break;
            }
        }
        if (!found)
        {
            return null;
        }

        Calendar c = new GregorianCalendar();

        if (years > 0)
        {
            c.add(Calendar.YEAR, years);
        }
        if (months > 0)
        {
            c.add(Calendar.MONTH, months);
        }
        if (weeks > 0)
        {
            c.add(Calendar.WEEK_OF_YEAR, weeks);
        }
        if (days > 0)
        {
            c.add(Calendar.DAY_OF_MONTH, days);
        }
        if (hours > 0)
        {
            c.add(Calendar.HOUR_OF_DAY, hours);
        }
        if (minutes > 0)
        {
            c.add(Calendar.MINUTE, minutes);
        }
        if (seconds > 0)
        {
            c.add(Calendar.SECOND, seconds);
        }

        return c.getTime();
    }

    public static String playerListToNames(Set<OfflinePlayer> players)
    {
        List<String> names = new ArrayList<>();
        for (OfflinePlayer player : players)
        {
            names.add(player.getName());
        }
        return StringUtils.join(names, ", ");
    }

    public static String dateToString(Date date)
    {
        return new SimpleDateFormat(DATE_STORAGE_FORMAT, Locale.ENGLISH).format(date);
    }

    public static Date stringToDate(String dateString)
    {
        try
        {
            return new SimpleDateFormat(DATE_STORAGE_FORMAT, Locale.ENGLISH).parse(dateString);
        }
        catch (ParseException pex)
        {
            return new Date(0L);
        }
    }

    public static boolean isFromHostConsole(String senderName)
    {
        return ConfigEntry.HOST_SENDER_NAMES.getList().contains(senderName.toLowerCase());
    }

    public static boolean fuzzyIpMatch(String a, String b, int octets)
    {
        boolean match = true;

        String[] aParts = a.split("\\.");
        String[] bParts = b.split("\\.");

        if (aParts.length != 4 || bParts.length != 4)
        {
            return false;
        }

        if (octets > 4)
        {
            octets = 4;
        }
        else if (octets < 1)
        {
            octets = 1;
        }

        for (int i = 0; i < octets && i < 4; i++)
        {
            if (aParts[i].equals("*") || bParts[i].equals("*"))
            {
                continue;
            }

            if (!aParts[i].equals(bParts[i]))
            {
                match = false;
                break;
            }
        }

        return match;
    }

    public static String getFuzzyIp(String ip)
    {
        final String[] ipParts = ip.split("\\.");
        if (ipParts.length == 4)
        {
            return String.format("%s.%s.*.*", ipParts[0], ipParts[1]);
        }

        return ip;
    }

    //getField: Borrowed from WorldEdit
    @SuppressWarnings("unchecked")
    public static <T> T getField(Object from, String name)
    {
        Class<?> checkClass = from.getClass();
        do
        {
            try
            {
                Field field = checkClass.getDeclaredField(name);
                field.setAccessible(true);
<<<<<<< HEAD
                return (T)field.get(from);
=======
                return (T) field.get(from);
>>>>>>> devel

            }
            catch (NoSuchFieldException | IllegalAccessException ex)
            {
            }
<<<<<<< HEAD
        }
        while (checkClass.getSuperclass() != Object.class
=======
        } while (checkClass.getSuperclass() != Object.class
>>>>>>> devel
                && ((checkClass = checkClass.getSuperclass()) != null));

        return null;
    }

    public static ChatColor randomChatColor()
    {
        return CHAT_COLOR_POOL.get(RANDOM.nextInt(CHAT_COLOR_POOL.size()));
    }

<<<<<<< HEAD
    public static String rainbowify(String string)
    {
        CHAT_COLOR_ITERATOR = CHAT_COLOR_POOL.iterator();

        StringBuilder newString = new StringBuilder();
        char[] chars = string.toCharArray();

        for (char c : chars)
        {
            if (!CHAT_COLOR_ITERATOR.hasNext())
            {
                CHAT_COLOR_ITERATOR = CHAT_COLOR_POOL.iterator(); //Restart from first colour if there are no more colours in iterator.
            }
            newString.append(CHAT_COLOR_ITERATOR.next()).append(c);
        }

        return newString.toString();
    }

=======
>>>>>>> devel
    public static String colorize(String string)
    {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static Date getUnixDate(long unix)
    {
        return new Date(unix * 1000);
    }

    public static long getUnixTime()
    {
        return System.currentTimeMillis() / 1000L;
    }

    public static long getUnixTime(Date date)
    {
        if (date == null)
        {
            return 0;
        }

        return date.getTime() / 1000L;
    }

<<<<<<< HEAD
    public static String getNMSVersion()
    {
        return Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
    }

    public static int random(int min, int max)
    {
        int range = max - min + 1;
        int value = (int)(Math.random() * range) + min;
        return value;
    }
=======
    public static String getNmsVersion()
    {
        String packageName = Bukkit.getServer().getClass().getPackage().getName();
        return packageName.substring(packageName.lastIndexOf('.') + 1);
    }

>>>>>>> devel
}
