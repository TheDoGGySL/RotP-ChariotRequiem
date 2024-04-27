package com.thedoggy.chariot_requiem_addon.init;

import com.thedoggy.chariot_requiem_addon.ChariotRequiem;
import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(
            ForgeRegistries.ENTITIES, ChariotRequiem.MOD_ID);
    

};
