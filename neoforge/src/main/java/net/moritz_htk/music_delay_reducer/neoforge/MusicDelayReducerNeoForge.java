package net.moritz_htk.music_delay_reducer.neoforge;

import me.shedaniel.autoconfig.AutoConfig;
import net.moritz_htk.music_delay_reducer.MusicDelayReducer;
import net.moritz_htk.music_delay_reducer.config.MDRConfigData;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.ConfigScreenHandler;

@Mod(MusicDelayReducer.MOD_ID)
public class MusicDelayReducerNeoForge {
    public MusicDelayReducerNeoForge() {
        MusicDelayReducer.init();
        ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () -> new ConfigScreenHandler.ConfigScreenFactory((client, parent) -> AutoConfig.getConfigScreen(MDRConfigData.class, parent).get()));
    }
}