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


    public static final Supplier<SoundEvent> CHARIOT_REQUIEM_SUMMON_SOUND = SOUNDS.register("scr_summon",
            () -> new SoundEvent(new ResourceLocation(ChariotRequiem.MOD_ID, "scr_summon")));

    public static final Supplier<SoundEvent> CHARIOT_REQUIEM_UNSUMMON_SOUND = SOUNDS.register("scr_unsummon",
            () -> new SoundEvent(new ResourceLocation(ChariotRequiem.MOD_ID,"scr_unsummon")));
    
    public static final Supplier<SoundEvent> CHARIOT_REQUIEM_PUNCH_LIGHT = SOUNDS.register("scr_punch",
            () -> new SoundEvent(new ResourceLocation(ChariotRequiem.MOD_ID,"scr_punch")));
    public static final Supplier<SoundEvent> CHARIOT_REQUIEM_PUNCH_HEAVY = SOUNDS.register("scr_punch_heavy",
            () -> new SoundEvent(new ResourceLocation(ChariotRequiem.MOD_ID,"scr_punch_heavy")));

    public static final Supplier<SoundEvent> CHARIOT_REQUIEM_AURA = SOUNDS.register("scr_ability_1",
            () -> new SoundEvent(new ResourceLocation(ChariotRequiem.MOD_ID,"scr_ability_1")));

    public static final Supplier<SoundEvent> CHARIOT_REQUIEM_VIRUS = SOUNDS.register("scr_ability_2",
            () -> new SoundEvent(new ResourceLocation(ChariotRequiem.MOD_ID,"scr_ability_2")));
    public static final Supplier<SoundEvent> CHARIOT_REQUIEM_PUNCH_BARRAGE = InitSounds.CHARIOT_REQUIEM_PUNCH_LIGHT;

    public static final OstSoundList CHARIOT_REQUIEM_OST = new OstSoundList(
            new ResourceLocation(ChariotRequiem.MOD_ID, "chariot_requiem_ost"), SOUNDS);


}
