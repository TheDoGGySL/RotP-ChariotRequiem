package com.thedoggy.chariot_requiem_addon.client.playeranim.anim;

import com.github.standobyte.jojo.client.playeranim.PlayerAnimationHandler;
import com.github.standobyte.jojo.client.playeranim.anim.interfaces.WindupAttackAnim;
import com.thedoggy.chariot_requiem_addon.ChariotRequiem;
import net.minecraft.util.ResourceLocation;

public class AddonPlayersAnimation {
    public static WindupAttackAnim arrow;

    public static void init(){
        arrow = PlayerAnimationHandler.getPlayerAnimator().registerAnimLayer(
                "com.thedoggy.chariot_requiem_addon.client.playeranim.anim.kosmximpl.KosmXArrow",
                new ResourceLocation(ChariotRequiem.MOD_ID, "arrow"), 1,
                WindupAttackAnim.NoPlayerAnimator::new);
    }
}
