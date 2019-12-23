package me.totalfreedom.totalfreedommod.command;

import java.util.Arrays;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@CommandPermissions(level = Rank.SYSTEM_ADMIN, source = SourceType.BOTH)
@CommandParameters(description = "BUZZ DOWN", usage = "/<command>")
public class Command_spazzle extends FreedomCommand
{
    public static final String COOKIE_LYRICS = "BUZZ DOWN BUZZ DOWN SPAZZLE IS HERE! \nHow about a cookie?";
    public static final String LORE = "BUZZ DOWN BUZZ DOWN";

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        final StringBuilder output = new StringBuilder();

        for (final String word : COOKIE_LYRICS.split(" "))
        {
            output.append(FUtil.randomChatColor()).append(word).append(" ");
        }

        final StringBuilder name = new StringBuilder();

        name.append(ChatColor.DARK_RED).append("S")
                .append(ChatColor.GOLD).append("p")
                .append(ChatColor.YELLOW).append("a")
                .append(ChatColor.DARK_GREEN).append("z")
                .append(ChatColor.DARK_BLUE).append("z")
                .append(ChatColor.DARK_PURPLE).append("l")
                .append(ChatColor.GREEN).append("e");

        final StringBuilder lore = new StringBuilder();

        for (final String word : LORE.split(" "))
        {
            lore.append(FUtil.randomChatColor()).append(word).append(" ");
        }

        final ItemStack heldItem = new ItemStack(Material.COOKIE);
        final ItemMeta heldItemMeta = heldItem.getItemMeta();
        heldItemMeta.setDisplayName(name.toString());
        heldItemMeta.setLore(Arrays.asList(lore.toString().split("\n")));
        heldItem.setItemMeta(heldItemMeta);

        for (final Player player : server.getOnlinePlayers())
        {
            final int firstEmpty = player.getInventory().firstEmpty();
            if (firstEmpty >= 0)
            {
                player.getInventory().setItem(firstEmpty, heldItem);
            }
        }

        FUtil.bcastMsg(output.toString());
        return true;
    }
}
