package net.moritz_htk.music_delay_reducer.config;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.moritz_htk.music_delay_reducer.MusicDelayReducer;

/**
 * Registers a command to open the configuration screen for the Music Delay Reducer mod.
 */
public class MDRConfigCommand {

    /**
     * Constructs and registers the configuration command.
     *
     * @param dispatcher The command dispatcher used to register the command.
     */
    public MDRConfigCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal(MusicDelayReducer.MOD_ID).executes(context -> {
            Minecraft minecraft = Minecraft.getInstance();
            minecraft.execute(() -> minecraft.setScreen(new MDRConfigScreen(minecraft.screen)));
            return Command.SINGLE_SUCCESS;
        }));
    }
}