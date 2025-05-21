# ItemDroppingLength

**ItemDroppingLength** est un plugin Spigot permettant d'augmenter la distance à laquelle les objets sont jetés en mode créatif ou spectateur. Le facteur d'amplification est configurable et peut être ajusté en jeu par commande.

## Fonctionnement
- Au chargement du plugin, la valeur `droplength` est lue depuis le fichier de configuration. Elle détermine le multiplicateur appliqué à la vélocité de l'objet jeté.
- Lorsqu'un joueur possédant la permission `itemdroppinglength.longdrop` lance un objet en mode `CREATIVE` ou `SPECTATOR`, la vélocité de l'objet est multipliée par cette valeur.

```java
@EventHandler
public void onItemDrop(PlayerDropItemEvent event){
    if(event.getPlayer().hasPermission("itemdroppinglength.longdrop")){
        if(event.getPlayer().getGameMode() == GameMode.CREATIVE || event.getPlayer().getGameMode() == GameMode.SPECTATOR){
            event.getItemDrop().setVelocity(event.getItemDrop().getVelocity().multiply(ItemDroppingLength.droplength));
        }
    }
}
```
【F:src/main/java/fr/darkbow_/itemdroppinglength/ItemDroppingLengthEvent.java†L8-L18】

## Fichiers de configuration
### config.yml
```
droplength: 4.0
```
【F:src/main/resources/config.yml†L1-L1】
- **droplength** *(double)* : multiplicateur appliqué à la distance de lancer. Valeur par défaut : `4.0`.

### plugin.yml
Ce fichier déclare le plugin et la commande associée :
```
name: ItemDroppingLength
author: DarkBow_
version: 1.0
main: fr.darkbow_.itemdroppinglength.ItemDroppingLength
commands:
  itemdroplength:
    description: Allows you to multiply your drop length range
    permission:
```
【F:src/main/resources/plugin.yml†L1-L8】

## Commandes
La commande principale `/itemdroplength` permet d'afficher ou de modifier le multiplicateur :
- `/itemdroplength help` : affiche l'aide.
- `/itemdroplength info` : indique la valeur actuelle du multiplicateur.
- `/itemdroplength set <nombre>` : définit une nouvelle valeur.

Extrait du gestionnaire de commandes :
```java
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
```
【F:src/main/java/fr/darkbow_/itemdroppinglength/commands/CommandItemDropLength.java†L29-L41】

## Compilation / Installation
Le projet utilise **Maven** et cible Spigot 1.16.4 :
```xml
<dependency>
    <groupId>org.spigotmc</groupId>
    <artifactId>spigot</artifactId>
    <version>1.16.4-R0.1-SNAPSHOT</version>
    <scope>provided</scope>
</dependency>
```
【F:pom.xml†L20-L25】
1. Cloner le dépôt puis exécuter :
   ```bash
   mvn package
   ```
2. Le fichier final `ItemDroppingLength-1.0.jar` sera disponible dans le dossier `target/`.
3. Placez ce JAR dans le dossier `plugins/` de votre serveur Spigot et redémarrez-le.

## Fichiers importants
- **ItemDroppingLength.java** : classe principale initialisant la configuration et enregistrant la commande ainsi que l'événement.
- **ItemDroppingLengthEvent.java** : écoute l'événement `PlayerDropItemEvent` et applique l'augmentation de distance.
- **CommandItemDropLength.java** : gère la commande `/itemdroplength`.
- **config.yml** : contient le multiplicateur `droplength`.

## Utilisation rapide
1. Compilez le projet ou téléchargez le JAR fourni.
2. Copiez `ItemDroppingLength-1.0.jar` dans `plugins/`.
3. Lancez ou redémarrez votre serveur Spigot.
4. Utilisez `/itemdroplength info` pour connaître la valeur actuelle et `/itemdroplength set <nombre>` pour la modifier.

## Licence
Aucune licence n'est fournie dans le dépôt.
