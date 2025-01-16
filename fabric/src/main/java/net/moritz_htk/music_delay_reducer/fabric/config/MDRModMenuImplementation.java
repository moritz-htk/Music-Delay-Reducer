package net.moritz_htk.music_delay_reducer.fabric.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.moritz_htk.music_delay_reducer.config.MDRConfigScreen;

/**
 * Implementation of the ModMenu API for the Music Delay Reducer mod.
 * Provides a configuration screen factory to integrate the mod's settings with ModMenu.
 */
public class MDRModMenuImplementation implements ModMenuApi {
    /**
     * Returns a factory to create the mod's configuration screen.
     *
     * @return A {@link ConfigScreenFactory} instance that creates the {@link MDRConfigScreen}.
     */
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return MDRConfigScreen::new;
    }
}