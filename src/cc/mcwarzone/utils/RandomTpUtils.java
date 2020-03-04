package cc.mcwarzone.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.Random;

public class RandomTpUtils {
    public static void randomTp(Player player,int r){
        Location location = player.getLocation();
        int player_x = location.getBlockX();
        int player_z = location.getBlockZ();
        int randomR = new Random().nextInt(r) + 1;
        int random_PI = new Random().nextInt(360) + 1;
        int x = (int)(randomR * Math.sin(random_PI) + player_x);
        int z = (int)(randomR * Math.cos(random_PI) + player_z);
        Location cloneLocation = location.clone();
        cloneLocation.setX(x);
        cloneLocation.setZ(z);
        makeSafeAndTop(cloneLocation);
        player.teleport(cloneLocation);
    }
    public static void makeSafeAndTop(Location location){
        Location tempLocation = location.clone();
        tempLocation.setY(tempLocation.getBlockY() + 3);

        while (!tempLocation.getBlock().getType().equals(Material.AIR)){
            tempLocation.setY(tempLocation.getBlockY() + 1);
        }
        Location temp2Location = tempLocation.clone();
        for(int i = 1 ; i < 4; i ++){
            temp2Location.setY(temp2Location.getBlockY() + i);
            if(!tempLocation.getBlock().getType().equals(Material.AIR)){
                makeSafeAndTop(temp2Location);
            }
        }
        temp2Location.setY(temp2Location.getBlockY() - 3);
        location.setY(temp2Location.getBlockY() - 1);
    }
}
