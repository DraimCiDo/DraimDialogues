package me.draimcido.draimdialogues.Checks.Citizens;

import me.draimcido.draimdialogues.Main;
import me.draimcido.draimdialogues.Utils.MessageUtils;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.OptionalInt;

public class CitizensSelected {


    // Получение ID NPC
    public static OptionalInt getSelectedNPCId(final CommandSender sender) {
        final NPC npc = CitizensAPI.getDefaultNPCSelector().getSelected(sender);
        if (npc == null) return OptionalInt.empty();
        return OptionalInt.of(npc.getId());
    }

    // Отправка сообщения что НПС не выбран.
    public static void sendNotSelectedMessage(final Main plugin, final Player player) {
        MessageUtils.sendMessage(Main.getInstance().getConfigString("messages.not-selected"), player);
    }

    // Проверка на /npc sel
    public static boolean npcNotSelectedNM(Player player) {
        return CitizensAPI.getDefaultNPCSelector().getSelected(player) == null;
    }
}
