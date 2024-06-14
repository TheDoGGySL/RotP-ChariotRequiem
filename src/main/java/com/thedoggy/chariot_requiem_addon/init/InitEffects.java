package com.thedoggy.chariot_requiem_addon.init;

import com.thedoggy.chariot_requiem_addon.ChariotRequiem;
import com.thedoggy.chariot_requiem_addon.effects.ChariotVirusEffect;
import net.minecraft.potion.Effect;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitEffects {

    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, ChariotRequiem.MOD_ID);

    public static final RegistryObject<Effect> CHARIOT_VIRUS = EFFECTS.register("chariot_virus_effect",
            () -> new ChariotVirusEffect(0xFFEB81));


}
