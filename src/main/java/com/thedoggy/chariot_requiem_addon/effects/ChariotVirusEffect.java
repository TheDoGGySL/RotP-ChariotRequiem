package com.thedoggy.chariot_requiem_addon.effects;

import com.github.standobyte.jojo.item.StandArrowItem;
import com.github.standobyte.jojo.potion.UncurableEffect;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.power.impl.stand.StandArrowHandler;
import com.github.standobyte.jojo.power.impl.stand.StandUtil;
import com.github.standobyte.jojo.power.impl.stand.type.StandType;
import com.github.standobyte.jojo.util.mc.damage.DamageUtil;
import com.thedoggy.chariot_requiem_addon.init.InitEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;

public class ChariotVirusEffect extends UncurableEffect {

    public ChariotVirusEffect(int liquidColor) {
        super(EffectType.HARMFUL, liquidColor);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level.isClientSide() && entity instanceof LivingEntity) {
            LivingEntity living = (LivingEntity) entity;

            float damage = 0.15F + amplifier * 0.2F;
            if (damage > entity.getHealth()) {
                damage = 0.001F;

            } else {
                damage *= 10;
            }
            DamageUtil.hurtThroughInvulTicks(entity, DamageUtil.STAND_VIRUS, damage);
        }

    }

    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeModifierManager attributeMap, int amplifier) {
        super.removeAttributeModifiers(entity, attributeMap, amplifier);
        if (!entity.level.isClientSide() && entity.isAlive() && entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            StandType<?> stand = StandUtil.randomStand(player, player.getRandom());
            if (stand != null) {
                IStandPower.getStandPowerOptional(player).ifPresent(
                        power -> StandArrowItem.giveStandFromArrow(player, power, stand));
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 10 == 0;
    }


    public static final int MAX_VIRUS_INHIBITION = 3;

    public static int getEffectLevelToApply(int inhibition) {
        return Math.max(MAX_VIRUS_INHIBITION - inhibition, 0);
    }

    public static int getEffectDurationToApply(PlayerEntity player) {
        return IStandPower.getStandPowerOptional(player).map(power -> {
            StandArrowHandler handler = power.getStandArrowHandler();
            return (handler.getStandXpLevelsRequirement(player.level.isClientSide(), ItemStack.EMPTY) + 1) * 20;
        }).orElse(0);
    }
}


