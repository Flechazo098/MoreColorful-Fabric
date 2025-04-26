package com.ChalkerCharles.morecolorful.util;

import com.ChalkerCharles.morecolorful.common.block.ModBlocks;
import com.ChalkerCharles.morecolorful.common.item.ModItems;
import com.chocohead.mm.api.ClassTinkerers;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;

import java.util.function.Supplier;

public class EarlyRiser implements Runnable{
    @Override
    public void run () {
        registerArmPoses();
        registerBoatTypes();
    }

    private void registerArmPoses () {
        // 使用String方式指定构造函数参数类型，避免过早加载Minecraft类
        var armPoseBuilder = ClassTinkerers.enumBuilder("net.minecraft.client.model.HumanoidModel$ArmPose",
                "Z", "net/minecraft/client/model/HumanoidModel$ArmPoseTransformer");

        // FLUTE
        armPoseBuilder.addEnum("MORECOLORFUL_FLUTE", () -> new Object[]{
                true,
                (ArmPoseTransformer) ((model, entity, arm) -> {
                    if (arm == HumanoidArm.RIGHT) {
                        model.rightArm.xRot = -0.364023F - model.head.xRot / 2 + model.head.yRot / 2;
                        model.rightArm.yRot = 0.36029F - Math.abs(model.head.yRot / 2) - model.head.xRot / 2;
                        model.rightArm.zRot = 1.888971F - model.head.xRot / 4 + model.head.yRot / 4;
                        model.rightArm.y -= 2;
                        model.leftArm.xRot = -1.600489F + model.head.xRot / 2 - model.head.yRot / 4;
                        model.leftArm.yRot = 1.030029F + model.head.yRot / 2 - model.head.xRot / 4;
                        model.leftArm.zRot = 0.172297F;
                        model.leftArm.x -= 1;
                        model.leftArm.y -= 1;
                        model.leftArm.z -= 1;
                    } else {
                        model.leftArm.xRot = -0.364023F - model.head.xRot / 2 - model.head.yRot / 2;
                        model.leftArm.yRot = -0.36029F + Math.abs(model.head.yRot / 2) + model.head.xRot / 2;
                        model.leftArm.zRot = -1.888971F + model.head.xRot / 4 + model.head.yRot / 4;
                        model.leftArm.y -= 2;
                        model.rightArm.xRot = -1.600489F + model.head.xRot / 2 + model.head.yRot / 4;
                        model.rightArm.yRot = -1.030029F + model.head.yRot / 2 + model.head.xRot / 4;
                        model.rightArm.zRot = -0.172297F;
                        model.rightArm.x += 1;
                        model.rightArm.y -= 1;
                        model.rightArm.z -= 1;
                    }
                })
        });

        // GUITAR_HOLD
        armPoseBuilder.addEnum("MORECOLORFUL_GUITAR_HOLD", () -> new Object[]{
                true,
                (ArmPoseTransformer) ((model, entity, arm) -> {
                    if (arm == HumanoidArm.RIGHT) {
                        model.rightArm.xRot = -0.26179938F;
                        model.leftArm.xRot = -0.62831852F;
                    } else {
                        model.rightArm.xRot = -0.62831852F;
                        model.leftArm.xRot = -0.26179938F;
                    }
                })
        });

        // GUITAR_PLAYING
        armPoseBuilder.addEnum("MORECOLORFUL_GUITAR_PLAYING", () -> new Object[]{
                true,
                (ArmPoseTransformer) ((model, entity, arm) -> {
                    if (arm == HumanoidArm.RIGHT) {
                        model.rightArm.xRot = -0.26179938F;
                        model.leftArm.xRot = -0.62831852F;
                        AnimationUtils.animateGuitarPlaying(model.rightArm, model.leftArm, entity, true);
                    } else {
                        model.rightArm.xRot = -0.62831852F;
                        model.leftArm.xRot = -0.26179938F;
                        AnimationUtils.animateGuitarPlaying(model.rightArm, model.leftArm, entity, false);
                    }
                })
        });

        // COW_BELL
        armPoseBuilder.addEnum("MORECOLORFUL_COW_BELL", () -> new Object[]{
                false,
                (ArmPoseTransformer) ((model, entity, arm) -> {
                    if (arm == HumanoidArm.RIGHT) {
                        model.rightArm.xRot = -1.308998F;
                        model.rightArm.yRot = -0.174533F;
                        model.leftArm.xRot = model.leftArm.xRot * 0.5F - (float) (Math.PI / 10);
                    } else {
                        model.leftArm.xRot = -1.308998F;
                        model.leftArm.yRot = 0.174533F;
                        model.rightArm.xRot = model.rightArm.xRot * 0.5F - (float) (Math.PI / 10);
                    }
                })
        });

        // DIDGERIDOO
        armPoseBuilder.addEnum("MORECOLORFUL_DIDGERIDOO", () -> new Object[]{
                true,
                (ArmPoseTransformer) ((model, entity, arm) -> {
                    model.rightArm.xRot = -1.221731F;
                    model.leftArm.xRot = -1.221731F;
                    model.rightArm.yRot = -0.218166F;
                    model.leftArm.yRot = 0.218166F;
                    model.rightArm.zRot = -0.174533F;
                    model.leftArm.zRot = 0.174533F;
                    model.rightArm.x += 0.5F;
                    model.leftArm.x -= 0.5F;
                })
        });

        // VIOLIN_HOLD
        armPoseBuilder.addEnum("MORECOLORFUL_VIOLIN_HOLD", () -> new Object[]{
                true,
                (ArmPoseTransformer) ((model, entity, arm) -> {
                    if (arm == HumanoidArm.RIGHT) {
                        model.rightArm.xRot = -1.178098F;
                        model.rightArm.yRot = 0.087267F;
                        model.rightArm.zRot = 0.392699F;
                        model.leftArm.xRot = -1.570797F;
                    } else {
                        model.leftArm.xRot = -1.178098F;
                        model.leftArm.yRot = -0.087267F;
                        model.leftArm.zRot = -0.392699F;
                        model.rightArm.xRot = -1.570797F;
                    }
                })
        });

        // VIOLIN_PLAYING
        armPoseBuilder.addEnum("MORECOLORFUL_VIOLIN_PLAYING", () -> new Object[]{
                true,
                (ArmPoseTransformer) ((model, entity, arm) -> {
                    if (arm == HumanoidArm.RIGHT) {
                        model.rightArm.xRot = -1.178098F;
                        model.rightArm.yRot = 0.087267F;
                        model.rightArm.zRot = 0.392699F;
                        model.leftArm.xRot = -1.570797F;
                        AnimationUtils.animateViolinPlaying(model.rightArm, model.leftArm, entity, true);
                    } else {
                        model.leftArm.xRot = -1.178098F;
                        model.leftArm.yRot = -0.087267F;
                        model.leftArm.zRot = -0.392699F;
                        model.rightArm.xRot = -1.570797F;
                        AnimationUtils.animateViolinPlaying(model.rightArm, model.leftArm, entity, false);
                    }
                })
        });

        // CELLO
        armPoseBuilder.addEnum("MORECOLORFUL_CELLO", () -> new Object[]{
                false,
                (ArmPoseTransformer) ((model, entity, arm) -> {
                    if (arm == HumanoidArm.RIGHT) {
                        model.rightArm.xRot = -1.483531F;
                        model.rightArm.yRot = -0.043633F;
                        model.rightArm.zRot = -0.087267F;
                        model.rightArm.y += 1;
                    } else {
                        model.leftArm.xRot = -1.483531F;
                        model.leftArm.yRot = 0.043633F;
                        model.leftArm.zRot = 0.087267F;
                        model.leftArm.y += 1;
                    }
                })
        });

        // CELLO_HOLD
        armPoseBuilder.addEnum("MORECOLORFUL_CELLO_HOLD", () -> new Object[]{
                true,
                (ArmPoseTransformer) ((model, entity, arm) -> {
                    if (arm == HumanoidArm.RIGHT) {
                        model.rightArm.xRot = -1.483531F;
                        model.rightArm.yRot = -0.043633F;
                        model.rightArm.zRot = -0.087267F;
                        model.rightArm.y += 1;
                        model.leftArm.xRot = -0.872665F;
                        model.leftArm.y -= 1;
                    } else {
                        model.leftArm.xRot = -1.483531F;
                        model.leftArm.yRot = 0.043633F;
                        model.leftArm.zRot = 0.087267F;
                        model.leftArm.y += 1;
                        model.rightArm.xRot = -0.872665F;
                        model.rightArm.y -= 1;
                    }
                })
        });

        // CELLO_PLAYING
        armPoseBuilder.addEnum("MORECOLORFUL_CELLO_PLAYING", () -> new Object[]{
                true,
                (ArmPoseTransformer) ((model, entity, arm) -> {
                    if (arm == HumanoidArm.RIGHT) {
                        model.rightArm.xRot = -1.483531F;
                        model.rightArm.yRot = -0.043633F;
                        model.rightArm.zRot = -0.087267F;
                        model.rightArm.y += 1;
                        model.leftArm.xRot = -0.872665F;
                        model.leftArm.y -= 1;
                        AnimationUtils.animateCelloPlaying(model.rightArm, model.leftArm, entity, true);
                    } else {
                        model.leftArm.xRot = -1.483531F;
                        model.leftArm.yRot = 0.043633F;
                        model.leftArm.zRot = 0.087267F;
                        model.leftArm.y += 1;
                        model.rightArm.xRot = -0.872665F;
                        model.rightArm.y -= 1;
                        AnimationUtils.animateCelloPlaying(model.rightArm, model.leftArm, entity, false);
                    }
                })
        });

        // SAXOPHONE
        armPoseBuilder.addEnum("MORECOLORFUL_SAXOPHONE", () -> new Object[]{
                true,
                (ArmPoseTransformer) ((model, entity, arm) -> {
                    model.rightArm.xRot = -1.047198F;
                    model.leftArm.xRot = -1.047198F;
                    model.rightArm.yRot = -0.218166F;
                    model.leftArm.yRot = 0.218166F;
                    model.rightArm.zRot = -0.174533F;
                    model.leftArm.zRot = 0.174533F;
                    model.rightArm.x += 0.5F;
                    model.leftArm.x -= 0.5F;
                })
        });

        // PIPA_HOLD
        armPoseBuilder.addEnum("MORECOLORFUL_PIPA_HOLD", () -> new Object[]{
                true,
                (ArmPoseTransformer) ((model, entity, arm) -> {
                    if (arm == HumanoidArm.RIGHT) {
                        model.rightArm.xRot = -2.094396F;
                        model.rightArm.yRot = -0.349066F;
                        model.rightArm.zRot = -0.2618F;
                        model.rightArm.z += 0.5F;
                        model.leftArm.xRot = -0.610866F;
                        model.leftArm.yRot = 0.218166F;
                        model.leftArm.z -= 1F;
                    } else {
                        model.rightArm.xRot = -0.610866F;
                        model.rightArm.yRot = -0.218166F;
                        model.rightArm.z -= 1F;
                        model.leftArm.xRot = -2.094396F;
                        model.leftArm.yRot = 0.349066F;
                        model.leftArm.zRot = 0.2618F;
                        model.leftArm.z += 0.5F;
                    }
                })
        });

        // PIPA_PLAYING
        armPoseBuilder.addEnum("MORECOLORFUL_PIPA_PLAYING", () -> new Object[]{
                true,
                (ArmPoseTransformer) ((model, entity, arm) -> {
                    if (arm == HumanoidArm.RIGHT) {
                        model.rightArm.xRot = -2.094396F;
                        model.rightArm.yRot = -0.349066F;
                        model.rightArm.zRot = -0.2618F;
                        model.rightArm.z += 0.5F;
                        model.leftArm.xRot = -0.610866F;
                        model.leftArm.yRot = 0.218166F;
                        model.leftArm.z -= 1F;
                        AnimationUtils.animatePipaPlaying(model.rightArm, model.leftArm, entity, true);
                    } else {
                        model.rightArm.xRot = -0.610866F;
                        model.rightArm.yRot = -0.218166F;
                        model.rightArm.z -= 1F;
                        model.leftArm.xRot = -2.094396F;
                        model.leftArm.yRot = 0.349066F;
                        model.leftArm.zRot = 0.2618F;
                        model.leftArm.z += 0.5F;
                        AnimationUtils.animatePipaPlaying(model.rightArm, model.leftArm, entity, false);
                    }
                })
        });

        // ERHU_HOLD
        armPoseBuilder.addEnum("MORECOLORFUL_ERHU_HOLD", () -> new Object[]{
                true,
                (ArmPoseTransformer) ((model, entity, arm) -> {
                    if (arm == HumanoidArm.RIGHT) {
                        model.rightArm.xRot = -1.047198F;
                        model.rightArm.yRot = -0.087267F;
                        model.leftArm.xRot = -0.523599F;
                    } else {
                        model.leftArm.xRot = -1.047198F;
                        model.leftArm.yRot = 0.087267F;
                        model.rightArm.xRot = -0.523599F;
                    }
                })
        });

        // ERHU_PLAYING
        armPoseBuilder.addEnum("MORECOLORFUL_ERHU_PLAYING", () -> new Object[]{
                true,
                (ArmPoseTransformer) ((model, entity, arm) -> {
                    if (arm == HumanoidArm.RIGHT) {
                        model.rightArm.xRot = -1.047198F;
                        model.rightArm.yRot = -0.087267F;
                        model.leftArm.xRot = -0.523599F;
                        AnimationUtils.animateErhuPlaying(model.rightArm, model.leftArm, entity, true);
                    } else {
                        model.leftArm.xRot = -1.047198F;
                        model.leftArm.yRot = 0.087267F;
                        model.rightArm.xRot = -0.523599F;
                        AnimationUtils.animateErhuPlaying(model.rightArm, model.leftArm, entity, false);
                    }
                })
        });

        armPoseBuilder.build();
    }

    private void registerBoatTypes() {
        // 使用String方式指定构造函数参数类型，避免过早加载Minecraft类
        var boatTypeBuilder = ClassTinkerers.enumBuilder("net.minecraft.world.entity.vehicle.Boat$Type",
                "java/util/function/Supplier", "java/lang/String",
                "java/util/function/Supplier", "java/util/function/Supplier",
                "java/util/function/Supplier", "Z");

        // CRABAPPLE
        boatTypeBuilder.addEnum("MORECOLORFUL_CRABAPPLE", () -> new Object[]{
                (Supplier<?>) () -> ModBlocks.CRABAPPLE_PLANKS,
                "morecolorful:crabapple",
                (Supplier<?>) () -> ModItems.CRABAPPLE_BOAT,
                (Supplier<?>) () -> ModItems.CRABAPPLE_CHEST_BOAT,
                (Supplier<?>) () -> Items.STICK,
                false
        });

        // EBONY
        boatTypeBuilder.addEnum("MORECOLORFUL_EBONY", () -> new Object[]{
                (Supplier<?>) () -> ModBlocks.EBONY_PLANKS,
                "morecolorful:ebony",
                (Supplier<?>) () -> ModItems.EBONY_BOAT,
                (Supplier<?>) () -> ModItems.EBONY_CHEST_BOAT,
                (Supplier<?>) () -> Items.STICK,
                false
        });

        // GINKGO
        boatTypeBuilder.addEnum("MORECOLORFUL_GINKGO", () -> new Object[]{
                (Supplier<?>) () -> ModBlocks.GINKGO_PLANKS,
                "morecolorful:ginkgo",
                (Supplier<?>) () -> ModItems.GINKGO_BOAT,
                (Supplier<?>) () -> ModItems.GINKGO_CHEST_BOAT,
                (Supplier<?>) () -> Items.STICK,
                false
        });

        // MAPLE
        boatTypeBuilder.addEnum("MORECOLORFUL_MAPLE", () -> new Object[]{
                (Supplier<?>) () -> ModBlocks.MAPLE_PLANKS,
                "morecolorful:maple",
                (Supplier<?>) () -> ModItems.MAPLE_BOAT,
                (Supplier<?>) () -> ModItems.MAPLE_CHEST_BOAT,
                (Supplier<?>) () -> Items.STICK,
                false
        });

        // FROST
        boatTypeBuilder.addEnum("MORECOLORFUL_FROST", () -> new Object[]{
                (Supplier<?>) () -> ModBlocks.FROST_PLANKS,
                "morecolorful:frost",
                (Supplier<?>) () -> ModItems.FROST_BOAT,
                (Supplier<?>) () -> ModItems.FROST_CHEST_BOAT,
                (Supplier<?>) () -> Items.STICK,
                false
        });

        // DAWN_REDWOOD
        boatTypeBuilder.addEnum("MORECOLORFUL_DAWN_REDWOOD", () -> new Object[]{
                (Supplier<?>) () -> ModBlocks.DAWN_REDWOOD_PLANKS,
                "morecolorful:dawn_redwood",
                (Supplier<?>) () -> ModItems.DAWN_REDWOOD_BOAT,
                (Supplier<?>) () -> ModItems.DAWN_REDWOOD_CHEST_BOAT,
                (Supplier<?>) () -> Items.STICK,
                false
        });

        // JACARANDA
        boatTypeBuilder.addEnum("MORECOLORFUL_JACARANDA", () -> new Object[]{
                (Supplier<?>) () -> ModBlocks.JACARANDA_PLANKS,
                "morecolorful:jacaranda",
                (Supplier<?>) () -> ModItems.JACARANDA_BOAT,
                (Supplier<?>) () -> ModItems.JACARANDA_CHEST_BOAT,
                (Supplier<?>) () -> Items.STICK,
                false
        });

        // WILLOW
        boatTypeBuilder.addEnum("MORECOLORFUL_WILLOW", () -> new Object[]{
                (Supplier<?>) () -> ModBlocks.WILLOW_PLANKS,
                "morecolorful:willow",
                (Supplier<?>) () -> ModItems.WILLOW_BOAT,
                (Supplier<?>) () -> ModItems.WILLOW_CHEST_BOAT,
                (Supplier<?>) () -> Items.STICK,
                false
        });

        boatTypeBuilder.build();
    }

    /*
     * Copyright (c) Forge Development LLC and contributors
     * SPDX-License-Identifier: LGPL-2.1-only
     */

    @FunctionalInterface
    public interface ArmPoseTransformer {
        /**
         * This method should be used to apply all wanted transformations to the player when the ArmPose is active.
         * You can use {@link LivingEntity#getTicksUsingItem()} and {@link LivingEntity#getUseItemRemainingTicks()} for moving animations.
         *
         * @param model  The humanoid model
         * @param entity The humanoid entity
         * @param arm    Arm to pose
         */
        void applyTransform(HumanoidModel<?> model, LivingEntity entity, HumanoidArm arm);
    }

}
