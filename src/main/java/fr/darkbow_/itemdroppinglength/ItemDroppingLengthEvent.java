package fr.darkbow_.itemdroppinglength;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemDroppingLengthEvent implements Listener {

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event){
        if(event.getPlayer().hasPermission("itemdroppinglength.longdrop")){
            if(event.getPlayer().getGameMode() == GameMode.CREATIVE || event.getPlayer().getGameMode() == GameMode.SPECTATOR){
                event.getItemDrop().setVelocity(event.getItemDrop().getVelocity().multiply(2D));
            }
        }
    }
}