package dev.toxicaven.mixins;

import dev.toxicaven.audio.DisableSound;
import dev.toxicaven.audio.EnableSound;
import com.lambda.client.module.AbstractModule;
import com.lambda.client.setting.settings.impl.primitive.BooleanSetting;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractModule.class)
public class MixinMinecraft {
    @Final @Shadow
    private BooleanSetting enabled;

    // I didn't make a static field for Minecraft, it got shadowed for some reason and caused a mess

    @Inject(method = "toggle", at = @At("TAIL"), remap = false)
    public void onToggle(CallbackInfo ci) {
        try {
            if (Minecraft.getMinecraft().player != null && Minecraft.getMinecraft().world != null) {
                if (enabled.getValue()) {
                    Minecraft.getMinecraft().getSoundHandler().playSound(EnableSound.INSTANCE);
                } else {
                    Minecraft.getMinecraft().getSoundHandler().playSound(DisableSound.INSTANCE);
                }
            }
        } catch (IllegalArgumentException ignored) {
            // If you spam the toggle button, it will throw an exception
        }
    }
}