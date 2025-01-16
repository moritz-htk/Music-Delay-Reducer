package net.moritz_htk.music_delay_reducer.forge;

import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.moritz_htk.music_delay_reducer.MusicDelayReducer;
import net.moritz_htk.music_delay_reducer.config.MDRConfigScreen;

/**
 * Forge-specific initializer for the Music Delay Reducer mod.
 * This class is the entry point for the mod when running on the Forge platform.
 */
@Mod(MusicDelayReducer.MOD_ID)
public class MDRForge {

    /**
     * Constructs a new instance of the Forge initializer.
     * This method initializes the mod and registers the configuration screen.
     *
     * @param context The mod loading context provided by Forge.
     */
    public MDRForge(FMLJavaModLoadingContext context) {
        MusicDelayReducer.init();
        context.registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () -> new ConfigScreenHandler.ConfigScreenFactory((minecraft, screen) -> new MDRConfigScreen(screen)));
    }
}