package net.ragnar.fms_craft.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ragnar.fms_craft.FMSmod;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, FMSmod.MOD_ID);



    public static final RegistryObject<SoundEvent> RONGEM_BREAK = registerSoundEvents("rongem_break");
    public static final RegistryObject<SoundEvent> RONGEM_STEP = registerSoundEvents("rongem_step");
    public static final RegistryObject<SoundEvent> RONGEM_FALL = registerSoundEvents("rongem_fall");
    public static final RegistryObject<SoundEvent> RONGEM_PLACE = registerSoundEvents("rongem_place");
    public static final RegistryObject<SoundEvent> RONGEM_HIT = registerSoundEvents("rongem_hit");

    public static final RegistryObject<SoundEvent> FORTIES_CLUB = registerSoundEvents("forties_club");


    public static final ForgeSoundType RONGEM_BLOCK_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.RONGEM_BREAK, ModSounds.RONGEM_STEP, ModSounds.RONGEM_PLACE, ModSounds.RONGEM_FALL, ModSounds.RONGEM_HIT);
    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(FMSmod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
