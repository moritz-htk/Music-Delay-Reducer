package net.moritz_htk.music_delay_reducer.mixin;

import net.minecraft.client.sounds.MusicManager;
import net.moritz_htk.music_delay_reducer.config.MDRConfigManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Mixin for modifying the behavior of the MusicManager class to integrate the Music Delay Reducer functionality.
 */
@Mixin(MusicManager.class)
public class MDRMusicManagerMixin {
    /**
     * Shadowed field representing the delay before the next song starts.
     */
    @Shadow
    private int nextSongDelay;

    /**
     * Injects custom logic into the tick method of MusicManager.
     * Ensures that the next song delay does not exceed the maximum configured delay time.
     *
     * @param info CallbackInfo provided by the injection.
     */
    @Inject(method = "tick", at = @At("TAIL"))
    private void injectMaxDelayCheck(CallbackInfo info) {
        int timeDelayInTicks = MDRConfigManager.getConfig().delayTime * 60 * 20;
        this.nextSongDelay = Math.min(this.nextSongDelay, timeDelayInTicks);
    }
}