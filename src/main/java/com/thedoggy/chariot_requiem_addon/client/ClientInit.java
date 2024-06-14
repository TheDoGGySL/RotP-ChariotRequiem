package com.thedoggy.chariot_requiem_addon.client;

import com.github.standobyte.jojo.client.particle.MeteoriteVirusParticle;
import com.github.standobyte.jojo.client.particle.custom.CustomParticlesHelper;
import com.github.standobyte.jojo.client.resources.CustomResources;
import com.thedoggy.chariot_requiem_addon.ChariotRequiem;
import com.thedoggy.chariot_requiem_addon.client.render.ChariotRequiemRenderer;
import com.thedoggy.chariot_requiem_addon.init.InitParticles;
import com.thedoggy.chariot_requiem_addon.init.InitStands;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = ChariotRequiem.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientInit {
    
    @SubscribeEvent
    public static void onFMLClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(
                InitStands.STAND_CHARIOT_REQUIEM.getEntityType(), ChariotRequiemRenderer::new);
    }

        @SubscribeEvent
        public static void onMcConstructor(ParticleFactoryRegisterEvent event) {
            Minecraft mc = Minecraft.getInstance();
            mc.particleEngine.register(InitParticles.CHARIOT_VIRUS_PARTICLE.get(), MeteoriteVirusParticle.Factory::new);
            CustomParticlesHelper.saveSprites(mc);
            CustomResources.initCustomResourceManagers(mc);
    }}





