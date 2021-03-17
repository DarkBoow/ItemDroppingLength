package fr.darkbow_.changeslotautoequip;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Objects;

public class SlotTask extends BukkitRunnable {
    private ChangeSlotAutoEquip main;

    public SlotTask(ChangeSlotAutoEquip changeslotautoequip) {this.main = changeslotautoequip;}

    @Override
    public void run() {
        if(Bukkit.getOnlinePlayers().size() > 0){
            for(Player pls : Bukkit.getOnlinePlayers()){
                if(pls.getScoreboardTags().contains("ChangingSlotAutoEquip")){
                    if(main.getLastSlot().containsKey(pls)){
                        if(!pls.getInventory().isEmpty()){
                            if(pls.getInventory().getHeldItemSlot() != main.getLastSlot().get(pls)){
                                if(pls.getInventory().getItem(pls.getInventory().getHeldItemSlot()) == null || pls.getInventory().getItem(pls.getInventory().getHeldItemSlot()).getType() == Material.AIR){
                                    pls.getInventory().setHelmet(null);
                                    pls.getInventory().setChestplate(null);
                                    pls.getInventory().setLeggings(null);
                                    pls.getInventory().setBoots(null);
                                } else if(pls.getInventory().getItem(pls.getInventory().getHeldItemSlot()).getType().name().contains("SWORD") || pls.getInventory().getItem(pls.getInventory().getHeldItemSlot()).getType().name().contains("AXE")) {
                                    pls.getInventory().setHelmet(pls.getInventory().getItem(9));
                                    pls.getInventory().setChestplate(pls.getInventory().getItem(10));
                                    pls.getInventory().setLeggings(pls.getInventory().getItem(11));
                                    pls.getInventory().setBoots(pls.getInventory().getItem(12));
                                }

                                pls.updateInventory();

                                main.getLastSlot().put(pls, pls.getInventory().getHeldItemSlot());
                            }
                        }
                    } else {
                        main.getLastSlot().put(pls, pls.getInventory().getHeldItemSlot());
                    }
                }
            }
        }
    }
}
