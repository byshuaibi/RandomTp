package cc.mcwarzone.command;

import cc.mcwarzone.utils.RandomTpUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.regex.Pattern;

public class RandomTpCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(s.equalsIgnoreCase("crt")){
            if(strings.length == 2){
                String path = strings[0];
                String rString = strings[1];
                if(Bukkit.getPlayer(path) != null && Bukkit.getPlayer(path).isOnline()){
                    Player player = Bukkit.getPlayer(path);
                    if(Pattern.matches("[0-9]+" , rString)){
                        int r = Integer.parseInt(rString);
                        RandomTpUtils.randomTp(player,r);
                        commandSender.sendMessage("启动传送完成.");
                        return true;
                    }else {
                        commandSender.sendMessage("请输入数字半径.");
                        return true;
                    }
                }else {
                    commandSender.sendMessage("玩家不在线或从未加入过服务器.");
                    return true;
                }
            }else{
                commandSender.sendMessage("§5请使用 §a/crt <id> <r> §5进行随机传送.");
                return true;
            }
        }
        return true;
    }
}
