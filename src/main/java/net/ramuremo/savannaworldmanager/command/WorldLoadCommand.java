package net.ramuremo.savannaworldmanager.command;

import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.io.File;

public final class WorldLoadCommand extends Command {
    public WorldLoadCommand() {
        super("load-world");
    }

    @Override
    public boolean execute(@Nonnull CommandSender sender, @Nonnull String aliases, @Nonnull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You cannot send this command there. Run command as Player.");
            return true;
        }
        if (!sender.isOp()) {
            sender.sendMessage("You are not OP in this server, so you cannot send this command.");
            return true;
        }
        if (args.length < 1) {
            sender.sendMessage("Illegal args");
            return true;
        }
        if (!new File("./" + args[0]).exists()) {
            sender.sendMessage("The name of that folder doesn't exists. Run create command?");
            return true;
        }
        new WorldCreator(args[0]).createWorld();
        sender.sendMessage("The world loaded.");
        return true;
    }
}
