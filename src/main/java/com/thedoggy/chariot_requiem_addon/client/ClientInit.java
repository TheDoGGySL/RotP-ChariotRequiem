package com.thedoggy.chariot_requiem_addon.client;

import com.thedoggy.chariot_requiem_addon.ChariotRequiem;
import com.thedoggy.chariot_requiem_addon.client.render.ChariotRequiemRenderer;
import com.thedoggy.chariot_requiem_addon.init.InitStands;
import net.minecraftforge.api.distmarker.Dist;
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



    }}





