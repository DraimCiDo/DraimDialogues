package me.draimcido.draimdialogues.Events;

import dev.lone.itemsadder.api.FontImages.FontImageWrapper;
import me.draimcido.draimdialogues.Main;
import me.draimcido.draimdialogues.Utils.MessageUtils;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.awt.*;

/**
 * The type Citizens select.
 */
public class CitizensSelect implements Listener {

    /**
     * Citizens select.
     *
     * @param e the event
     */
    @EventHandler
    public void CitizensSelect(NPCRightClickEvent e) {
        NPC npc = CitizensAPI.getNPCRegistry().getById(6);
        if (e.getNPC() == npc) {
            FontImageWrapper texture = new FontImageWrapper("draim:wumpys");
            if (!texture.exists()) {
                e.getClicker().sendMessage("Cannot find this texture, please make sure you have it in your data folder of ItemsAdder (items_packs and resource_pack)");
            }
            Player player = e.getClicker();
            player.sendMessage(new FontImageWrapper("draim:wumpys").getString());

            MessageUtils.sendMessage(Main.getInstance().getConfigString("dialogues.wumpys.line1") + " " + Main.getInstance().getConfigString("dialogues.wumpys.other_lines"), player);

        }
    }
}
