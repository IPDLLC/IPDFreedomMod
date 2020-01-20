package me.totalfreedom.totalfreedommod.rank;

import lombok.Getter;
import org.bukkit.ChatColor;

public enum Rank implements Displayable
{

    IMPOSTOR("an", "Impostor", Type.PLAYER, ChatColor.BLACK, "Imp"),
    NON_OP("a", "Non-Op", Type.PLAYER, ChatColor.DARK_GRAY, ""),
    OP("an", "Op", Type.PLAYER, ChatColor.GRAY, "OP"),
    MODERATOR("a", "Moderator", Type.ADMIN, ChatColor.DARK_PURPLE, "§oMod§5"),
    SUPER_ADMIN("a", "Super Admin", Type.ADMIN, ChatColor.RED, "Admin"),
    TELNET_ADMIN("a", "Telnet Admin", Type.ADMIN, ChatColor.DARK_GREEN, "§oTelnet §c§oAdmin§2"),
    TELNET_CLAN_ADMIN("a", "Telnet Clan Admin", Type.ADMIN, ChatColor.GREEN, "§oClan §c§oAdmin§a"),
    SENIOR_ADMIN("a", "Senior Admin", Type.ADMIN, ChatColor.GOLD, "§oSenior §c§oAdmin§6"),
    TELNET_CONSOLE("the", "Console", Type.ADMIN_CONSOLE, ChatColor.DARK_GREEN, "Console"),
    TELNET_CLAN_CONSOLE("the", "Console", Type.ADMIN_CONSOLE, ChatColor.GREEN, "Console"),
    SENIOR_CONSOLE("the", "Console", Type.ADMIN_CONSOLE, ChatColor.GOLD, "Console"),
    SYSTEM_ADMIN("a", "System Administrator", Type.ADMIN, ChatColor.DARK_BLUE, "System Admin"),
    SYS_CONSOLE("the", "Console", Type.ADMIN_CONSOLE, ChatColor.DARK_BLUE, "Console");
    @Getter
    private final Type type;
    @Getter
    private final String name;
    @Getter
    private final String abbr;
    private final String determiner;
    @Getter
    private final String tag;
    @Getter
    private final String coloredTag;
    @Getter
    private final ChatColor color;

    private Rank(String determiner, String name, Type type, ChatColor color, String abbr)
    {
        this.type = type;
        this.name = name;
        this.abbr = abbr;
        this.determiner = determiner;
        this.tag = abbr.isEmpty() ? "" : "[" + abbr + "]";
        this.coloredTag = abbr.isEmpty() ? "" : ChatColor.DARK_GRAY + "[" + color + abbr + ChatColor.DARK_GRAY + "]" + color;
        this.color = color;
    }

    public static Rank findRank(String string)
    {
        try
        {
            return Rank.valueOf(string.toUpperCase());
        }
        catch (Exception ignored)
        {
        }

        return Rank.NON_OP;
    }

    @Override
    public String getColoredName()
    {
        return color + name;
    }

    @Override
    public String getColoredLoginMessage()
    {
        return determiner + " " + color + ChatColor.ITALIC + name;
    }

    @Override
    public String getAbbr()
    {
        return abbr;
    }

    public boolean isConsole()
    {
        return getType() == Type.ADMIN_CONSOLE;
    }

    public int getLevel()
    {
        return ordinal();
    }

    public boolean isAtLeast(Rank rank)
    {
        if (getLevel() < rank.getLevel())
        {
            return false;
        }

        if (!hasConsoleVariant() || !rank.hasConsoleVariant())
        {
            return true;
        }

        return getConsoleVariant().getLevel() >= rank.getConsoleVariant().getLevel();
    }

    public boolean isAdmin()
    {
        return getType() == Type.ADMIN || getType() == Type.ADMIN_CONSOLE;
    }

    public boolean hasConsoleVariant()
    {
        return getConsoleVariant() != null;
    }

    public Rank getConsoleVariant()
    {
        switch (this)
        {
            case TELNET_ADMIN:
            case TELNET_CONSOLE:
                return TELNET_CONSOLE;
            case TELNET_CLAN_ADMIN:
            case TELNET_CLAN_CONSOLE:
                return TELNET_CLAN_CONSOLE;
            case SENIOR_ADMIN:
            case SENIOR_CONSOLE:
                return SENIOR_CONSOLE;
            case SYSTEM_ADMIN:
            case SYS_CONSOLE:
                return SYS_CONSOLE;
            default:
                return null;
        }
    }

    public static enum Type
    {

        PLAYER,
        ADMIN,
        ADMIN_CONSOLE;

        public boolean isAdmin()
        {
            return this != PLAYER;
        }
    }

}
