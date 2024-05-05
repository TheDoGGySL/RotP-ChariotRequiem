package com.thedoggy.chariot_requiem_addon;
import com.github.standobyte.jojo.init.power.stand.ModStands;
import com.github.standobyte.jojo.item.StandArrowItem;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.power.impl.stand.type.StandType;
import com.thedoggy.chariot_requiem_addon.init.InitStands;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.thedoggy.chariot_requiem_addon.ChariotRequiem.MOD_ID;


@Mod.EventBusSubscriber(modid = MOD_ID)
public class EventHandler {
    @SubscribeEvent
    public static void onItemUse(PlayerInteractEvent.RightClickItem event) {
        PlayerEntity player = event.getPlayer();
        ItemStack item = player.getItemInHand(event.getHand());
        if (item.getItem() instanceof StandArrowItem) {
            IStandPower.getStandPowerOptional(player).ifPresent(power -> {
                StandType<?> sc = ModStands.SILVER_CHARIOT.getStandType();
                if (power.getType() == sc) {
                    if (power.isActive()) {
                        if (power.getResolveLevel() > 3) {
                            power.clear();
                            power.givePower(InitStands.STAND_CHARIOT_REQUIEM.getStandType());
                            power.toggleSummon();
                            event.setCanceled(true);
                            event.setCancellationResult(ActionResultType.SUCCESS);
                        }
                    }
                }
            });

            }
        }
    }





