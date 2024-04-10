package net.moritz_htk.music_delay_reducer;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.moritz_htk.music_delay_reducer.config.MDRConfig;
import net.moritz_htk.music_delay_reducer.config.MDRConfigData;
import net.moritz_htk.music_delay_reducer.config.MDRConfigDefaults;

public class MusicDelayReducer {
    public static final String MOD_ID = "music_delay_reducer";
    public static MDRConfig CONFIG = new MDRConfigDefaults();

    public static void init() {
        CONFIG = AutoConfig.register(MDRConfigData.class, GsonConfigSerializer::new).getConfig();
    }
}