package fr.darkbow_.changeslotautoequip;

import fr.darkbow_.changeslotautoequip.scoreboard.ScoreboardSign;
import org.bukkit.*;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class ChangeSlotAutoEquip extends JavaPlugin {

    private ChangeSlotAutoEquip instance;

    private Map<Player, ScoreboardSign> boards;

    public ChangeSlotAutoEquip getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        System.out.println("[ChangeSlotAutoEquip] Plugin ON!");
    }

    @Override
    public void onDisable() {
        System.out.println("[ChangeSlotAutoEquip] Plugin OFF!");
    }

    public Map<Player, ScoreboardSign> getBoards(){
        return this.boards;
    }
}