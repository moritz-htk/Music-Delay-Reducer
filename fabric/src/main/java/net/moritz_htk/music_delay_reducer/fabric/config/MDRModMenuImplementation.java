package net.moritz_htk.music_delay_reducer.fabric.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import net.moritz_htk.music_delay_reducer.config.MDRConfigData;

public class MDRModMenuImplementation implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> AutoConfig.getConfigScreen(MDRConfigData.class, parent).get();
    }
}