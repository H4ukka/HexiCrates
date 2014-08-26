package com.h4.HexiCrates;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * HexiCrates v0.1 rev 0
 * by H4
 * 20082014
 */

public class HexiCrates extends JavaPlugin implements Listener {

    private PluginConfiguration config = new PluginConfiguration(this);
    private CratesCore packCore = new CratesCore(config, this);

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("HexiCrates Started.");
    }

    @Override
    public void onDisable() {
        getLogger().info("HexiCrates Closed.");
    }

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String l, String[] args) {

        ReturnCode code = ReturnCode.UNSUPPORTED_SOURCE;

        if (args.length > 0) {
            if (cs instanceof Player) {
                switch (cmd.getName().toLowerCase()) {
                    case "roll":
                        code = packCore.spawnCrate((Player) cs, args[0]);
                        break;
                    case "x":
                        // Placeholder
                    default:
                        code = ReturnCode.UNKNOWN_COMMAND;
                }
            }
        } else {
            code = ReturnCode.TOO_FEW_ARGUMENTS;
        }

        if (returnCodeHasError(code, cs)) {
            // Errors were encountered and a message was printed; Command failed.
            return false;
        } else {
            // Success!
            return true;
        }
    }

    private boolean returnCodeHasError(ReturnCode code, CommandSender source) {

        // Check the return code and decide if we need to print out an error message
        switch (code) {
            case UNSUPPORTED_SOURCE:
            case TOO_FEW_ARGUMENTS:
            case UNKNOWN_COMMAND:
                source.sendMessage("§c" + code.errorDescription);
                return true;

            case SUCCESS:
                return false;

            default:
                return true;
        }
    }
}
