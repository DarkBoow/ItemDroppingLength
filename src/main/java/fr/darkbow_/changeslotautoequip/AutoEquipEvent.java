package fr.darkbow_.changeslotautoequip;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.Objects;

public class AutoEquipEvent implements Listener {

    @EventHandler
    public void onSlotChange(PlayerItemHeldEvent event){
        Player player = event.getPlayer();
        if(player.getScoreboardTags().contains("ChangingSlotAutoEquip")){
            if(player.getInventory().getItem(event.getNewSlot()) == null || Objects.requireNonNull(player.getInventory().getItem(event.getNewSlot())).getType() == Material.AIR){
                player.getInventory().setHelmet(null);
                player.getInventory().setChestplate(null);
                player.getInventory().setLeggings(null);
                player.getInventory().setBoots(null);
            } else if(Objects.requireNonNull(player.getInventory().getItem(event.getNewSlot())).getType().name().contains("SWORD") || Objects.requireNonNull(player.getInventory().getItem(event.getNewSlot())).getType().name().contains("AXE")){
                player.getInventory().setHelmet(player.getInventory().getItem(9));
                player.getInventory().setChestplate(player.getInventory().getItem(10));
                player.getInventory().setLeggings(player.getInventory().getItem(11));
                player.getInventory().setBoots(player.getInventory().getItem(12));
            }
        }
    }
}