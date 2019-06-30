package me.totalfreedom.totalfreedommod.reporting;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import net.pravian.aero.base.ConfigLoadable;
import net.pravian.aero.base.ConfigSavable;
import net.pravian.aero.base.Validatable;
import org.bukkit.configuration.ConfigurationSection;

public class Report implements ConfigLoadable, ConfigSavable, Validatable
{
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd \'at\' HH:mm:ss z");

    @Getter
    @Setter
    private String username = null;
    @Getter
    private String ip = null;
    @Getter
    @Setter
    private String by = null;
    @Getter
    @Setter
    private String reason = null;
    @Getter
    @Setter
    private String location = null;
    @Getter
    @Setter
    private Date issued_on = null;

    public Report()
    {
    }

    public Report(String username, String ip, String by, String reason, String location)
    {
        this.username = username;
        this.ip = ip;
        this.by = by;
        this.reason = reason;
        this.location = location;
        this.issued_on = new Date();
    }

    @Override
    public void loadFrom(ConfigurationSection cs)
    {
        this.username = cs.getString("username", null);
        this.ip = cs.getString("ip", null);
        this.by = cs.getString("by", null);
        this.reason = cs.getString("reason", null);
        this.location = cs.getString("location", null);
        try
        {
            this.issued_on = DATE_FORMAT.parse(cs.getString("issued_on", null));
        }
        catch (ParseException e)
        {
            this.issued_on = null;
        }
    }


    @Override
    public void saveTo(ConfigurationSection cs)
    {
        cs.set("username", username);
        cs.set("ip", ip);
        cs.set("by", by);
        cs.set("reason", reason);
        cs.set("location", location);
        cs.set("issued_on", DATE_FORMAT.format(issued_on));
    }

    @Override
    public boolean isValid()
    {
        return username != null || ip != null;
    }
}
