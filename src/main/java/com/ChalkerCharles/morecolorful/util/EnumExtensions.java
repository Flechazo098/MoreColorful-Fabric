package com.ChalkerCharles.morecolorful.util;

import com.chocohead.mm.api.ClassTinkerers;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.vehicle.Boat;

/**
 * 枚举扩展工具类，用于获取通过Fabric ASM添加的枚举值
 */
public final class EnumExtensions {
    public static class ArmPose {
        public static final HumanoidModel.ArmPose FLUTE = getArmPose("MORECOLORFUL_FLUTE");
        public static final HumanoidModel.ArmPose GUITAR_HOLD = getArmPose("MORECOLORFUL_GUITAR_HOLD");
        public static final HumanoidModel.ArmPose GUITAR_PLAYING = getArmPose("MORECOLORFUL_GUITAR_PLAYING");
        public static final HumanoidModel.ArmPose COW_BELL = getArmPose("MORECOLORFUL_COW_BELL");
        public static final HumanoidModel.ArmPose DIDGERIDOO = getArmPose("MORECOLORFUL_DIDGERIDOO");
        public static final HumanoidModel.ArmPose VIOLIN_HOLD = getArmPose("MORECOLORFUL_VIOLIN_HOLD");
        public static final HumanoidModel.ArmPose VIOLIN_PLAYING = getArmPose("MORECOLORFUL_VIOLIN_PLAYING");
        public static final HumanoidModel.ArmPose CELLO = getArmPose("MORECOLORFUL_CELLO");
        public static final HumanoidModel.ArmPose CELLO_HOLD = getArmPose("MORECOLORFUL_CELLO_HOLD");
        public static final HumanoidModel.ArmPose CELLO_PLAYING = getArmPose("MORECOLORFUL_CELLO_PLAYING");
        public static final HumanoidModel.ArmPose SAXOPHONE = getArmPose("MORECOLORFUL_SAXOPHONE");
        public static final HumanoidModel.ArmPose PIPA_HOLD = getArmPose("MORECOLORFUL_PIPA_HOLD");
        public static final HumanoidModel.ArmPose PIPA_PLAYING = getArmPose("MORECOLORFUL_PIPA_PLAYING");
        public static final HumanoidModel.ArmPose ERHU_HOLD = getArmPose("MORECOLORFUL_ERHU_HOLD");
        public static final HumanoidModel.ArmPose ERHU_PLAYING = getArmPose("MORECOLORFUL_ERHU_PLAYING");

        private static HumanoidModel.ArmPose getArmPose(String name) {
            return ClassTinkerers.getEnum(HumanoidModel.ArmPose.class, name);
        }
    }

    public static class BoatType {
        public static final Boat.Type CRABAPPLE = getBoatType("MORECOLORFUL_CRABAPPLE");
        public static final Boat.Type EBONY = getBoatType("MORECOLORFUL_EBONY");
        public static final Boat.Type GINKGO = getBoatType("MORECOLORFUL_GINKGO");
        public static final Boat.Type MAPLE = getBoatType("MORECOLORFUL_MAPLE");
        public static final Boat.Type FROST = getBoatType("MORECOLORFUL_FROST");
        public static final Boat.Type DAWN_REDWOOD = getBoatType("MORECOLORFUL_DAWN_REDWOOD");
        public static final Boat.Type JACARANDA = getBoatType("MORECOLORFUL_JACARANDA");
        public static final Boat.Type WILLOW = getBoatType("MORECOLORFUL_WILLOW");

        private static Boat.Type getBoatType(String name) {
            return ClassTinkerers.getEnum(Boat.Type.class, name);
        }
    }
}