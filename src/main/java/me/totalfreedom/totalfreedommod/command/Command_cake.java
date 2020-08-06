package me.totalfreedom.totalfreedommod.command;

<<<<<<< HEAD
=======
import java.util.Random;
>>>>>>> devel
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.BOTH)
@CommandParameters(description = "For the people that are still alive.", usage = "/<command>")
public class Command_cake extends FreedomCommand
{
<<<<<<< HEAD
    public static final String CAKE_LYRICS = "But there's no sense crying over every mistake. You just keep on trying till you run out of cake.";

    @Override
    public boolean run(final CommandSender sender, final Player playerSender, final Command cmd, final String commandLabel, final String[] args, final boolean senderIsConsole)
    {
        final StringBuilder output = new StringBuilder();

        for (final String word : CAKE_LYRICS.split(" "))
        {
            output.append(FUtil.randomChatColor()).append(word).append(" ");
=======

    public static final String CAKE_LYRICS = "But there's no sense crying over every mistake. You just keep on trying till you run out of cake.";
    private final Random random = new Random();

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        final StringBuilder output = new StringBuilder();

        final String[] words = CAKE_LYRICS.split(" ");
        for (final String word : words)
        {
            output.append(ChatColor.COLOR_CHAR).append(Integer.toHexString(1 + random.nextInt(14))).append(word).append(" ");
>>>>>>> devel
        }

        final ItemStack heldItem = new ItemStack(Material.CAKE);
        final ItemMeta heldItemMeta = heldItem.getItemMeta();
<<<<<<< HEAD
        heldItemMeta.setDisplayName(ChatColor.WHITE + "The " + ChatColor.DARK_GRAY + "Lie");
        heldItem.setItemMeta(heldItemMeta);

        for (final Player player : this.server.getOnlinePlayers())
=======
        heldItemMeta.setDisplayName((new StringBuilder()).append(ChatColor.WHITE).append("The ").append(ChatColor.DARK_GRAY).append("Lie").toString());
        heldItem.setItemMeta(heldItemMeta);

        for (final Player player : server.getOnlinePlayers())
>>>>>>> devel
        {
            final int firstEmpty = player.getInventory().firstEmpty();
            if (firstEmpty >= 0)
            {
                player.getInventory().setItem(firstEmpty, heldItem);
            }
<<<<<<< HEAD
        }

        FUtil.bcastMsg(output.toString());
=======
            
        }

        FUtil.bcastMsg(output.toString());

>>>>>>> devel
        return true;
    }
}
