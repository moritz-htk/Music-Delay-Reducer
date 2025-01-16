package net.moritz_htk.music_delay_reducer.fabric;

import net.fabricmc.api.ModInitializer;
import net.moritz_htk.music_delay_reducer.MusicDelayReducer;

/**
 * Fabric-specific initializer for the Music Delay Reducer mod.
 * This class is the entry point for the mod when running on the Fabric platform.
 */
public class MDRFabric implements ModInitializer {
    /**
     * Called when the mod is initialized.
     * This method delegates to the main {@link MusicDelayReducer#init()} method.
     */
    @Override
    public void onInitialize() {
        MusicDelayReducer.init();
    }
}