package net.moritz_htk.music_delay_reducer.neoforge;

import me.shedaniel.autoconfig.AutoConfig;
import net.moritz_htk.music_delay_reducer.MusicDelayReducer;
import net.moritz_htk.music_delay_reducer.config.MDRConfigData;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(MusicDelayReducer.MOD_ID)
public class MusicDelayReducerNeoForge {
    public MusicDelayReducerNeoForge() {
        MusicDelayReducer.init();
        ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () -> ((client, parent) -> AutoConfig.getConfigScreen(MDRConfigData.class, parent).get()));
    }
}