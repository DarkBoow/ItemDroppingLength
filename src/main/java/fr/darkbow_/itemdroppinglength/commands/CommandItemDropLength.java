package fr.darkbow_.itemdroppinglength.commands;

import fr.darkbow_.itemdroppinglength.ItemDroppingLength;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandItemDropLength implements CommandExecutor {
    private ItemDroppingLength main;

    public CommandItemDropLength(ItemDroppingLength itemdroppinglength){this.main = itemdroppinglength;}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if(args.length == 0){
            sender.sendMessage("§a/itemdroplength info §7: Gives you the current item drop multiplier value.\n§a/itemdroplength set <number> §7: Change the item drop length multiplier value.");
        }

        if(args.length == 1){
            if(args[0].equalsIgnoreCase("help")){
                sender.sendMessage("§a/itemdroplength info §7: Gives you the current item drop multiplier value.\n§a/itemdroplength set <number> §7: Change the item drop length multiplier value.");
            } else if(args[0].equalsIgnoreCase("info")){
                sender.sendMessage("§bThe item dropping length is set to §bx§6" + ItemDroppingLength.droplength + "§a.");
            } else if(args[0].equalsIgnoreCase("set")){
                sender.sendMessage("§cYou need to write a number, in order to change the item drop length multiplier value!");
            }
        }

        if(args.length == 2){
            if(args[0].equalsIgnoreCase("set")){
                try{
                    ItemDroppingLength.droplength = Double.parseDouble(args[1]);
                    main.getConfig().set("droplength", Double.parseDouble(args[1]));
                    main.saveConfig();
                    sender.sendMessage("§aThe item dropping length has been changed to §bx§6" + Double.parseDouble(args[1]) + "§a!");
                } catch(NumberFormatException e){
                    sender.sendMessage("§4Error - §cThe given value is not a number!");
                }
            } else {
                sender.sendMessage("§cWrong command. §bExecute §6/itemdroplength help §bto get the command list.");
            }
        }

        if(args.length > 2){
            sender.sendMessage("§cWrong command. §bExecute §6/itemdroplength help §bto get the command list.");
        }

        return false;
    }
}