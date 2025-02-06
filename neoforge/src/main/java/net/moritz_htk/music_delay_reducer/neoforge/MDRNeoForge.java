package net.moritz_htk.music_delay_reducer.neoforge;

import net.moritz_htk.music_delay_reducer.MusicDelayReducer;
import net.moritz_htk.music_delay_reducer.config.MDRConfigCommand;
import net.moritz_htk.music_delay_reducer.config.MDRConfigScreen;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

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

    /**
     * Event subscriber class for handling game-related events.
     */
    @EventBusSubscriber(modid = MusicDelayReducer.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
    public static class MDREvents {

        /**
         * Handles the registration of commands for the mod.
         *
         * @param event The event triggered when commands are being registered.
         */
        @SubscribeEvent
        public static void onCommandsRegister(RegisterCommandsEvent event) {
            new MDRConfigCommand(event.getDispatcher());
        }
    }
}