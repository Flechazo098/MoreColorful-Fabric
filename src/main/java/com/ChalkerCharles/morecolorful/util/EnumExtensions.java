package com.ChalkerCharles.morecolorful.util;

import com.chocohead.mm.api.ClassTinkerers;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.vehicle.Boat;

/**
 * 枚举扩展工具类，用于获取通过Fabric ASM添加的枚举值
 */
public class EnumExtensions {
    public static class ArmPose {
        // Flute
        public static final String FLUTE = "MORECOLORFUL_FLUTE";

        // Guitar-Like
        public static final String GUITAR_HOLD = "MORECOLORFUL_GUITAR_HOLD";
        public static final String GUITAR_PLAYING = "MORECOLORFUL_GUITAR_PLAYING";

        // Cow Bell
        public static final String COW_BELL = "MORECOLORFUL_COW_BELL";

        // Didgeridoo
        public static final String DIDGERIDOO = "MORECOLORFUL_DIDGERIDOO";

        // Violin
        public static final String VIOLIN_HOLD = "MORECOLORFUL_VIOLIN_HOLD";
        public static final String VIOLIN_PLAYING = "MORECOLORFUL_VIOLIN_PLAYING";

        // Cello
        public static final String CELLO_HOLD = "MORECOLORFUL_CELLO_HOLD";
        public static final String CELLO_PLAYING = "MORECOLORFUL_CELLO_PLAYING";
        public static final String CELLO = "MORECOLORFUL_CELLO";

        // Trumpet
        // 使用原版 HumanoidModel.ArmPose.TOOT_HORN，无需自定义名称

        // Saxophone, Ocarina & Harmonica
        public static final String SAXOPHONE = "MORECOLORFUL_SAXOPHONE";

        // Pipa
        public static final String PIPA_HOLD = "MORECOLORFUL_PIPO_HOLD";
        public static final String PIPA_PLAYING = "MORECOLORFUL_PIPO_PLAYING";

        // Erhu
        public static final String ERHU_HOLD = "MORECOLORFUL_ERHU_HOLD";
        public static final String ERHU_PLAYING = "MORECOLORFUL_ERHU_PLAYING";

        // 辅助方法：通过字符串获取实际的 ArmPose 枚举值
        public static HumanoidModel.ArmPose getArmPose(String name) {
            try {
                return HumanoidModel.ArmPose.valueOf(name);
            } catch (IllegalArgumentException e) {
                // 如果找不到对应枚举值，则返回默认 ITEM 姿势
                return HumanoidModel.ArmPose.ITEM;
            }
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

            private static Boat.Type getBoatType (String name) {
                return ClassTinkerers.getEnum(Boat.Type.class, name);
            }
        }
    }