package com.thedoggy.chariot_requiem_addon.init;

import com.thedoggy.chariot_requiem_addon.ChariotRequiem;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ChariotRequiem.MOD_ID);

    public static final RegistryObject<BasicParticleType> CHARIOT_VIRUS_PARTICLE = PARTICLES.register("chariot_virus_particle", () -> new BasicParticleType(false));

}

