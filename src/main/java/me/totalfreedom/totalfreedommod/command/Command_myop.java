package me.totalfreedom.totalfreedommod.command;

import java.util.Random;
import me.totalfreedom.totalfreedommod.discord.Discord;
import me.totalfreedom.totalfreedommod.playerverification.VPlayer;
import me.totalfreedom.totalfreedommod.rank.Rank;
import net.pravian.aero.util.Ips;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.OP, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Manage your verification entry", usage = "/<command> <enable | disable [-unlink | -u] | clearips | status>", aliases = "playerverification,playerverify,pv")
public class Command_myop extends FreedomCommand
{
    @Override
    protected boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length < 1)
        {
            return false;
        }

        if (plugin.al.isAdmin(sender))
        {
            msg("This command is only for OP's.", ChatColor.RED);
            return true;
        }

        VPlayer data = plugin.pv.getVerificationPlayer(playerSender);

        switch (args[0].toLowerCase())
        {
            case "enable":
                if (!plugin.dc.enabled)
                {
                    msg("The Discord verification system is currently disabled.", ChatColor.RED);
                    return true;
                }

                if (data.getDiscordId() != null)
                {
                    if (data.getEnabled())
                    {
                        msg("Discord verification is already enabled for you.");
                        return true;
                    }
                    msg("Your Minecraft account is linked to a Discord account, just re-enabling verification");
                    data.setEnabled(true);
                    plugin.pv.saveVerificationData(data);
                    return true;
                }
                else
                {
                    msg("Your Minecraft account is not linked to a Discord account, let's set that up.");
                    if (Discord.PLAYER_LINK_CODES.containsValue(data))
                    {
                        msg("Your linking code is " + ChatColor.GREEN + Discord.getCodeForPlayer(data), ChatColor.AQUA);
                        msg("DM this code on Discord to: " + Discord.bot.getSelfUser().getName() + "#" + Discord.bot.getSelfUser().getDiscriminator());
                    }
                    else
                    {
                        String code = "";
                        Random random = new Random();
                        for (int i = 0; i < 5; i++)
                        {
                            code += random.nextInt(10);
                        }
                        Discord.PLAYER_LINK_CODES.put(code, data);
                        msg("Your linking code is " + ChatColor.GREEN + code, ChatColor.AQUA);
                        msg("DM this code on Discord to: " + Discord.bot.getSelfUser().getName() + "#" + Discord.bot.getSelfUser().getDiscriminator());
                    }
                    data.setEnabled(true);
                    plugin.pv.saveVerificationData(data);
                }

                return true;

            case "disable":
                if (args.length == 1)
                {
                    if (!data.getEnabled())
                    {
                        msg("Discord verification is already disabled for you.");
                        return true;
                    }
                    data.setEnabled(false);
                    plugin.pv.saveVerificationData(data);
                    msg("Disabled Discord verification.");
                    return true;
                }
                // They want to unlink it also
                if (args[1].equalsIgnoreCase("-unlink") || args[1].equalsIgnoreCase("-u"))
                {
                    if (data.getDiscordId() == null)
                    {
                        msg("Your Minecraft account is not linked to a Discord account.");
                        return true;
                    }
                    data.setDiscordId(null);
                    data.setEnabled(false);
                    plugin.pv.saveVerificationData(data);
                    msg("Your Minecraft account has been successfully unlinked from the Discord account.");
                    return true;
                }
                return false;

            case "clearips":
                if (args[0].equalsIgnoreCase("clearips"))
                {
                    int cleared = 0;
                    for (String ip : data.getIps())
                    {
                        if (!ip.equals(Ips.getIp(playerSender)))
                        {
                            data.removeIp(ip);
                            cleared++;
                        }
                    }

                    msg("Cleared all IP's except your current IP \"" + Ips.getIp(playerSender) + "\"");
                    msg("Cleared " + cleared + " IP's.");
                    plugin.pv.saveVerificationData(data);
                    return true;
                }

            case "status":
                boolean enabled = data.getEnabled();
                boolean specified = data.getDiscordId() != null;
                msg(ChatColor.GRAY + "You " + (enabled ? "do" : "do not") + " have Discord verification enabled.");
                msg(ChatColor.GRAY + "Your Discord ID is" + (specified ? ChatColor.GRAY + ": " + data.getDiscordId() : " not set."));
                return true;
            default:
                return false;
        }
    }
}
