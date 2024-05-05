package com.thedoggy.chariot_requiem_addon.action;

import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.init.ModSounds;
import com.github.standobyte.jojo.init.ModStatusEffects;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.util.mod.JojoModUtil;
import com.thedoggy.chariot_requiem_addon.init.InitSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.Random;

public class ChariotVirus extends StandEntityAction {
    public ChariotVirus(Builder builder) {
        super(builder);
    }

    // если 2+ игрока будут использовать эту абилку, с большой вероятностью тут будет баг
    // потому что в игре создан только один объект класса ChariotVirus
    // и эти поля будут общими для всех игроков
    private Vector3d pos;

    public boolean main;
    private boolean musicbox = true;
    private int cnt = 0;
    private int musicTicks[] = new int[]{180, 380 ,600};
    private int endTick;
    private static int randIndex;
    private int silenceTicks;
    private ActionTarget victim;
    Random random = new Random();




    @Override
    protected ActionConditionResult checkStandConditions(StandEntity stand, IStandPower power, ActionTarget target) {
        if (power.getStamina() < 250) return ActionConditionResult.NEGATIVE;
        return ActionConditionResult.POSITIVE;
    }

    @Override
    protected void preTaskInit(World world, IStandPower standPower, StandEntity standEntity, ActionTarget target) {
        victim = null;
        if (musicbox) {
            if (!world.isClientSide) {
                cnt = 0;
                silenceTicks = 10 + random.nextInt(40);
                randIndex = random.nextInt(3);
                endTick = musicTicks[randIndex];
                System.out.println(silenceTicks + " " + randIndex + " " + endTick);
            }
        }
    }

    @Override
    public void onTaskSet(World world, StandEntity standEntity, IStandPower standPower, Phase phase, StandEntityTask task, int ticks) {
        ActionTarget target = ActionTarget.fromRayTraceResult(JojoModUtil.rayTrace(standEntity,
                15, standEntity.canTarget(), standEntity.getPrecision() / 16F, standEntity.getPrecision()));
        main = (standEntity.getFinisherMeter() >= 0.95f) && (target.getEntity() instanceof LivingEntity);


            if (target.getEntity() != standEntity && target.getEntity() != null) {
                victim = target;
                pos = target.getTargetPos(true);
                Vector3d shootingVec = Vector3d.directionFromRotation(standEntity.xRot, standEntity.yRot);
                if (!world.isClientSide) {
                    LivingEntity targetEntity = (LivingEntity) target.getEntity();
                    targetEntity.addEffect(new EffectInstance(ModStatusEffects.STAND_VIRUS.get(), 600, 4, true, false));
                    targetEntity.addEffect(new EffectInstance(Effects.BLINDNESS, 600, 4, true, false));
                    targetEntity.addEffect(new EffectInstance(Effects.CONFUSION, 600, 4, true, false));
                    targetEntity.addEffect(new EffectInstance(Effects.WEAKNESS, 600, 4, true, false));
                    standPower.getUser().addEffect(new EffectInstance(Effects.REGENERATION, 100, 4, true, false));
                }
            }
            musicbox = false;
        }


    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (victim == null) victim = ActionTarget.fromRayTraceResult(JojoModUtil.rayTrace(standEntity,
                15, standEntity.canTarget(), standEntity.getPrecision() / 16F, standEntity.getPrecision()));
        if (victim.getEntity() != null && victim.getEntity() != standEntity) {
            pos = victim.getTargetPos(true);
            Vector3d shootingVec = Vector3d.directionFromRotation(standEntity.xRot, standEntity.yRot);
            if (!world.isClientSide && task.getTarget() != null) {
                //victim.getEntity().push(shootingVec.x * 0.8, 0.35f, shootingVec.z * 0.8);
                if (victim.getEntity() instanceof LivingEntity) {
                    LivingEntity targetEntity = (LivingEntity) victim.getEntity();
                    targetEntity.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 500, 4, true, false));
                    targetEntity.addEffect(new EffectInstance(Effects.CONFUSION, 500, 4, true, false));
                    targetEntity.addEffect(new EffectInstance(Effects.BLINDNESS, 500, 4, true, false));
                    targetEntity.addEffect(new EffectInstance(Effects.WEAKNESS, 500, 4, true, false));
                    targetEntity.addEffect(new EffectInstance(ModStatusEffects.STAND_VIRUS.get(), 600, 4, true, false));
                    standEntity.playSound(InitSounds.CHARIOT_REQUIEM_VIRUS.get(), 1.0F, 1.0F);
                }
            }

        }
    }

    @Override
    public void standTickWindup(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if (cnt - silenceTicks <= endTick * 2) {
            task.moveToPhase(Phase.WINDUP, userPower, standEntity);
            if (cnt % 6 == 0 && cnt / 2 < endTick + silenceTicks) {
                userPower.getUser().addEffect(new EffectInstance(ModStatusEffects.FULL_INVISIBILITY.get(), 1, 0, false, false));
                standEntity.addEffect(new EffectInstance(ModStatusEffects.FULL_INVISIBILITY.get(), 1, 0, false, false));
            } else if (cnt % 17 == 0 && cnt / 2 < endTick + silenceTicks) {
                userPower.getUser().addEffect(new EffectInstance(ModStatusEffects.FULL_INVISIBILITY.get(), 3, 0, false, false));
                standEntity.addEffect(new EffectInstance(ModStatusEffects.FULL_INVISIBILITY.get(), 3, 0, false, false));
            } else if (cnt / 2 == endTick) {
                userPower.getUser().addEffect(new EffectInstance(ModStatusEffects.FULL_INVISIBILITY.get(), silenceTicks - 8, 0, false, false));
                standEntity.addEffect(new EffectInstance(ModStatusEffects.FULL_INVISIBILITY.get(), silenceTicks - 8, 0, false, false));
//            task.moveToPhase(Phase.PERFORM,userPower,standEntity);
            }
        }
        main = false;
        cnt++;
    }


        }


