package fr.darkbow_.changeslotautoequip;

import org.bukkit.plugin.java.JavaPlugin;

public class ChangeSlotAutoEquip extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("[ChangeSlotAutoEquip] Plugin ON!");
        getServer().getPluginManager().registerEvents(new AutoEquipEvent(), this);
    }

    @Override
    public void onDisable() {
        System.out.println("[ChangeSlotAutoEquip] Plugin OFF!");
    }
}