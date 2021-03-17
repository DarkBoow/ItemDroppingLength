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
                if(player.getInventory().getItem(event.getPreviousSlot()) != null && Objects.requireNonNull(player.getInventory().getItem(event.getPreviousSlot())).getType() != Material.AIR){
                    boolean helmet = false;
                    boolean chestplate = false;
                    boolean leggings = false;
                    boolean boots = false;
                    boolean shield = false;

                    if(player.getInventory().getHelmet() != null && player.getInventory().getHelmet().getType() != Material.AIR){
                        helmet = true;
                        if(player.getInventory().getItem(9) == null || player.getInventory().getItem(9).getType() == Material.AIR){
                            player.getInventory().setItem(9, player.getInventory().getHelmet());
                        } else {
                            player.getInventory().addItem(player.getInventory().getHelmet());
                        }
                    }

                    if(player.getInventory().getChestplate() != null && player.getInventory().getChestplate().getType() != Material.AIR){
                        chestplate = true;
                        if(player.getInventory().getItem(10) == null || player.getInventory().getItem(10).getType() == Material.AIR){
                            player.getInventory().setItem(10, player.getInventory().getChestplate());
                        } else {
                            player.getInventory().addItem(player.getInventory().getChestplate());
                        }
                    }

                    if(player.getInventory().getLeggings() != null && player.getInventory().getLeggings().getType() != Material.AIR){
                        leggings = true;
                        if(player.getInventory().getItem(11) == null || player.getInventory().getItem(11).getType() == Material.AIR){
                            player.getInventory().setItem(11, player.getInventory().getLeggings());
                        } else {
                            player.getInventory().addItem(player.getInventory().getLeggings());
                        }
                    }

                    if(player.getInventory().getBoots() != null && player.getInventory().getBoots().getType() != Material.AIR){
                        boots = true;
                        if(player.getInventory().getItem(12) == null || player.getInventory().getItem(12).getType() == Material.AIR){
                            player.getInventory().setItem(12, player.getInventory().getBoots());
                        } else {
                            player.getInventory().addItem(player.getInventory().getBoots());
                        }
                    }

                    if(player.getInventory().getItemInOffHand().getType() != Material.AIR){
                        shield = true;
                        if(player.getInventory().getItem(13) == null || player.getInventory().getItem(13).getType() == Material.AIR){
                            player.getInventory().setItem(13, player.getInventory().getItemInOffHand());
                        } else {
                            player.getInventory().addItem(player.getInventory().getItemInOffHand());
                        }
                    }

                    if(helmet){player.getInventory().setHelmet(null);}
                    if(chestplate){player.getInventory().setChestplate(null);}
                    if(leggings){player.getInventory().setLeggings(null);}
                    if(boots){player.getInventory().setBoots(null);}
                    if(shield){player.getInventory().setItemInOffHand(null);}

                    if(helmet || chestplate || leggings || boots){player.updateInventory();}
                }
            } else if(Objects.requireNonNull(player.getInventory().getItem(event.getNewSlot())).getType().name().contains("SWORD") || Objects.requireNonNull(player.getInventory().getItem(event.getNewSlot())).getType().name().contains("AXE")){
                boolean changed = false;
                if(player.getInventory().getItem(9) != null && Objects.requireNonNull(player.getInventory().getItem(9)).getType() != Material.AIR){
                    player.getInventory().setHelmet(player.getInventory().getItem(9));
                    player.getInventory().remove(Objects.requireNonNull(player.getInventory().getItem(9)));
                    changed = true;
                }

                if(player.getInventory().getItem(10) != null && Objects.requireNonNull(player.getInventory().getItem(10)).getType() != Material.AIR){
                    player.getInventory().setChestplate(player.getInventory().getItem(10));
                    player.getInventory().remove(Objects.requireNonNull(player.getInventory().getItem(10)));
                    changed = true;
                }

                if(player.getInventory().getItem(11) != null && Objects.requireNonNull(player.getInventory().getItem(11)).getType() != Material.AIR){
                    player.getInventory().setLeggings(player.getInventory().getItem(11));
                    player.getInventory().remove(Objects.requireNonNull(player.getInventory().getItem(11)));
                    changed = true;
                }

                if(player.getInventory().getItem(12) != null && Objects.requireNonNull(player.getInventory().getItem(12)).getType() != Material.AIR){
                    player.getInventory().setBoots(player.getInventory().getItem(12));
                    player.getInventory().remove(Objects.requireNonNull(player.getInventory().getItem(12)));
                    changed = true;
                }

                if(player.getInventory().getItem(13) != null && Objects.requireNonNull(player.getInventory().getItem(13)).getType() != Material.AIR){
                    player.getInventory().setItemInOffHand(player.getInventory().getItem(13));
                    player.getInventory().remove(Objects.requireNonNull(player.getInventory().getItem(13)));
                    changed = true;
                }

                if(changed){player.updateInventory();}
            }
        }
    }
}