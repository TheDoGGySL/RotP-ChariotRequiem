package com.thedoggy.chariot_requiem_addon.init;

import com.thedoggy.chariot_requiem_addon.ChariotRequiem;
import com.thedoggy.chariot_requiem_addon.action.StandVirus;
import com.thedoggy.chariot_requiem_addon.entity.ChariotRequiemEntity;
import com.github.standobyte.jojo.action.Action;
import com.github.standobyte.jojo.action.stand.*;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.init.power.stand.EntityStandRegistryObject;
import com.github.standobyte.jojo.power.impl.stand.StandInstance.StandPart;
import com.github.standobyte.jojo.power.impl.stand.stats.StandStats;
import com.github.standobyte.jojo.power.impl.stand.type.EntityStandType;
import com.github.standobyte.jojo.power.impl.stand.type.StandType;
import com.github.standobyte.jojo.util.mod.StoryPart;

import com.thedoggy.chariot_requiem_addon.action.ChariotDarkAura;
import com.thedoggy.chariot_requiem_addon.action.ChariotVirus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

public class InitStands {
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<Action<?>> ACTIONS = DeferredRegister.create(
            (Class<Action<?>>) ((Class<?>) Action.class), ChariotRequiem.MOD_ID);
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<StandType<?>> STANDS = DeferredRegister.create(
            (Class<StandType<?>>) ((Class<?>) StandType.class), ChariotRequiem.MOD_ID);
    
 // ======================================== Chariot Requiem ========================================
    

    public static final RegistryObject<StandEntityAction> CHARIOT_REQUIEM_PUNCH = ACTIONS.register("chariot_requiem_punch",
            () -> new StandEntityLightAttack(new StandEntityLightAttack.Builder()
                    .punchSound(InitSounds.CHARIOT_REQUIEM_PUNCH_LIGHT)));
    
    public static final RegistryObject<StandEntityAction> CHARIOT_REQUIEM_BARRAGE = ACTIONS.register("chariot_requiem_barrage",
            () -> new StandEntityMeleeBarrage(new StandEntityMeleeBarrage.Builder()
                    .barrageHitSound(InitSounds.CHARIOT_REQUIEM_PUNCH_BARRAGE)));

    public static final RegistryObject<StandEntityHeavyAttack> CHARIOT_REQUIEM_FINISHER_PUNCH = ACTIONS.register("chariot_requiem_finisher_punch",
            () -> new StandEntityHeavyAttack(new StandEntityHeavyAttack.Builder() // TODO finisher ability
                    .punchSound(InitSounds.CHARIOT_REQUIEM_PUNCH_HEAVY)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<StandEntityHeavyAttack> CHARIOT_REQUIEM_HEAVY_PUNCH = ACTIONS.register("chariot_requiem_heavy_punch",
            () -> new StandEntityHeavyAttack(new StandEntityHeavyAttack.Builder()
                    .shiftVariationOf(CHARIOT_REQUIEM_PUNCH).shiftVariationOf(CHARIOT_REQUIEM_BARRAGE)
                    .setFinisherVariation(CHARIOT_REQUIEM_FINISHER_PUNCH)
                    .punchSound(InitSounds.CHARIOT_REQUIEM_PUNCH_HEAVY)
                    .partsRequired(StandPart.ARMS)));


    public static final RegistryObject<StandEntityAction> CHARIOT_REQUIEM_BLOCK = ACTIONS.register("chariot_requiem_block",
            () -> new StandEntityBlock());


    public static final RegistryObject<StandEntityAction> CHARIOT_REQUIEM_AURA = ACTIONS.register("chariot_requiem_aura",
            () -> new ChariotDarkAura(new StandEntityAction.Builder()
                    .standUserWalkSpeed(0.5f)
                    .holdType(600)
                    .staminaCostTick(3F)
                    .cooldown(600)
                    .resolveLevelToUnlock(1)
                    .standSound(InitSounds.CHARIOT_REQUIEM_AURA)
            ));

    public static final RegistryObject<StandEntityAction> CHARIOT_VIRUS = ACTIONS.register("chariot_requiem_virus",
            () -> new ChariotVirus(new StandEntityAction.Builder()
                    .holdType(50)
                    .staminaCostTick(2F)
                    .cooldown(500)
                    .resolveLevelToUnlock(2)
                    .standOffsetFromUser(0, 1)
                    .standSound(InitSounds.CHARIOT_REQUIEM_YELLOW_VIRUS)
                    .partsRequired(StandPart.ARMS)));

    public static final RegistryObject<StandEntityAction> STAND_VIRUS = ACTIONS.register("chariot_requiem_stand_virus",
            () -> new StandVirus(new StandEntityAction.Builder()
                    .holdType(50)
                    .staminaCostTick(3F)
                    .cooldown(450).shiftVariationOf(CHARIOT_VIRUS)
                    .resolveLevelToUnlock(3)
                    .standOffsetFromUser(0, 1)
                    .standSound(InitSounds.CHARIOT_REQUIEM_VIRUS)
                    .partsRequired(StandPart.MAIN_BODY)));

    public static final EntityStandRegistryObject<EntityStandType<StandStats>, StandEntityType<ChariotRequiemEntity>> STAND_CHARIOT_REQUIEM =
            new EntityStandRegistryObject<>("chariot_requiem",
                    STANDS, 
                    () -> new EntityStandType.Builder<StandStats>()
                    .color(0x1D152F)
                    .storyPartName(StoryPart.GOLDEN_WIND.getName())
                    .leftClickHotbar(
                            CHARIOT_REQUIEM_PUNCH.get(),
                            CHARIOT_REQUIEM_BARRAGE.get()
                            )
                    .rightClickHotbar(
                            CHARIOT_REQUIEM_BLOCK.get(),
                            CHARIOT_REQUIEM_AURA.get(),
                            CHARIOT_VIRUS.get()
                            )
                    .defaultStats(StandStats.class, new StandStats.Builder()
                            .power(15)
                            .speed(5)
                            .range(100, 100)
                            .durability(20)
                            .precision(15)
                            .randomWeight(0)
                            .build())


                    .addOst(InitSounds.CHARIOT_REQUIEM_OST)
                    .build(),
                    
                    InitEntities.ENTITIES,
                    () -> new StandEntityType<ChariotRequiemEntity>(ChariotRequiemEntity::new, 0.7F, 2.1F)
                    .summonSound(InitSounds.CHARIOT_REQUIEM_SUMMON_SOUND)
                    .unsummonSound(InitSounds.CHARIOT_REQUIEM_UNSUMMON_SOUND))
            .withDefaultStandAttributes();
    

    

    
    
    
}
