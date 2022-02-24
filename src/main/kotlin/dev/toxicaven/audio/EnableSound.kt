package dev.toxicaven.audio

import net.minecraft.client.audio.ISound
import net.minecraft.client.audio.Sound
import net.minecraft.client.audio.SoundEventAccessor
import net.minecraft.client.audio.SoundHandler
import net.minecraft.util.ResourceLocation
import net.minecraft.util.SoundCategory

object EnableSound : ISound {
    private val location = ResourceLocation("sounds/enable.ogg")

    override fun getSoundLocation(): ResourceLocation {
        return location
    }

    override fun createAccessor(handler: SoundHandler): SoundEventAccessor {
        return SoundEventAccessor(location, "Enabled Module")
    }

    override fun getSound(): Sound {
        return Sound("enable", 100000f, 1.0f, 1, Sound.Type.SOUND_EVENT, false)
    }

    override fun getCategory(): SoundCategory {
        return SoundCategory.AMBIENT
    }

    override fun canRepeat(): Boolean {
        return false
    }

    override fun getRepeatDelay(): Int {
        return 0
    }

    override fun getVolume(): Float {
        return 100000.0f
    }

    override fun getPitch(): Float {
        return 1.0f
    }

    override fun getXPosF(): Float {
        return 1.0f
    }

    override fun getYPosF(): Float {
        return 0.0f
    }

    override fun getZPosF(): Float {
        return 0.0f
    }

    override fun getAttenuationType(): ISound.AttenuationType {
        return ISound.AttenuationType.LINEAR
    }
}