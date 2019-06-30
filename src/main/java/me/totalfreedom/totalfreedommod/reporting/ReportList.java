package me.totalfreedom.totalfreedommod.reporting;

import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import me.totalfreedom.totalfreedommod.FreedomService;
import me.totalfreedom.totalfreedommod.TotalFreedomMod;
import me.totalfreedom.totalfreedommod.util.FLog;
import net.pravian.aero.config.YamlConfig;

public class ReportList extends FreedomService
{
    public static final String CONFIG_FILENAME = "reports.yml";
    private final Set<Report> reports = Sets.newHashSet();
    //
    private final YamlConfig config;

    public ReportList(TotalFreedomMod plugin)
    {
        super(plugin);
        this.config = new YamlConfig(plugin, CONFIG_FILENAME);
    }

    @Override
    protected void onStart()
    {
        config.load();

        reports.clear();
        for (String id : config.getKeys(false))
        {
            if (!config.isConfigurationSection(id))
            {
                FLog.warning("Failed to load report number " + id + "!");
                continue;
            }

            Report report = new Report();
            report.loadFrom(config.getConfigurationSection(id));

            if (!report.isValid())
            {
                FLog.warning("Not adding report number " + id + ". Missing information.");
                continue;
            }

            reports.add(report);
        }

        FLog.info("Loaded " + reports.size() + " reports.");
    }

    @Override
    protected void onStop()
    {
        saveAll();
        logger.info("Saved " + reports.size() + " reports.");
    }

    public void saveAll()
    {
        config.clear();

        for (Report report : reports)
        {
            report.saveTo(config.createSection(String.valueOf(report.hashCode())));
        }

        // Save config
        config.save();
    }

    public int clear()
    {
        int removed = reports.size();
        reports.clear();
        config.clear();
        config.save();

        return removed;
    }

    public int clear(String username)
    {
        List<Report> removed = new ArrayList<>();

        for (Report report : reports)
        {
            if (report.getUsername().equalsIgnoreCase(username))
            {
                removed.add(report);
            }
        }

        if (removed.size() != 0)
        {
            reports.removeAll(removed);
            saveAll();
        }

        return removed.size();
    }

    public int getLastReportID()
    {
        int size = reports.size();

        if (size == 0)
        {
            return 1;
        }

        return size;
    }

    public boolean logReport(Report report)
    {
        if (reports.add(report))
        {
            saveAll();
            return true;
        }
        return false;
    }
}
