package com.ppaka.starterkit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class KitCommand implements CommandExecutor {
    CoolInventory inv;

    public KitCommand(CoolInventory inv) {
        this.inv = inv;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player player) {
            if (inv.getInventory().isEmpty()) {
                player.sendMessage("설정된 기본템이 없습니다!");
                return true;
            }
            for (ItemStack item : inv.getInventory().getStorageContents()) {
                if (item == null) continue;
                player.getInventory().addItem(item);
            }
            player.sendMessage("기본템이 지급되었습니다!");
            return true;
        }
        else if (sender instanceof ConsoleCommandSender) {
            sender.sendMessage("콘솔에서는 이 명령어를 실행할 수 없습니다.");
            return true;   //false값을 반환하면 명령어가 실패한 것으로 간주
        }
        return false;
    }
}
