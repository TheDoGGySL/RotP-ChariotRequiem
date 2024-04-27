package com.thedoggy.chariot_requiem_addon.client.render;

import com.thedoggy.chariot_requiem_addon.entity.ChariotRequiemEntity;
import com.github.standobyte.jojo.client.render.entity.model.stand.HumanoidStandModel;
import com.github.standobyte.jojo.client.render.entity.model.stand.bb.BlockbenchStandModelHelper;
import com.github.standobyte.jojo.client.render.entity.pose.ModelPose;
import com.github.standobyte.jojo.client.render.entity.pose.RotationAngle;


// Made with Blockbench 4.8.1
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class ChariotRequiemModel extends HumanoidStandModel<ChariotRequiemEntity> {


	public ChariotRequiemModel() {
		super();

		BlockbenchStandModelHelper.fillFromBlockbenchExport(new ChariotRequiemModelBlockbench(), this);
	}

	@Override // TODO summon poses
    protected RotationAngle[][] initSummonPoseRotations() {
        return new RotationAngle[][] {
                new RotationAngle[] {
                        RotationAngle.fromDegrees(head, 2.5F, 0F, 0.0F),
                        RotationAngle.fromDegrees(leftArm, 56.06876F, -46.85041F, -20.09752F),
                        RotationAngle.fromDegrees(rightArm, -172.8532F, -3.7147F, -5.9166F),
                        RotationAngle.fromDegrees(leftLeg, 0.0F, 0.0F, -10.0F),
                        RotationAngle.fromDegrees(rightLeg, 0.0F, 0.0F, 10.0F),
                },
            new RotationAngle[] {
                    RotationAngle.fromDegrees(head, -35F, 0F, 0.0F),
                    RotationAngle.fromDegrees(leftArm, -141.7439F, -8.3109F, -21.3376),
                    RotationAngle.fromDegrees(rightArm, 30.4171F, 17.7863F, 31.1453F),
                    RotationAngle.fromDegrees(leftLeg, 0.0F, 0.0F, -15.0F),
                    RotationAngle.fromDegrees(rightLeg, 0.0F, 0.0F, 12.5F),
            }
		};
    }




    @Override
    public void prepareMobModel(ChariotRequiemEntity entity, float walkAnimPos, float walkAnimSpeed, float partialTick) {
        super.prepareMobModel(entity, walkAnimPos, walkAnimSpeed, partialTick);

        }




    @Override // TODO idle pose
    protected ModelPose<ChariotRequiemEntity> initIdlePose() {
        return new ModelPose<>(new RotationAngle[] {
                RotationAngle.fromDegrees(head, 0.0F, 0F, 0F),
                RotationAngle.fromDegrees(body, 5.7686F, 29.8742F, 5.3807F),
                RotationAngle.fromDegrees(leftArm, 9.7216F, 0.7779F, -10.1423F),
                RotationAngle.fromDegrees(leftForeArm, -7.2684F, -0.9167F, -2.3162F),
                RotationAngle.fromDegrees(rightArm, 2.5F, 0F, 10F),
                RotationAngle.fromDegrees(rightForeArm, -15F, 0F, 0F),
                RotationAngle.fromDegrees(leftLeg, 5F, 2.5F, -5.5F),
                RotationAngle.fromDegrees(leftLowerLeg, 0F, 2.5F, -7.5F),
                RotationAngle.fromDegrees(rightLeg, 7.9315F, -12.0964F, -4.5742F),
                RotationAngle.fromDegrees(rightLowerLeg, 7.5F, 0F, 0F)
        });
    }

    @Override
    protected ModelPose<ChariotRequiemEntity> initIdlePose2Loop() {
        return new ModelPose<>(new RotationAngle[]{
                RotationAngle.fromDegrees(leftArm, 9.5399F, 2.0343F, -17.5387F),
                RotationAngle.fromDegrees(leftForeArm, -14.7684F, -0.9167F, -2.3162F),
                RotationAngle.fromDegrees(rightArm, 2.4786F, -0.3262F, 17.4929F),
                RotationAngle.fromDegrees(rightForeArm, -27.5F, 0F, 0F),
                RotationAngle.fromDegrees(leftLowerLeg, 5F, 2.5F, -7.5F),
                RotationAngle.fromDegrees(rightLowerLeg, 12.5F, 0F, 0F)
        });
    }

    }
