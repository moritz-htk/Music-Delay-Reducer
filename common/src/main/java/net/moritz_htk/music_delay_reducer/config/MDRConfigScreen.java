package net.moritz_htk.music_delay_reducer.config;

import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.options.OptionsSubScreen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;

/**
 * Represents the configuration screen for the Music Delay Reducer mod.
 * Provides options for users to customize mod settings, including
 * setting delay time, and toggling debug mode.
 */
public class MDRConfigScreen extends OptionsSubScreen {
    /**
     * Constructs a new MDRConfigScreen.
     *
     * @param screen The parent screen to return to when this screen is closed.
     */
    public MDRConfigScreen(Screen screen) {
        super(screen, Minecraft.getInstance().options, Component.translatable("options.music_delay_reducer.title"));
    }

    /**
     * Adds configurable options to the screen.
     */
    @Override
    protected void addOptions() {
        this.list.addBig(new OptionInstance<>(
                I18n.get("options.music_delay_reducer.delayTime"),
                OptionInstance.cachedConstantTooltip(Component.translatable("options.music_delay_reducer.delayTime.tooltip")),
                (component, integer) -> Options.genericValueLabel(component, CommonComponents.minutes(integer)),
                new OptionInstance.IntRange(0, 120),
                MDRConfigManager.getConfig().delayTime,
                integer -> MDRConfigManager.getConfig().delayTime = integer
        ));

        this.list.addBig(OptionInstance.createBoolean(
                I18n.get("options.music_delay_reducer.debugModeToggle"),
                OptionInstance.cachedConstantTooltip(Component.translatable("options.music_delay_reducer.debugModeToggle.tooltip")),
                MDRConfigManager.getConfig().debugModeToggle,
                aBoolean -> MDRConfigManager.getConfig().debugModeToggle = !MDRConfigManager.getConfig().debugModeToggle
        ));
    }

    /**
     * Handles actions to perform when the screen is closed, such as saving changes to the configuration.
     */
    @Override
    public void onClose() {
        if (this.list != null) {
            this.list.applyUnsavedChanges();
        }
        MDRConfigManager.saveConfig();
        this.minecraft.setScreen(this.lastScreen);
    }
}