package fr.darkbow_.changeslotautoequip;

import fr.darkbow_.changeslotautoequip.scoreboard.ScoreboardSign;
import org.bukkit.entity.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.*;

public class ChangeSlotAutoEquip extends JavaPlugin {

    public static BukkitTask task;
    private ChangeSlotAutoEquip instance;
    private Map<Player, ScoreboardSign> boards;

    private HashMap<Player, Integer> lastslot;

    public ChangeSlotAutoEquip getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        this.lastslot = new HashMap<>();

        System.out.println("[ChangeSlotAutoEquip] Plugin ON!");
        task = new SlotTask(instance).runTaskTimer(instance, 1L, 1L);
    }

    @Override
    public void onDisable() {
        System.out.println("[ChangeSlotAutoEquip] Plugin OFF!");
    }

    public Map<Player, ScoreboardSign> getBoards(){
        return this.boards;
    }

    public HashMap<Player, Integer> getLastSlot() {
        return lastslot;
    }
}