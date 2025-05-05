package com.ChalkerCharles.morecolorful.util;

import com.ChalkerCharles.morecolorful.common.block.ModBlocks;
import com.chocohead.mm.api.ClassTinkerers;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;


public class EarlyRiser implements Runnable{
    @Override
    public void run () {
        registerArmPoses();
        registerBoatTypes();

    }

    private void registerArmPoses () {
        // 使用String方式指定构造函数参数类型，避免过早加载Minecraft类
        // 修改构造函数参数，移除 ArmPoseTransformer 参数，只保留 boolean 参数
        var armPoseBuilder = ClassTinkerers.enumBuilder("net.minecraft.client.model.HumanoidModel$ArmPose", "Z");

        // 使用静态方法引用而不是lambda表达式，避免过早捕获外部类引用
        // FLUTE
        armPoseBuilder.addEnum("MORECOLORFUL_FLUTE", () -> new Object[]{
                true
        });

        // GUITAR_HOLD
        armPoseBuilder.addEnum("MORECOLORFUL_GUITAR_HOLD", () -> new Object[]{
                true
        });

        // GUITAR_PLAYING
        armPoseBuilder.addEnum("MORECOLORFUL_GUITAR_PLAYING", () -> new Object[]{
                true
        });

        // COW_BELL
        armPoseBuilder.addEnum("MORECOLORFUL_COW_BELL", () -> new Object[]{
                false
        });

        // DIDGERIDOO
        armPoseBuilder.addEnum("MORECOLORFUL_DIDGERIDOO", () -> new Object[]{
                true
        });

        // VIOLIN_HOLD
        armPoseBuilder.addEnum("MORECOLORFUL_VIOLIN_HOLD", () -> new Object[]{
                true
        });

        // VIOLIN_PLAYING
        armPoseBuilder.addEnum("MORECOLORFUL_VIOLIN_PLAYING", () -> new Object[]{
            true
        });
         
        // CELLO
        armPoseBuilder.addEnum("MORECOLORFUL_CELLO", () -> new Object[]{
            false
        });

        // CELLO_HOLD
        armPoseBuilder.addEnum("MORECOLORFUL_CELLO_HOLD", () -> new Object[]{
            true
        });

        // CELLO_PLAYING
        armPoseBuilder.addEnum("MORECOLORFUL_CELLO_PLAYING", () -> new Object[]{
            true
        });

        // SAXOPHONE
        armPoseBuilder.addEnum("MORECOLORFUL_SAXOPHONE", () -> new Object[]{
            true
        });

        // PIPA_HOLD
        armPoseBuilder.addEnum("MORECOLORFUL_PIPA_HOLD", () -> new Object[]{
            true
        });

        // PIPA_PLAYING
        armPoseBuilder.addEnum("MORECOLORFUL_PIPA_PLAYING", () -> new Object[]{
            true
        });

        // ERHU_HOLD
        armPoseBuilder.addEnum("MORECOLORFUL_ERHU_HOLD", () -> new Object[]{
            true
        });

        // ERHU_PLAYING
        armPoseBuilder.addEnum("MORECOLORFUL_ERHU_PLAYING", () -> new Object[]{
            true
        });
        
        armPoseBuilder.build();
    }

    // 静态转换器接口，避免直接引用Minecraft类
    public interface ArmPoseTransformer {
        void transform(Object model, Object entity, Object arm);
    }

    // 静态转换器实现，用于包装实际的转换逻辑
    public static class StaticArmPoseTransformer {
        private final ArmPoseTransformer transformer;

        public StaticArmPoseTransformer(ArmPoseTransformer transformer) {
            this.transformer = transformer;
        }

        // 这个方法会在游戏运行时被调用，此时所有类都已加载完成
        public void transform(HumanoidModel<?> model, LivingEntity entity, HumanoidArm arm) {
            transformer.transform(model, entity, arm);
        }
    }

    private void registerBoatTypes() {
        var boatTypeBuilder = ClassTinkerers.enumBuilder(
                "net.minecraft.world.entity.vehicle.Boat$Type",
                "Lnet/minecraft/world/level/block/Block;",
                "Ljava/lang/String;"
        );

        // CRABAPPLE
        boatTypeBuilder.addEnum("MORECOLORFUL_CRABAPPLE", () -> new Object[]{
                ModBlocks.CRABAPPLE_PLANKS,
                "crabapple"
        });

        // EBONY
        boatTypeBuilder.addEnum("MORECOLORFUL_EBONY", () -> new Object[]{
                ModBlocks.EBONY_PLANKS,
                "ebony"
        });

        // GINKGO
        boatTypeBuilder.addEnum("MORECOLORFUL_GINKGO", () -> new Object[]{
                ModBlocks.GINKGO_PLANKS,
                "ginkgo"
        });

        // MAPLE
        boatTypeBuilder.addEnum("MORECOLORFUL_MAPLE", () -> new Object[]{
                ModBlocks.MAPLE_PLANKS,
                "maple"
        });

        // FROST
        boatTypeBuilder.addEnum("MORECOLORFUL_FROST", () -> new Object[]{
                ModBlocks.FROST_PLANKS,
                "frost"
        });

        // DAWN_REDWOOD
        boatTypeBuilder.addEnum("MORECOLORFUL_DAWN_REDWOOD", () -> new Object[]{
                ModBlocks.DAWN_REDWOOD_PLANKS,
                "dawn_redwood"
        });

        // JACARANDA
        boatTypeBuilder.addEnum("MORECOLORFUL_JACARANDA", () -> new Object[]{
                ModBlocks.JACARANDA_PLANKS,
                "jacaranda"
        });

        // WILLOW
        boatTypeBuilder.addEnum("MORECOLORFUL_WILLOW", () -> new Object[]{
                ModBlocks.WILLOW_PLANKS,
                "willow"
        });

        boatTypeBuilder.build();
    }


}
