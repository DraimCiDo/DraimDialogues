package me.draimcido.draimdialogues.Utils;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SoundUtils {

    public static void playSound(Player player, Sound sound) {
        player.playSound(player.getLocation(), sound, 1.0F, 1.0F);
    }
}
