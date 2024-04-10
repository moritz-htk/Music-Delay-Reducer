package net.moritz_htk.music_delay_reducer.fabric;

import net.moritz_htk.music_delay_reducer.MusicDelayReducer;
import net.fabricmc.api.ModInitializer;

public class MusicDelayReducerFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        MusicDelayReducer.init();
    }
}
