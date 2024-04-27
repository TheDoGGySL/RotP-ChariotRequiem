package com.thedoggy.chariot_requiem_addon.action;

import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.init.ModSounds;
import com.github.standobyte.jojo.init.ModStatusEffects;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.util.mc.MCUtil;
import com.github.standobyte.jojo.util.mod.JojoModUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ChariotDarkAura extends StandEntityAction {

    public ChariotDarkAura(Builder builder) {
        super(builder);
    }



    @Override
    protected  ActionConditionResult checkStandConditions(StandEntity stand, IStandPower power, ActionTarget target) {
        if (power.getStamina() < 300) return ActionConditionResult.NEGATIVE;
        return ActionConditionResult.POSITIVE;


    }
    @Override
    public int getHoldDurationToFire(IStandPower power) {
        return shortenedHoldDuration(power, super.getHoldDurationToFire(power));
    }

    private int shortenedHoldDuration(IStandPower power, int ticks) {
        return ticks > 0 && power.getResolveLevel() >= 4 ? 20 : ticks;
    }

    @Override
    public boolean cancelHeldOnGettingAttacked(IStandPower power, DamageSource dmgSource, float dmgAmount) {
        return true;
    }

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        int difficulty = world.getDifficulty().getId();
        int range = 50;
        if (!world.isClientSide()) {
            for (LivingEntity entity : MCUtil.entitiesAround(
                    LivingEntity.class, userPower.getUser(), range, false, entity ->
                            !JojoModUtil.isUndead(entity) && !(entity instanceof StandEntity && userPower.getUser().is(((StandEntity) entity).getUser())))) {
                int amplifier = MathHelper.floor((difficulty - 1) * 3);
                int duration = 600;
                entity.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, duration, amplifier));
                entity.addEffect(new EffectInstance(Effects.WEAKNESS, duration, amplifier));
                entity.addEffect(new EffectInstance(Effects.DIG_SLOWDOWN, duration, amplifier));
                entity.addEffect(new EffectInstance(Effects.CONFUSION, duration, amplifier));
                entity.addEffect(new EffectInstance(Effects.BLINDNESS, duration, amplifier));
                entity.addEffect(new EffectInstance(ModStatusEffects.STUN.get(), duration, amplifier));


                }
            standEntity.playSound(ModSounds.VAMPIRE_CURE_START .get(), 1.0F, 1.0F);
            }

        }
    }






