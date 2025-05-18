package com.thedoggy.chariot_requiem_addon.mixin;

import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.client.controls.ControlScheme;
import com.github.standobyte.jojo.init.power.stand.ModStandsInit;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.power.impl.stand.type.StandType;
import com.thedoggy.chariot_requiem_addon.init.InitStands;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = StandType.class, remap = false)
public abstract class StandTypeMixin {


    @Inject(method = "Lcom/github/standobyte/jojo/power/impl/stand/type/StandType;isActionLegalInHud(Lcom/github/standobyte/jojo/action/Action;Lcom/github/standobyte/jojo/power/impl/stand/IStandPower;)Z", at = @At("RETURN"), cancellable = true)
    private void isActionLegalInHud(Action<IStandPower> action, IStandPower power, CallbackInfoReturnable<Boolean> cir){
        if(action == InitStands.ARROW.get() && power.getType() == ModStandsInit.STAND_SILVER_CHARIOT.getStandType() && power.getResolveLevel()>3){
            cir.cancel();
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "Lcom/github/standobyte/jojo/power/impl/stand/type/StandType;clAddMissingActions(Lcom/github/standobyte/jojo/client/controls/ControlScheme;Lcom/github/standobyte/jojo/power/impl/stand/IStandPower;)V", at = @At("TAIL"))
    private void clAddMissingActions(ControlScheme controlScheme, IStandPower power, CallbackInfo ci){
        if(power.getType() == ModStandsInit.STAND_SILVER_CHARIOT.getStandType() && power.getResolveLevel() > 3){
            controlScheme.addIfMissing(ControlScheme.Hotbar.RIGHT_CLICK,InitStands.ARROW.get());

        }
    }


}
