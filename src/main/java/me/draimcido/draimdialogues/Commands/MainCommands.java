package me.draimcido.draimdialogues.Commands;

import me.draimcido.draimdialogues.Main;
import me.draimcido.draimdialogues.Utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.OptionalInt;
import static me.draimcido.draimdialogues.Checks.Citizens.CitizensSelected.getSelectedNPCId;
import static me.draimcido.draimdialogues.Checks.Citizens.CitizensSelected.sendNotSelectedMessage;

public class MainCommands implements CommandExecutor {

    private final Main plugin;

    public MainCommands(final Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (command.getName().equalsIgnoreCase("draimdialogues")) {
            if (args.length == 0) {
                return true;
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reload")) {
                    if (!(sender instanceof Player)) {
                        Main.getInstance().reloadConfig();
                        Main.getInstance().onDisable();
                        Main.getInstance().onEnable();
                        MessageUtils.sendConsoleMessage(sender, Main.getInstance().getConfigString("messages.plugin-reloaded"));
                    } else {
                        Player player = (Player) sender;
                        if (!player.hasPermission("draimdialogues.reload")) {
                            MessageUtils.sendMessage(Main.getInstance().getConfigString("messages.no-permission"), player);
                        } else {
                            Main.getInstance().reloadConfig();
                            Main.getInstance().onDisable();
                            Main.getInstance().onEnable();
                            MessageUtils.sendMessage(Main.getInstance().getConfigString("messages.plugin-reloaded"), player);
                        }
                    }
                    return true;
                }
            } else if (args.length == 2) {
                if (args[0].equalsIgnoreCase("create")) {
                    if (sender.hasPermission("draimdialogues.craete") && sender instanceof Player player) {
                        final OptionalInt selectedNPC = getSelectedNPCId(sender);
                        if (!selectedNPC.isPresent()) {
                            sendNotSelectedMessage(plugin, player);
                            return true;
                        }



                    } else {
                        MessageUtils.sendMessage(Main.getInstance().getConfigString("messages.no-permission"), (Player) sender);
                    }
                    return true;
                }

            }
        }
        return false;
    }
}
