package me.draimcido.draimdialogues.Listeners;

import me.draimcido.draimdialogues.Main;
import net.citizensnpcs.api.event.NPCLeftClickEvent;
import net.citizensnpcs.api.event.NPCRemoveEvent;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class NPCClickListener implements Listener {

    private final Main plugin;

    public NPCClickListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onRightClick(NPCRightClickEvent event) {
        NPC npc = event.getNPC();
        Player player = event.getClicker();

        if (!player.hasPermission("draimdialogues.use")) return;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onLeftClick(NPCLeftClickEvent event) {
        NPC npc = event.getNPC();
        Player player = event.getClicker();

        if (!player.hasPermission("draimdialogues.use")) return;
    }

}
