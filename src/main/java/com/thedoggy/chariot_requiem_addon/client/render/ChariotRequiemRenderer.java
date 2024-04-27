package com.thedoggy.chariot_requiem_addon.client.render;

import com.thedoggy.chariot_requiem_addon.ChariotRequiem;
import com.thedoggy.chariot_requiem_addon.entity.ChariotRequiemEntity;
import com.github.standobyte.jojo.client.render.entity.model.stand.StandEntityModel;
import com.github.standobyte.jojo.client.render.entity.renderer.stand.StandEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class ChariotRequiemRenderer extends StandEntityRenderer<ChariotRequiemEntity, StandEntityModel<ChariotRequiemEntity>> {

    public ChariotRequiemRenderer(EntityRendererManager renderManager) {
        super(renderManager, new ChariotRequiemModel(),
                new ResourceLocation(ChariotRequiem.MOD_ID, "textures/entity/stand/chariot_requiem.png"), 0);
    }
}
