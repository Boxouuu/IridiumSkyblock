package com.iridium.iridiumskyblock.commands;

import com.iridium.iridiumskyblock.IridiumSkyblock;
import com.iridium.iridiumskyblock.Island;
import com.iridium.iridiumskyblock.User;
import com.iridium.iridiumskyblock.Utils;
import java.util.Collections;
import java.util.List;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BankCommand extends Command {

    public BankCommand() {
        super(Collections.singletonList("bank"), "Opens the bank GUI", "", true);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        User user = User.getUser(p);
        if (user.getIsland() != null) {
            p.openInventory(user.getIsland().bankGUI.getInventory());
        } else {
            sender.sendMessage(Utils.color(IridiumSkyblock.messages.noIsland.replace("%prefix%", IridiumSkyblock.configuration.prefix)));
        }
    }

    @Override
    public void admin(CommandSender sender, String[] args, Island island) {
        Player p = (Player) sender;
        if (island != null) {
            p.openInventory(island.bankGUI.getInventory());
        } else {
            sender.sendMessage(Utils.color(IridiumSkyblock.messages.noIsland.replace("%prefix%", IridiumSkyblock.configuration.prefix)));
        }
    }

    @Override
    public List<String> TabComplete(CommandSender cs, org.bukkit.command.Command cmd, String s, String[] args) {
        return null;
    }
}
