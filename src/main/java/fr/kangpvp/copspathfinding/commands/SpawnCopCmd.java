package fr.kangpvp.copspathfinding.commands;

import fr.kangpvp.copspathfinding.CustomCop;
import fr.kangpvp.copspathfinding.CustomCopV2;
import net.minecraft.network.chat.Component;
import net.minecraft.server.WorldLoader;
import net.minecraft.server.level.ServerLevel;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;

public class SpawnCopCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player){
            Player player = (Player) commandSender;

            ServerLevel world = ((CraftWorld) player.getWorld()).getHandle();
            CustomCop cop = new CustomCop(player.getLocation());
            world.addFreshEntity(cop);
            player.sendMessage("Cop Spawned !");

            CustomCopV2 copV2 = new CustomCopV2(player.getLocation(), player);
            copV2.setCustomName(Component.nullToEmpty(ChatColor.LIGHT_PURPLE + player.getName() + " Pet"));
            ServerLevel worldV2 = ((CraftWorld) player.getWorld()).getHandle();
            worldV2.addFreshEntity(copV2);
            player.sendMessage("Cop V2 Spawned !");
        }



        return false;
    }
}
