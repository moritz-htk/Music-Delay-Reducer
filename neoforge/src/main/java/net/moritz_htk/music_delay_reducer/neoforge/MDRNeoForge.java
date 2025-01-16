package net.moritz_htk.music_delay_reducer.neoforge;

import net.moritz_htk.music_delay_reducer.MusicDelayReducer;
import net.moritz_htk.music_delay_reducer.config.MDRConfigScreen;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

/**
 * NeoForge-specific initializer for the Music Delay Reducer mod.
 * This class is the entry point for the mod when running on the NeoForge platform.
 */
@Mod(MusicDelayReducer.MOD_ID)
public class MDRNeoForge {

    /**
     * Constructs a new instance of the NeoForge initializer.
     * This method initializes the mod and registers the configuration screen.
     */
    public MDRNeoForge() {
        MusicDelayReducer.init();
        ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () -> ((client, parent) -> new MDRConfigScreen(parent)));
    }
}