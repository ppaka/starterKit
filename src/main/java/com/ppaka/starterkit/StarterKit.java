package com.ppaka.starterkit;

import org.bukkit.plugin.java.JavaPlugin;

public final class StarterKit extends JavaPlugin {
    CoolInventory kitInv;

    public void onEnable() {
        getLogger().info("플러그인이 활성화되었습니다.");
        kitInv = new CoolInventory();
        getCommand("기본템").setExecutor(new KitCommand(kitInv));
        getCommand("기본템설정").setExecutor(new KitConfigCommand(kitInv));
    }

    public void onDisable() {
        getLogger().info("플러그인이 비활성화되었습니다.");
    }
}
