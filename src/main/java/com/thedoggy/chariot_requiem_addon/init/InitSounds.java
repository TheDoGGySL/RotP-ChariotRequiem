package com.thedoggy.chariot_requiem_addon.init;

import java.util.function.Supplier;

import com.github.standobyte.jojo.init.ModSounds;
import com.github.standobyte.jojo.util.mc.OstSoundList;

import com.thedoggy.chariot_requiem_addon.ChariotRequiem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(
            ForgeRegistries.SOUND_EVENTS, ChariotRequiem.MOD_ID); // TODO sounds.json


    public static final Supplier<SoundEvent> CHARIOT_REQUIEM_SUMMON_SOUND = ModSounds.STAND_SUMMON_DEFAULT;
    
    public static final Supplier<SoundEvent> CHARIOT_REQUIEM_UNSUMMON_SOUND = ModSounds.STAND_UNSUMMON_DEFAULT;
    
    public static final Supplier<SoundEvent> CHARIOT_REQUIEM_PUNCH_LIGHT = ModSounds.STAND_PUNCH_LIGHT;
    
    public static final Supplier<SoundEvent> CHARIOT_REQUIEM_PUNCH_HEAVY = ModSounds.STAND_PUNCH_HEAVY;
    
    public static final Supplier<SoundEvent> CHARIOT_REQUIEM_PUNCH_BARRAGE = ModSounds.STAND_PUNCH_LIGHT;

    public static final OstSoundList CHARIOT_REQUIEM_OST = new OstSoundList(
            new ResourceLocation(ChariotRequiem.MOD_ID, "chariot_requiem_ost"), SOUNDS);


}
