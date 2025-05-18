package com.thedoggy.chariot_requiem_addon.action;

import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.init.ModItems;
import com.github.standobyte.jojo.init.power.stand.ModStandsInit;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.thedoggy.chariot_requiem_addon.client.playeranim.anim.AddonPlayersAnimation;
import com.thedoggy.chariot_requiem_addon.init.InitStands;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class SilverChariotArrow extends StandEntityAction {

    public SilverChariotArrow(StandEntityAction.Builder builder){
        super(builder);
    }

    @Override
    protected ActionConditionResult checkHeldItems(LivingEntity user, IStandPower power) {
        if(user.getOffhandItem().getItem() == ModItems.STAND_ARROW.get() ||user.getOffhandItem().getItem() == ModItems.STAND_ARROW_BEETLE.get()){
            return ActionConditionResult.POSITIVE;
        }
        return ActionConditionResult.NEGATIVE;
    }

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        if(!world.isClientSide){
            userPower.clear();
            userPower.givePower(InitStands.STAND_CHARIOT_REQUIEM.getStandType());
            userPower.toggleSummon();
        }
    }

    @Override
    public boolean isUnlocked(IStandPower power) {
        return power.getResolveLevel() >3 && power.getType() == ModStandsInit.STAND_SILVER_CHARIOT.getStandType();
    }

    @Override
    public boolean clHeldStartAnim(PlayerEntity user) {
        return AddonPlayersAnimation.arrow.setWindupAnim(user);
    }

    @Override
    public void clHeldStopAnim(PlayerEntity user) {
        AddonPlayersAnimation.arrow.stopAnim(user);
    }
}
