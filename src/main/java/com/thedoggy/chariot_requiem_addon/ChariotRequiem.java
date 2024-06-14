package com.thedoggy.chariot_requiem_addon;

import com.thedoggy.chariot_requiem_addon.init.InitEntities;
import com.thedoggy.chariot_requiem_addon.init.InitSounds;
import com.thedoggy.chariot_requiem_addon.init.InitStands;
import com.thedoggy.chariot_requiem_addon.init.InitParticles;
import com.thedoggy.chariot_requiem_addon.init.InitEffects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(ChariotRequiem.MOD_ID)
public class ChariotRequiem {
    public static final String MOD_ID = "rotp_cr";
    public static final Logger LOGGER = LogManager.getLogger();

    public ChariotRequiem() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        InitEntities.ENTITIES.register(modEventBus);
        InitSounds.SOUNDS.register(modEventBus);
        InitStands.ACTIONS.register(modEventBus);
        InitStands.STANDS.register(modEventBus);
        InitEffects.EFFECTS.register(modEventBus);
        InitParticles.PARTICLES.register((modEventBus));


        }
    }