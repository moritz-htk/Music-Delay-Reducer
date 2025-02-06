package net.moritz_htk.music_delay_reducer.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.moritz_htk.music_delay_reducer.MusicDelayReducer;
import net.moritz_htk.music_delay_reducer.config.MDRConfigCommand;

/**
 * Fabric-specific initializer for the Music Delay Reducer mod.
 * This class is the entry point for the mod when running on the Fabric platform.
 */
public class MDRFabric implements ModInitializer {
    /**
     * Called when the mod is initialized.
     * This method delegates to the main {@link MusicDelayReducer#init()} method
     * and registers the command callback for the configuration command.
     */
    @Override
    public void onInitialize() {
        MusicDelayReducer.init();
        CommandRegistrationCallback.EVENT.register((commandDispatcher, commandBuildContext, commandSelection) -> new MDRConfigCommand(commandDispatcher));
    }
}