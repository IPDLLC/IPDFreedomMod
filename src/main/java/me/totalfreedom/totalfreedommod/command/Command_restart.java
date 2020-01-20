package me.totalfreedom.totalfreedommod.command;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SYSTEM_ADMIN, source = SourceType.BOTH)
@CommandParameters(description = "Kicks everyone and restarts the server.", usage = "/<command>")
public class Command_restart extends FreedomCommand
{
    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        FUtil.bcastMsg("Server is going offline!", ChatColor.LIGHT_PURPLE);

        for (Player player : server.getOnlinePlayers())
        {
            player.kickPlayer("Server is restarting or has crashed, please reconnect in around 20 seconds.");
        }

        if (!plugin.amp.enabled)
        {
            restart();
            return true;
        }
        else
        {
            plugin.amp.restartServer();
            return true;
        }
    }

    // Doesn't start a new command line thing, but it does restart the server
    public void restart()
    {
        Runtime.getRuntime().addShutdownHook(new Thread(() ->
        {
            List<String> args = ManagementFactory.getRuntimeMXBean().getInputArguments();
            List<String> command = new ArrayList<>();
            command.add("java");
            command.addAll(args);
            command.add("-jar");
            command.add(new File(Bukkit.class.getProtectionDomain().getCodeSource().getLocation().getFile()).getAbsolutePath());
            try
            {
                new ProcessBuilder(command).start();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }));
        Bukkit.shutdown();
    }
}