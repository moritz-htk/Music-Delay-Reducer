package net.moritz_htk.music_delay_reducer.mixin;

import net.minecraft.sound.MusicSound;
import net.minecraft.util.math.MathHelper;
import net.moritz_htk.music_delay_reducer.MusicDelayReducer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MusicSound.class)
public class MDRMusicSoundMixin {
    @Shadow @Final private int minDelay;
    @Shadow @Final private int maxDelay;

    @Inject(method = "getMinDelay", at = @At("RETURN"), cancellable = true)
    public void getMinDelay(CallbackInfoReturnable<Integer> ci) {
        ci.setReturnValue(MathHelper.clamp(MusicDelayReducer.CONFIG.minTime(), MusicDelayReducer.CONFIG.minTime(), MusicDelayReducer.CONFIG.maxTime()) * 20);
    }

    @Inject(method = "getMaxDelay", at = @At("RETURN"), cancellable = true)
    public void getMaxDelay(CallbackInfoReturnable<Integer> ci) {
        ci.setReturnValue(MathHelper.clamp(MusicDelayReducer.CONFIG.maxTime(), MusicDelayReducer.CONFIG.minTime(), MusicDelayReducer.CONFIG.maxTime()) * 20);
    }
}