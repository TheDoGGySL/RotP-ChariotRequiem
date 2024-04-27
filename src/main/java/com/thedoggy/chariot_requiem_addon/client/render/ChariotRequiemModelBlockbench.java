package com.thedoggy.chariot_requiem_addon.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class ChariotRequiemModelBlockbench extends EntityModel<Entity> {
    private final ModelRenderer head;
    private final ModelRenderer cube_r2;
    private final ModelRenderer sh5_r1;
    private final ModelRenderer body;
    private final ModelRenderer upperPart;
    private final ModelRenderer torso;
    private final ModelRenderer torso_r1;
    private final ModelRenderer torso_r2;
    private final ModelRenderer leftArm;
    private final ModelRenderer leftArmJoint;
    private final ModelRenderer leftForeArm;
    private final ModelRenderer leftShoulder_armor;
    private final ModelRenderer bone6_armor;
    private final ModelRenderer bone5_armor;
    private final ModelRenderer rightArm;
    private final ModelRenderer rightArmJoint;
    private final ModelRenderer rightForeArm;
    private final ModelRenderer rightShoulder_armor;
    private final ModelRenderer bone3_armor;
    private final ModelRenderer bone4_armor;
    private final ModelRenderer leftLeg;
    private final ModelRenderer leftLegJoint;
    private final ModelRenderer leftLowerLeg;
    private final ModelRenderer leftLeg_armor;
    private final ModelRenderer rightLeg;
    private final ModelRenderer rightLegJoint;
    private final ModelRenderer rightLowerLeg;
    private final ModelRenderer rightLeg_armor;


    public ChariotRequiemModelBlockbench() {
        texWidth = 128;
        texHeight = 128;

        head = new ModelRenderer(this);
        head.setPos(0.0F, 0.0F, 0.0F);
        head.texOffs(22, 42).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setPos(-4.25F, -4.45F, -0.25F);
        head.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.0F, 0.1309F);
        cube_r2.texOffs(22, 31).addBox(-2.75F, -3.55F, -4.75F, 14.0F, 1.0F, 10.0F, 0.0F, false);
        cube_r2.texOffs(46, 49).addBox(-0.75F, -4.55F, -3.75F, 10.0F, 1.0F, 8.0F, 0.0F, false);
        cube_r2.texOffs(22, 57).addBox(1.25F, -6.55F, -3.75F, 6.0F, 2.0F, 8.0F, 0.0F, false);
        cube_r2.texOffs(22, 67).addBox(-2.75F, -5.55F, -4.75F, 1.0F, 2.0F, 10.0F, 0.0F, false);

        sh5_r1 = new ModelRenderer(this);
        sh5_r1.setPos(4.25F, 28.45F, 0.25F);
        cube_r2.addChild(sh5_r1);
        setRotationAngle(sh5_r1, 0.0F, 0.0F, 1.0472F);
        sh5_r1.texOffs(40, 58).addBox(-33.0F, -16.0F, -5.0F, 1.0F, 5.0F, 10.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setPos(0.0F, 0.0F, 0.0F);


        upperPart = new ModelRenderer(this);
        upperPart.setPos(0.0F, 12.0F, 0.0F);
        body.addChild(upperPart);


        torso = new ModelRenderer(this);
        torso.setPos(0.0F, -12.0F, 0.0F);
        upperPart.addChild(torso);
        torso.texOffs(60, 75).addBox(-1.5F, 0.5F, -2.5F, 3.0F, 3.0F, 5.0F, -0.6F, false);
        torso.texOffs(87, 33).addBox(-0.5F, -0.1F, -0.5F, 1.0F, 12.0F, 1.0F, 0.1F, false);
        torso.texOffs(84, 57).addBox(-2.5F, -0.1F, -2.0F, 1.0F, 2.0F, 4.0F, -0.2F, false);
        torso.texOffs(34, 69).addBox(1.5F, -0.1F, -2.0F, 1.0F, 2.0F, 4.0F, -0.2F, false);
        torso.texOffs(56, 79).addBox(-3.0F, 10.0F, -2.0F, 6.0F, 2.0F, 4.0F, 0.1F, false);
        torso.texOffs(60, 31).addBox(-4.0F, 1.0F, -1.5F, 8.0F, 5.0F, 3.0F, 0.0F, false);
        torso.texOffs(52, 58).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, 0.1F, false);
        torso.texOffs(60, 35).addBox(-3.5F, 0.75F, -2.5F, 7.0F, 2.0F, 1.0F, 0.1F, false);
        torso.texOffs(46, 44).addBox(-3.5F, 2.9F, -2.5F, 1.0F, 1.0F, 1.0F, 0.1F, false);
        torso.texOffs(46, 42).addBox(2.5F, 2.9F, -2.5F, 1.0F, 1.0F, 1.0F, 0.1F, false);
        torso.texOffs(26, 39).addBox(2.5F, 2.9F, 1.5F, 1.0F, 1.0F, 1.0F, 0.1F, false);
        torso.texOffs(22, 39).addBox(-3.5F, 2.9F, 1.5F, 1.0F, 1.0F, 1.0F, 0.1F, false);
        torso.texOffs(69, 34).addBox(-3.5F, 0.75F, 1.5F, 7.0F, 2.0F, 1.0F, 0.1F, false);
        torso.texOffs(46, 42).addBox(-4.0F, 10.0F, -2.0F, 8.0F, 2.0F, 4.0F, 0.2F, false);

        torso_r1 = new ModelRenderer(this);
        torso_r1.setPos(0.0F, 24.0F, 0.0F);
        torso.addChild(torso_r1);
        setRotationAngle(torso_r1, 0.0F, 0.0F, 0.1745F);
        torso_r1.texOffs(78, 32).addBox(-2.75F, -18.0F, -0.5F, 3.0F, 6.0F, 1.0F, 0.0F, false);

        torso_r2 = new ModelRenderer(this);
        torso_r2.setPos(0.0F, 24.0F, 0.0F);
        torso.addChild(torso_r2);
        setRotationAngle(torso_r2, 0.0F, 0.0F, -0.1745F);
        torso_r2.texOffs(52, 33).addBox(-0.25F, -18.0F, -0.5F, 3.0F, 6.0F, 1.0F, 0.0F, false);

        leftArm = new ModelRenderer(this);
        leftArm.setPos(6.0F, -10.0F, 0.0F);
        upperPart.addChild(leftArm);
        leftArm.texOffs(76, 58).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 6.0F, 4.0F, 0.0F, false);

        leftArmJoint = new ModelRenderer(this);
        leftArmJoint.setPos(0.0F, 4.0F, 0.0F);
        leftArm.addChild(leftArmJoint);
        leftArmJoint.texOffs(58, 60).addBox(-1.5F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, -0.1F, false);

        leftForeArm = new ModelRenderer(this);
        leftForeArm.setPos(0.0F, 4.0F, 0.0F);
        leftArm.addChild(leftForeArm);
        leftForeArm.texOffs(38, 83).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 6.0F, 4.0F, -0.001F, false);

        leftShoulder_armor = new ModelRenderer(this);
        leftShoulder_armor.setPos(2.0F, 0.0F, 0.0F);
        leftArm.addChild(leftShoulder_armor);
        setRotationAngle(leftShoulder_armor, 0.7854F, 0.0F, 0.0F);
        leftShoulder_armor.texOffs(80, 88).addBox(-1.5F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F, 0.0F, false);
        leftShoulder_armor.texOffs(86, 55).addBox(-1.0F, 2.0F, -1.5F, 1.0F, 4.0F, 3.0F, 0.0F, false);
        leftShoulder_armor.texOffs(26, 37).addBox(-1.0F, -3.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        leftShoulder_armor.texOffs(66, 88).addBox(-1.0F, -0.5F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);

        bone6_armor = new ModelRenderer(this);
        bone6_armor.setPos(0.5F, -2.0F, -2.0F);
        leftShoulder_armor.addChild(bone6_armor);
        setRotationAngle(bone6_armor, 0.7854F, 0.0F, 0.0F);
        bone6_armor.texOffs(28, 33).addBox(-1.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        bone5_armor = new ModelRenderer(this);
        bone5_armor.setPos(0.5F, -2.0F, 2.0F);
        leftShoulder_armor.addChild(bone5_armor);
        setRotationAngle(bone5_armor, -0.7854F, 0.0F, 0.0F);
        bone5_armor.texOffs(28, 31).addBox(-1.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        rightArm = new ModelRenderer(this);
        rightArm.setPos(-6.0F, -10.0F, 0.0F);
        upperPart.addChild(rightArm);
        rightArm.texOffs(78, 68).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 6.0F, 4.0F, 0.0F, false);

        rightArmJoint = new ModelRenderer(this);
        rightArmJoint.setPos(0.0F, 4.0F, 0.0F);
        rightArm.addChild(rightArmJoint);
        rightArmJoint.texOffs(56, 55).addBox(-0.5F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, -0.1F, false);

        rightForeArm = new ModelRenderer(this);
        rightForeArm.setPos(0.0F, 4.0F, 0.0F);
        rightArm.addChild(rightForeArm);
        rightForeArm.texOffs(52, 85).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 6.0F, 4.0F, -0.001F, false);

        rightShoulder_armor = new ModelRenderer(this);
        rightShoulder_armor.setPos(-2.5F, 0.0F, 0.0F);
        rightArm.addChild(rightShoulder_armor);
        setRotationAngle(rightShoulder_armor, 0.7854F, 0.0F, 0.0F);
        rightShoulder_armor.texOffs(22, 89).addBox(0.0F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F, 0.0F, false);
        rightShoulder_armor.texOffs(86, 55).addBox(0.5F, 2.0F, -1.5F, 1.0F, 4.0F, 3.0F, 0.0F, false);
        rightShoulder_armor.texOffs(22, 37).addBox(0.5F, -3.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        rightShoulder_armor.texOffs(66, 88).addBox(0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);

        bone3_armor = new ModelRenderer(this);
        bone3_armor.setPos(0.0F, -2.0F, -2.0F);
        rightShoulder_armor.addChild(bone3_armor);
        setRotationAngle(bone3_armor, 0.7854F, 0.0F, 0.0F);
        bone3_armor.texOffs(22, 33).addBox(0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        bone4_armor = new ModelRenderer(this);
        bone4_armor.setPos(0.0F, -2.0F, 2.0F);
        rightShoulder_armor.addChild(bone4_armor);
        setRotationAngle(bone4_armor, -0.7854F, 0.0F, 0.0F);
        bone4_armor.texOffs(22, 31).addBox(0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        leftLeg = new ModelRenderer(this);
        leftLeg.setPos(1.9F, 12.0F, 0.0F);
        body.addChild(leftLeg);
        leftLeg.texOffs(70, 39).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

        leftLegJoint = new ModelRenderer(this);
        leftLegJoint.setPos(0.0F, 6.0F, 0.0F);
        leftLeg.addChild(leftLegJoint);
        leftLegJoint.texOffs(67, 33).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, false);

        leftLowerLeg = new ModelRenderer(this);
        leftLowerLeg.setPos(0.0F, 6.0F, 0.0F);
        leftLeg.addChild(leftLowerLeg);
        leftLowerLeg.texOffs(22, 79).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, -0.001F, false);

        leftLeg_armor = new ModelRenderer(this);
        leftLeg_armor.setPos(0.0F, 0.0F, 0.0F);
        leftLeg.addChild(leftLeg_armor);
        leftLeg_armor.texOffs(85, 49).addBox(1.85F, 0.0F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
        leftLeg_armor.texOffs(76, 49).addBox(1.85F, 1.0F, -2.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);

        rightLeg = new ModelRenderer(this);
        rightLeg.setPos(-1.9F, 12.0F, 0.0F);
        body.addChild(rightLeg);
        rightLeg.texOffs(60, 75).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

        rightLegJoint = new ModelRenderer(this);
        rightLegJoint.setPos(0.0F, 6.0F, 0.0F);
        rightLeg.addChild(rightLegJoint);
        rightLegJoint.texOffs(69, 32).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, -0.1F, false);

        rightLowerLeg = new ModelRenderer(this);
        rightLowerLeg.setPos(0.0F, 6.0F, 0.0F);
        rightLeg.addChild(rightLowerLeg);
        rightLowerLeg.texOffs(44, 73).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, -0.001F, false);

        rightLeg_armor = new ModelRenderer(this);
        rightLeg_armor.setPos(0.0F, 0.0F, 0.0F);
        rightLeg.addChild(rightLeg_armor);
        rightLeg_armor.texOffs(66, 86).addBox(-2.85F, 0.0F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
        rightLeg_armor.texOffs(34, 69).addBox(-2.85F, 1.0F, -2.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}