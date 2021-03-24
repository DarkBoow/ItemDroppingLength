package fr.darkbow_.itemdroppinglength;

import fr.darkbow_.itemdroppinglength.commands.CommandItemDropLength;
import org.bukkit.plugin.java.JavaPlugin;

public class ItemDroppingLength extends JavaPlugin {
    private static ItemDroppingLength instance;

    public static double droplength = 0;

    public static ItemDroppingLength getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        instance = this;

        if(getConfig().isDouble("droplength")){
            droplength = getConfig().getDouble("droplength");
        }

        getServer().getPluginManager().registerEvents(new ItemDroppingLengthEvent(), this);
        getCommand("itemdroplength").setExecutor(new CommandItemDropLength(this));
        System.out.println("[ItemDroppingLength] Plugin ON!");
    }

    @Override
    public void onDisable() {
        System.out.println("[ItemDroppingLength] Plugin OFF!");
    }
}