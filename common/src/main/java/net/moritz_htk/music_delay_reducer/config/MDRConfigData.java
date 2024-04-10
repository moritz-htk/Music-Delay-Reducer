package net.moritz_htk.music_delay_reducer.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.moritz_htk.music_delay_reducer.MusicDelayReducer;

@Config(name = MusicDelayReducer.MOD_ID)
public class MDRConfigData implements ConfigData, MDRConfig {
    @ConfigEntry.Gui.Tooltip
    public float minTime = MDRConfigDefaults.MIN_TIME;

    @ConfigEntry.Gui.Tooltip
    public float maxTime = MDRConfigDefaults.MAX_TIME;

    @Override
    public float minTime() {
        return minTime;
    }

    @Override
    public float maxTime() {
        return maxTime;
    }
}