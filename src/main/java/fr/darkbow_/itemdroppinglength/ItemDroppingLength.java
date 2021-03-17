package fr.darkbow_.itemdroppinglength;

import org.bukkit.plugin.java.JavaPlugin;

public class ItemDroppingLength extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("[ItemDroppingLength] Plugin ON!");
        getServer().getPluginManager().registerEvents(new ItemDroppingLengthEvent(), this);
    }

    @Override
    public void onDisable() {
        System.out.println("[ItemDroppingLength] Plugin OFF!");
    }
}