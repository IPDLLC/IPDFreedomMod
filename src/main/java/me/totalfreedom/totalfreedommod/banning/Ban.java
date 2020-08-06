package me.totalfreedom.totalfreedommod.banning;

import com.google.common.collect.Lists;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
<<<<<<< HEAD
=======
import java.util.Iterator;
>>>>>>> devel
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import me.totalfreedom.totalfreedommod.config.ConfigEntry;
import me.totalfreedom.totalfreedommod.util.FUtil;
import net.pravian.aero.base.ConfigLoadable;
import net.pravian.aero.base.ConfigSavable;
import net.pravian.aero.base.Validatable;
import net.pravian.aero.util.Ips;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

public class Ban implements ConfigLoadable, ConfigSavable, Validatable
{
<<<<<<< HEAD
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd \'at\' HH:mm:ss z");
    @Getter
    private final List<String> ips = Lists.newArrayList();
=======

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd \'at\' HH:mm:ss z");

>>>>>>> devel
    @Getter
    @Setter
    private String username = null;
    @Getter
<<<<<<< HEAD
=======
    private final List<String> ips = Lists.newArrayList();
    @Getter
>>>>>>> devel
    @Setter
    private String by = null;
    @Getter
    @Setter
    private String reason = null; // Unformatted, &[0-9,a-f] instead of ChatColor
    @Getter
    @Setter
    private long expiryUnix = -1;

    public Ban()
    {
    }

    public Ban(String username, String ip, String by, Date expire, String reason)
    {
        this(username,
                new String[]
<<<<<<< HEAD
                        {
                                ip
                        },
=======
                {
                    ip
                },
>>>>>>> devel
                by,
                expire,
                reason);
    }

    public Ban(String username, String[] ips, String by, Date expire, String reason)
    {
        this.username = username;
        if (ips != null)
        {
            this.ips.addAll(Arrays.asList(ips));
        }
        dedupeIps();
        this.by = by;
        this.expiryUnix = FUtil.getUnixTime(expire);
        this.reason = reason;
    }

<<<<<<< HEAD
=======
    //
>>>>>>> devel
    // For player IP
    public static Ban forPlayerIp(Player player, CommandSender by)
    {
        return forPlayerIp(player, by, null, null);
    }

    public static Ban forPlayerIp(Player player, CommandSender by, Date expiry, String reason)
    {
        return new Ban(null, new String[]
<<<<<<< HEAD
                {
                        Ips.getIp(player)
                }, by.getName(), expiry, reason);
=======
        {
            Ips.getIp(player)
        }, by.getName(), expiry, reason);
>>>>>>> devel
    }

    public static Ban forPlayerIp(String ip, CommandSender by, Date expiry, String reason)
    {
        return new Ban(null, ip, by.getName(), expiry, reason);
    }

    //
    // For player name
    public static Ban forPlayerName(Player player, CommandSender by, Date expiry, String reason)
    {
        return forPlayerName(player.getName(), by, expiry, reason);
    }

    public static Ban forPlayerName(String player, CommandSender by, Date expiry, String reason)
    {
        return new Ban(player,
<<<<<<< HEAD
                (String[])null,
=======
                (String[]) null,
>>>>>>> devel
                by.getName(),
                expiry,
                reason);
    }

<<<<<<< HEAD
=======
    //
>>>>>>> devel
    // For player
    public static Ban forPlayer(Player player, CommandSender by)
    {
        return forPlayerName(player, by, null, null);
    }

    public static Ban forPlayer(Player player, CommandSender by, Date expiry, String reason)
    {
        return new Ban(player.getName(),
                Ips.getIp(player),
                by.getName(),
                expiry,
                reason);
    }

    public static Ban forPlayerFuzzy(Player player, CommandSender by, Date expiry, String reason)
    {
        return new Ban(player.getName(),
                FUtil.getFuzzyIp(Ips.getIp(player)),
                by.getName(),
                expiry,
                reason);
    }

    public boolean hasUsername()
    {
        return username != null && !username.isEmpty();
    }

    public boolean addIp(String ip)
    {
        return ips.add(ip);
    }

    public boolean removeIp(String ip)
    {
        return ips.remove(ip);
    }

    public boolean hasIps()
    {
        return !ips.isEmpty();
    }

    public boolean hasExpiry()
    {
        return expiryUnix > 0;
    }

<<<<<<< HEAD
=======
    public Date getExpiryDate()
    {
        return FUtil.getUnixDate(expiryUnix);
    }

>>>>>>> devel
    public boolean isExpired()
    {
        return hasExpiry() && expiryUnix < FUtil.getUnixTime();
    }

    public String bakeKickMessage()
    {
        final StringBuilder message = new StringBuilder(ChatColor.GOLD + "You");

        message.append(!hasUsername() ? "r IP address is" : " are").append(" temporarily banned from this server.");
<<<<<<< HEAD
        message.append("\n If you feel your ban is unjustified. You may appeal on our forums for an unban.");
=======
>>>>>>> devel
        message.append("\nAppeal at ").append(ChatColor.BLUE)
                .append(ConfigEntry.SERVER_BAN_URL.getString());

        if (reason != null)
        {
            message.append("\n").append(ChatColor.RED).append("Reason: ").append(ChatColor.GOLD)
                    .append(ChatColor.translateAlternateColorCodes('&', reason));
        }

        if (by != null)
        {
            message.append("\n").append(ChatColor.RED).append("Banned by: ").append(ChatColor.GOLD)
                    .append(by);
        }

        if (getExpiryUnix() != 0)
        {
            message.append("\n").append(ChatColor.RED).append("Expires: ").append(ChatColor.GOLD)
                    .append(DATE_FORMAT.format(FUtil.getUnixDate(expiryUnix)));
        }

        return message.toString();
    }

    @Override
    public boolean equals(Object object)
    {
        if (object == null)
        {
            return false;
        }

        if (!(object instanceof Ban))
        {
            return false;
        }

<<<<<<< HEAD
        final Ban ban = (Ban)object;
        if (hasIps() != ban.hasIps()
                || hasUsername() != ban.hasUsername())
=======
        final Ban ban = (Ban) object;
        if (hasIps() != ban.hasIps()
                || hasUsername() != hasUsername())
>>>>>>> devel
        {
            return false;
        }

        if (hasIps() && !(getIps().equals(ban.getIps())))
        {
            return false;
        }

        return !(hasUsername() && !(getUsername().equalsIgnoreCase(ban.getUsername())));
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 79 * hash + (this.username != null ? this.username.toLowerCase().hashCode() : 0);
        hash = 79 * hash + (this.ips != null ? this.ips.hashCode() : 0);
        return hash;
    }

    @Override
    public void loadFrom(ConfigurationSection cs)
    {
        this.username = cs.getString("username", null);
        this.ips.clear();
        this.ips.addAll(cs.getStringList("ips"));
        this.by = cs.getString("by", null);
        this.reason = cs.getString("reason", null);
        this.expiryUnix = cs.getLong("expiry_unix", 0);
        dedupeIps();
    }

    @Override
    public void saveTo(ConfigurationSection cs)
    {
        dedupeIps();
        cs.set("username", username);
        cs.set("ips", ips.isEmpty() ? null : ips);
        cs.set("by", by);
        cs.set("reason", reason);
        cs.set("expiry_unix", expiryUnix > 0 ? expiryUnix : null);
    }

    @Override
    public boolean isValid()
    {
        return username != null || !ips.isEmpty();
    }

    private void dedupeIps()
    {
<<<<<<< HEAD
        Set<String> uniqueIps = new HashSet<>();
        ips.removeIf(s -> !uniqueIps.add(s));
=======

        Set<String> uniqueIps = new HashSet<>();

        Iterator<String> it = ips.iterator();
        while (it.hasNext())
        {
            if (!uniqueIps.add(it.next()))
            {
                it.remove();
            }
        }

>>>>>>> devel
    }
}
