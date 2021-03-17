package fr.darkbow_.changeslotautoequip;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

public class ChangeSlotAutoEquipEvent implements Listener {
    private ChangeSlotAutoEquip main;

    public ChangeSlotAutoEquipEvent(ChangeSlotAutoEquip vaguesdemonstres){main = vaguesdemonstres;}

    @EventHandler
    public void onSlotChange(PlayerItemHeldEvent event){
        Bukkit.broadcastMessage("yo");
    }
}