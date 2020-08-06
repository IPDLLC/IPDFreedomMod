package me.totalfreedom.totalfreedommod;

<<<<<<< HEAD
import java.io.File;
import java.io.InputStream;
import java.util.Properties;
import me.totalfreedom.totalfreedommod.admin.AdminList;
import me.totalfreedom.totalfreedommod.amp.AMP;
import me.totalfreedom.totalfreedommod.banning.BanManager;
import me.totalfreedom.totalfreedommod.banning.PermbanList;
import me.totalfreedom.totalfreedommod.blocking.BlockBlocker;
import me.totalfreedom.totalfreedommod.blocking.EditBlocker;
import me.totalfreedom.totalfreedommod.blocking.EventBlocker;
import me.totalfreedom.totalfreedommod.blocking.InteractBlocker;
import me.totalfreedom.totalfreedommod.blocking.MobBlocker;
import me.totalfreedom.totalfreedommod.blocking.PVPBlocker;
import me.totalfreedom.totalfreedommod.blocking.PotionBlocker;
import me.totalfreedom.totalfreedommod.blocking.SignBlocker;
import me.totalfreedom.totalfreedommod.blocking.command.CommandBlocker;
import me.totalfreedom.totalfreedommod.bridge.BukkitTelnetBridge;
import me.totalfreedom.totalfreedommod.bridge.CoreProtectBridge;
import me.totalfreedom.totalfreedommod.bridge.EssentialsBridge;
import me.totalfreedom.totalfreedommod.bridge.LibsDisguisesBridge;
import me.totalfreedom.totalfreedommod.bridge.WorldEditBridge;
import me.totalfreedom.totalfreedommod.bridge.WorldGuardBridge;
import me.totalfreedom.totalfreedommod.caging.Cager;
import me.totalfreedom.totalfreedommod.command.CommandLoader;
import me.totalfreedom.totalfreedommod.config.MainConfig;
import me.totalfreedom.totalfreedommod.discord.Discord;
=======
import me.totalfreedom.totalfreedommod.fun.Trailer;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import me.totalfreedom.totalfreedommod.admin.AdminList;
import me.totalfreedom.totalfreedommod.banning.BanManager;
import me.totalfreedom.totalfreedommod.banning.PermbanList;
import me.totalfreedom.totalfreedommod.blocking.BlockBlocker;
import me.totalfreedom.totalfreedommod.blocking.EventBlocker;
import me.totalfreedom.totalfreedommod.blocking.InteractBlocker;
import me.totalfreedom.totalfreedommod.blocking.MobBlocker;
import me.totalfreedom.totalfreedommod.blocking.PotionBlocker;
import me.totalfreedom.totalfreedommod.blocking.command.CommandBlocker;
import me.totalfreedom.totalfreedommod.bridge.BukkitTelnetBridge;
import me.totalfreedom.totalfreedommod.bridge.EssentialsBridge;
import me.totalfreedom.totalfreedommod.bridge.LibsDisguisesBridge;
import me.totalfreedom.totalfreedommod.bridge.WorldEditBridge;
import me.totalfreedom.totalfreedommod.caging.Cager;
import me.totalfreedom.totalfreedommod.command.CommandLoader;
import me.totalfreedom.totalfreedommod.config.MainConfig;
>>>>>>> devel
import me.totalfreedom.totalfreedommod.freeze.Freezer;
import me.totalfreedom.totalfreedommod.fun.ItemFun;
import me.totalfreedom.totalfreedommod.fun.Jumppads;
import me.totalfreedom.totalfreedommod.fun.Landminer;
import me.totalfreedom.totalfreedommod.fun.MP44;
<<<<<<< HEAD
import me.totalfreedom.totalfreedommod.fun.MobStacker;
import me.totalfreedom.totalfreedommod.fun.Trailer;
import me.totalfreedom.totalfreedommod.httpd.HTTPDaemon;
import me.totalfreedom.totalfreedommod.masterbuilder.MasterBuilder;
import me.totalfreedom.totalfreedommod.masterbuilder.MasterBuilderList;
import me.totalfreedom.totalfreedommod.masterbuilder.MasterBuilderWorldRestrictions;
import me.totalfreedom.totalfreedommod.player.PlayerList;
import me.totalfreedom.totalfreedommod.playerverification.PlayerVerification;
import me.totalfreedom.totalfreedommod.punishments.PunishmentList;
import me.totalfreedom.totalfreedommod.rank.RankManager;
import me.totalfreedom.totalfreedommod.reporting.ReportList;
=======
import me.totalfreedom.totalfreedommod.httpd.HTTPDaemon;
import me.totalfreedom.totalfreedommod.player.PlayerList;
import me.totalfreedom.totalfreedommod.rank.RankManager;
>>>>>>> devel
import me.totalfreedom.totalfreedommod.rollback.RollbackManager;
import me.totalfreedom.totalfreedommod.util.FLog;
import me.totalfreedom.totalfreedommod.util.FUtil;
import me.totalfreedom.totalfreedommod.util.MethodTimer;
<<<<<<< HEAD
import me.totalfreedom.totalfreedommod.world.CleanroomChunkGenerator;
import me.totalfreedom.totalfreedommod.world.WorldManager;
import net.pravian.aero.component.service.ServiceManager;
import net.pravian.aero.plugin.AeroPlugin;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.spigotmc.SpigotConfig;

public class TotalFreedomMod extends AeroPlugin<TotalFreedomMod>
{
=======
import me.totalfreedom.totalfreedommod.world.WorldManager;
import net.pravian.aero.component.service.ServiceManager;
import net.pravian.aero.plugin.AeroPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.mcstats.Metrics;

public class TotalFreedomMod extends AeroPlugin<TotalFreedomMod>
{

>>>>>>> devel
    public static final String CONFIG_FILENAME = "config.yml";
    //
    public static final BuildProperties build = new BuildProperties();
    //
    public static String pluginName;
    public static String pluginVersion;
    //
    public MainConfig config;
    //
    // Services
    public ServiceManager<TotalFreedomMod> services;
<<<<<<< HEAD
    public AdminList al;
    public Announcer an;
    public AntiNuke nu;
    public AntiSpam as;
    public AutoEject ae;
    public AutoKick ak;
    public BanManager bm;
    public BlockBlocker bb;
    public Cager ca;
    public ChatManager cm;
    public CommandBlocker cb;
    public CommandLoader cl;
    public CommandSpy cs;
    public Discord dc;
    public EditBlocker ebl;
    public EntityWiper ew;
    public EventBlocker eb;
    public Freezer fm;
    public FrontDoor fd;
    public Fuckoff fo;
    public GameRuleHandler gr;
    public HTTPDaemon hd;
    public InteractBlocker ib;
    public ItemFun it;
    public Jumppads jp;
    public Landminer lm;
    public LogViewer lv;
    public LoginProcess lp;
    public MP44 mp;
    public MasterBuilderList mbl;
    public MasterBuilderWorldRestrictions mbwr;
    public MobBlocker mb;
    public MobStacker ms;
    public Monitors mo;
    public MovementValidator mv;
    public Muter mu;
    public Orbiter or;
    public PVPBlocker pbl;
    public PermbanList pm;
    public PlayerList pl;
    public PlayerVerification pv;
    public PotionBlocker pb;
    public ProtectArea pa;
    public PunishmentList pul;
    public RankManager rm;
    public ReportList rel;
    public RollbackManager rb;
    public SavedFlags sf;
    public ServerInterface si;
    public ServerPing sp;
    public SignBlocker sb;
    public Trailer tr;
    public WorldManager wm;
    //
    // Bridges
    public ServiceManager<TotalFreedomMod> bridges;
    public AMP amp;
    public BukkitTelnetBridge btb;
    public CoreProtectBridge cpb;
    public EssentialsBridge esb;
    public LibsDisguisesBridge ldb;
    public WorldEditBridge web;
    public WorldGuardBridge wgb;

    public static TotalFreedomMod plugin()
    {
        for (Plugin plugin : Bukkit.getPluginManager().getPlugins())
        {
            if (plugin.getName().equalsIgnoreCase(pluginName))
            {
                return (TotalFreedomMod)plugin;
            }
        }
        return null;
    }
=======
    public ServerInterface si;
    public SavedFlags sf;
    public WorldManager wm;
    public LogViewer lv;
    public AdminList al;
    public RankManager rm;
    public CommandLoader cl;
    public CommandBlocker cb;
    public EventBlocker eb;
    public BlockBlocker bb;
    public MobBlocker mb;
    public InteractBlocker ib;
    public PotionBlocker pb;
    public LoginProcess lp;
    public AntiNuke nu;
    public AntiSpam as;
    public PlayerList pl;
    public Announcer an;
    public ChatManager cm;
    public BanManager bm;
    public PermbanList pm;
    public ProtectArea pa;
    public GameRuleHandler gr;
    public RollbackManager rb;
    public CommandSpy cs;
    public Cager ca;
    public Freezer fm;
    public Orbiter or;
    public Muter mu;
    public Fuckoff fo;
    public AutoKick ak;
    public AutoEject ae;
    public MovementValidator mv;
    public EntityWiper ew;
    public FrontDoor fd;
    public ServerPing sp;
    public ItemFun it;
    public Landminer lm;
    public MP44 mp;
    public Jumppads jp;
    public Trailer tr;
    public HTTPDaemon hd;
    //
    // Bridges
    public ServiceManager<TotalFreedomMod> bridges;
    public BukkitTelnetBridge btb;
    public EssentialsBridge esb;
    public LibsDisguisesBridge ldb;
    public WorldEditBridge web;
>>>>>>> devel

    @Override
    public void load()
    {
        TotalFreedomMod.pluginName = plugin.getDescription().getName();
        TotalFreedomMod.pluginVersion = plugin.getDescription().getVersion();

        FLog.setPluginLogger(plugin.getLogger());
        FLog.setServerLogger(server.getLogger());

        build.load(plugin);
    }

    @Override
    public void enable()
    {
        FLog.info("Created by Madgeek1450 and Prozza");
<<<<<<< HEAD
        FLog.info("Version " + build.version);
=======
        FLog.info("Version " + build.formattedVersion());
>>>>>>> devel
        FLog.info("Compiled " + build.date + " by " + build.author);

        final MethodTimer timer = new MethodTimer();
        timer.start();

        // Warn if we're running on a wrong version
        ServerInterface.warnVersion();

        // Delete unused files
        FUtil.deleteCoreDumps();
        FUtil.deleteFolder(new File("./_deleteme"));

        // Convert old config files
        new ConfigConverter(plugin).convert();

        BackupManager backups = new BackupManager(this);
        backups.createBackups(TotalFreedomMod.CONFIG_FILENAME, true);
        backups.createBackups(AdminList.CONFIG_FILENAME);
        backups.createBackups(PermbanList.CONFIG_FILENAME);
<<<<<<< HEAD
        backups.createBackups(MasterBuilder.CONFIG_FILENAME);
        backups.createBackups(PunishmentList.CONFIG_FILENAME);
        backups.createBackups(ReportList.CONFIG_FILENAME);
=======
>>>>>>> devel

        config = new MainConfig(this);
        config.load();

        // Start services
        services = new ServiceManager<>(plugin);
<<<<<<< HEAD
        al = services.registerService(AdminList.class);
        as = services.registerService(AntiSpam.class);
        bb = services.registerService(BlockBlocker.class);
        cb = services.registerService(CommandBlocker.class);
        cl = services.registerService(CommandLoader.class);
        eb = services.registerService(EventBlocker.class);
        fd = services.registerService(FrontDoor.class);
        ib = services.registerService(InteractBlocker.class);
        lp = services.registerService(LoginProcess.class);
        lv = services.registerService(LogViewer.class);
        mb = services.registerService(MobBlocker.class);
        mbl = services.registerService(MasterBuilderList.class);
        mbwr = services.registerService(MasterBuilderWorldRestrictions.class);
        nu = services.registerService(AntiNuke.class);
        pb = services.registerService(PotionBlocker.class);
        rm = services.registerService(RankManager.class);
        sf = services.registerService(SavedFlags.class);
        si = services.registerService(ServerInterface.class);
        wm = services.registerService(WorldManager.class);

        an = services.registerService(Announcer.class);
        bm = services.registerService(BanManager.class);
        cm = services.registerService(ChatManager.class);
        dc = services.registerService(Discord.class);
        gr = services.registerService(GameRuleHandler.class);
        pa = services.registerService(ProtectArea.class);
        pl = services.registerService(PlayerList.class);
        pm = services.registerService(PermbanList.class);
        pul = services.registerService(PunishmentList.class);
        rel = services.registerService(ReportList.class);
        sb = services.registerService(SignBlocker.class);

        // Single admin utils
        ae = services.registerService(AutoEject.class);
        ak = services.registerService(AutoKick.class);
        ca = services.registerService(Cager.class);
        cs = services.registerService(CommandSpy.class);
        ebl = services.registerService(EditBlocker.class);
        ew = services.registerService(EntityWiper.class);
        fm = services.registerService(Freezer.class);
        fo = services.registerService(Fuckoff.class);
        mo = services.registerService(Monitors.class);
        mu = services.registerService(Muter.class);
        mv = services.registerService(MovementValidator.class);
        or = services.registerService(Orbiter.class);
        pbl = services.registerService(PVPBlocker.class);
        pv = services.registerService(PlayerVerification.class);
        rb = services.registerService(RollbackManager.class);
=======
        si = services.registerService(ServerInterface.class);
        sf = services.registerService(SavedFlags.class);
        wm = services.registerService(WorldManager.class);
        lv = services.registerService(LogViewer.class);
        al = services.registerService(AdminList.class);
        rm = services.registerService(RankManager.class);
        cl = services.registerService(CommandLoader.class);
        cb = services.registerService(CommandBlocker.class);
        eb = services.registerService(EventBlocker.class);
        bb = services.registerService(BlockBlocker.class);
        mb = services.registerService(MobBlocker.class);
        ib = services.registerService(InteractBlocker.class);
        pb = services.registerService(PotionBlocker.class);
        lp = services.registerService(LoginProcess.class);
        nu = services.registerService(AntiNuke.class);
        as = services.registerService(AntiSpam.class);

        pl = services.registerService(PlayerList.class);
        an = services.registerService(Announcer.class);
        cm = services.registerService(ChatManager.class);
        bm = services.registerService(BanManager.class);
        pm = services.registerService(PermbanList.class);
        pa = services.registerService(ProtectArea.class);
        gr = services.registerService(GameRuleHandler.class);

        // Single admin utils
        rb = services.registerService(RollbackManager.class);
        cs = services.registerService(CommandSpy.class);
        ca = services.registerService(Cager.class);
        fm = services.registerService(Freezer.class);
        or = services.registerService(Orbiter.class);
        mu = services.registerService(Muter.class);
        fo = services.registerService(Fuckoff.class);
        ak = services.registerService(AutoKick.class);
        ae = services.registerService(AutoEject.class);

        mv = services.registerService(MovementValidator.class);
        ew = services.registerService(EntityWiper.class);
        fd = services.registerService(FrontDoor.class);
>>>>>>> devel
        sp = services.registerService(ServerPing.class);

        // Fun
        it = services.registerService(ItemFun.class);
<<<<<<< HEAD
        jp = services.registerService(Jumppads.class);
        lm = services.registerService(Landminer.class);
        mp = services.registerService(MP44.class);
        ms = services.registerService(MobStacker.class);
=======
        lm = services.registerService(Landminer.class);
        mp = services.registerService(MP44.class);
        jp = services.registerService(Jumppads.class);
>>>>>>> devel
        tr = services.registerService(Trailer.class);

        // HTTPD
        hd = services.registerService(HTTPDaemon.class);
        services.start();

        // Start bridges
        bridges = new ServiceManager<>(plugin);
<<<<<<< HEAD
        amp = bridges.registerService(AMP.class);
        btb = bridges.registerService(BukkitTelnetBridge.class);
        cpb = bridges.registerService(CoreProtectBridge.class);
        esb = bridges.registerService(EssentialsBridge.class);
        ldb = bridges.registerService(LibsDisguisesBridge.class);
        web = bridges.registerService(WorldEditBridge.class);
        wgb = bridges.registerService(WorldGuardBridge.class);
        bridges.start();

        timer.update();
        ServerInterface.warnJavaVersion();
        FLog.info("Version " + pluginVersion + " for " + ServerInterface.COMPILE_NMS_VERSION + " enabled in " + timer.getTotal() + "ms");

        // Metrics @ https://bstats.org/plugin/bukkit/TotalFreedomMod
        Metrics metrics = new Metrics(this);
=======
        btb = bridges.registerService(BukkitTelnetBridge.class);
        esb = bridges.registerService(EssentialsBridge.class);
        ldb = bridges.registerService(LibsDisguisesBridge.class);
        web = bridges.registerService(WorldEditBridge.class);
        bridges.start();

        timer.update();
        FLog.info("Version " + pluginVersion + " for " + ServerInterface.COMPILE_NMS_VERSION + " enabled in " + timer.getTotal() + "ms");

        // Metrics @ http://mcstats.org/plugin/TotalFreedomMod
        try
        {
            final Metrics metrics = new Metrics(plugin);
            metrics.start();
        }
        catch (IOException ex)
        {
            FLog.warning("Failed to submit metrics data: " + ex.getMessage());
        }
>>>>>>> devel

        // Add spawnpoints later - https://github.com/TotalFreedom/TotalFreedomMod/issues/438
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                plugin.pa.autoAddSpawnpoints();
            }
        }.runTaskLater(plugin, 60L);
<<<<<<< HEAD
        // little workaround to stop spigot from autorestarting - causing AMP to detach from process.
        SpigotConfig.config.set("settings.restart-on-crash", false);
=======
>>>>>>> devel
    }

    @Override
    public void disable()
    {
        // Stop services and bridges
        bridges.stop();
        services.stop();

        server.getScheduler().cancelTasks(plugin);

        FLog.info("Plugin disabled");
    }

<<<<<<< HEAD
    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id)
    {
        return new CleanroomChunkGenerator(id);
    }

    public static class BuildProperties
    {
=======
    public static class BuildProperties
    {

>>>>>>> devel
        public String author;
        public String codename;
        public String version;
        public String number;
        public String date;
        public String head;

        public void load(TotalFreedomMod plugin)
        {
            try
            {
                final Properties props;
<<<<<<< HEAD

=======
                final Properties gitprops;
>>>>>>> devel
                try (InputStream in = plugin.getResource("build.properties"))
                {
                    props = new Properties();
                    props.load(in);
                }
<<<<<<< HEAD
=======
                try (InputStream in = plugin.getResource("git.properties"))
                {
                    gitprops = new Properties();
                    gitprops.load(in);
                }
>>>>>>> devel

                author = props.getProperty("buildAuthor", "unknown");
                codename = props.getProperty("buildCodeName", "unknown");
                version = props.getProperty("buildVersion", pluginVersion);
                number = props.getProperty("buildNumber", "1");
<<<<<<< HEAD
                date = props.getProperty("buildDate", "unknown");
                // Need to do this or it will display ${git.commit.id.abbrev}
                head = props.getProperty("buildHead", "unknown").replace("${git.commit.id.abbrev}", "unknown");
            }
            catch (Exception ex)
            {
                FLog.severe("Could not load build properties! Did you compile with NetBeans/Maven?");
=======
                date = gitprops.getProperty("git.build.time", "unknown");
                head = gitprops.getProperty("git.commit.id.abbrev", "unknown");
                
                
                
            }
            catch (Exception ex)
            {
                FLog.severe("Could not load build properties! Did you compile with Netbeans/Maven?");
>>>>>>> devel
                FLog.severe(ex);
            }
        }

        public String formattedVersion()
        {
            return pluginVersion + "." + number + " (" + head + ")";
        }
    }
<<<<<<< HEAD
=======

    public static TotalFreedomMod plugin()
    {
        for (Plugin plugin : Bukkit.getPluginManager().getPlugins())
        {
            if (plugin.getName().equalsIgnoreCase(pluginName))
            {
                return (TotalFreedomMod) plugin;
            }
        }
        return null;
    }

>>>>>>> devel
}
