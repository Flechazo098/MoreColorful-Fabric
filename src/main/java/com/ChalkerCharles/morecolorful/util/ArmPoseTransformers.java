package com.ChalkerCharles.morecolorful.util;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;

/**
 * 存放所有手臂姿势转换逻辑的工具类
 */
public class ArmPoseTransformers {

    // ================== 通用转换方法 ==================
    private static void applyArmTransformation(HumanoidModel<?> model, HumanoidArm arm, Runnable rightArmAction, Runnable leftArmAction) {
        if (arm == HumanoidArm.RIGHT) {
            rightArmAction.run();
        } else {
            leftArmAction.run();
        }
    }

    // ================== 具体乐器转换方法 ==================

    // FLUTE 长笛姿势
    public static void transformFlute(Object modelObj, Object entityObj, Object armObj) {
        HumanoidModel<?> model = (HumanoidModel<?>) modelObj;
        HumanoidArm arm = (HumanoidArm) armObj;

        applyArmTransformation(model, arm,
                () -> { // Right Arm
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
                },
                () -> { // Left Arm
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
        );
    }

    // GUITAR_HOLD 吉他持握姿势
    public static void transformGuitarHold(Object modelObj, Object entityObj, Object armObj) {
        HumanoidModel<?> model = (HumanoidModel<?>) modelObj;
        HumanoidArm arm = (HumanoidArm) armObj;

        applyArmTransformation(model, arm,
                () -> {
                    model.rightArm.xRot = -0.26179938F;
                    model.leftArm.xRot = -0.62831852F;
                },
                () -> {
                    model.rightArm.xRot = -0.62831852F;
                    model.leftArm.xRot = -0.26179938F;
                }
        );
    }

    // GUITAR_PLAYING 吉他演奏姿势
    public static void transformGuitarPlaying(Object modelObj, Object entityObj, Object armObj) {
        HumanoidModel<?> model = (HumanoidModel<?>) modelObj;
        LivingEntity entity = (LivingEntity) entityObj;
        HumanoidArm arm = (HumanoidArm) armObj;

        applyArmTransformation(model, arm,
                () -> {
                    model.rightArm.xRot = -0.26179938F;
                    model.leftArm.xRot = -0.62831852F;
                    AnimationUtils.animateGuitarPlaying(model.rightArm, model.leftArm, entity, true);
                },
                () -> {
                    model.rightArm.xRot = -0.62831852F;
                    model.leftArm.xRot = -0.26179938F;
                    AnimationUtils.animateGuitarPlaying(model.rightArm, model.leftArm, entity, false);
                }
        );
    }

    // COW_BELL 牛铃姿势
    public static void transformCowBell(Object modelObj, Object entityObj, Object armObj) {
        HumanoidModel<?> model = (HumanoidModel<?>) modelObj;
        HumanoidArm arm = (HumanoidArm) armObj;

        applyArmTransformation(model, arm,
                () -> {
                    model.rightArm.xRot = -1.308998F;
                    model.rightArm.yRot = -0.174533F;
                    model.leftArm.xRot = model.leftArm.xRot * 0.5F - (float) (Math.PI / 10);
                },
                () -> {
                    model.leftArm.xRot = -1.308998F;
                    model.leftArm.yRot = 0.174533F;
                    model.rightArm.xRot = model.rightArm.xRot * 0.5F - (float) (Math.PI / 10);
                }
        );
    }

    // DIDGERIDOO 迪吉里杜管姿势
    public static void transformDidgeridoo(Object modelObj, Object entityObj, Object armObj) {
        HumanoidModel<?> model = (HumanoidModel<?>) modelObj;
        HumanoidArm arm = (HumanoidArm) armObj;

        model.rightArm.xRot = -1.221731F;
        model.leftArm.xRot = -1.221731F;
        model.rightArm.yRot = -0.218166F;
        model.leftArm.yRot = 0.218166F;
        model.rightArm.zRot = -0.174533F;
        model.leftArm.zRot = 0.174533F;
        model.rightArm.x += 0.5F;
        model.leftArm.x -= 0.5F;
    }

    // VIOLIN_HOLD 小提琴持握姿势
    public static void transformViolinHold(Object modelObj, Object entityObj, Object armObj) {
        HumanoidModel<?> model = (HumanoidModel<?>) modelObj;
        HumanoidArm arm = (HumanoidArm) armObj;

        applyArmTransformation(model, arm,
                () -> {
                    model.rightArm.xRot = -1.178098F;
                    model.rightArm.yRot = 0.087267F;
                    model.rightArm.zRot = 0.392699F;
                    model.leftArm.xRot = -1.570797F;
                },
                () -> {
                    model.leftArm.xRot = -1.178098F;
                    model.leftArm.yRot = -0.087267F;
                    model.leftArm.zRot = -0.392699F;
                    model.rightArm.xRot = -1.570797F;
                }
        );
    }

    // VIOLIN_PLAYING 小提琴演奏姿势
    public static void transformViolinPlaying(Object modelObj, Object entityObj, Object armObj) {
        HumanoidModel<?> model = (HumanoidModel<?>) modelObj;
        LivingEntity entity = (LivingEntity) entityObj;
        HumanoidArm arm = (HumanoidArm) armObj;

        applyArmTransformation(model, arm,
                () -> {
                    model.rightArm.xRot = -1.178098F;
                    model.rightArm.yRot = 0.087267F;
                    model.rightArm.zRot = 0.392699F;
                    model.leftArm.xRot = -1.570797F;
                    AnimationUtils.animateViolinPlaying(model.rightArm, model.leftArm, entity, true);
                },
                () -> {
                    model.leftArm.xRot = -1.178098F;
                    model.leftArm.yRot = -0.087267F;
                    model.leftArm.zRot = -0.392699F;
                    model.rightArm.xRot = -1.570797F;
                    AnimationUtils.animateViolinPlaying(model.rightArm, model.leftArm, entity, false);
                }
        );
    }

    // CELLO 大提琴基础姿势
    public static void transformCello(Object modelObj, Object entityObj, Object armObj) {
        HumanoidModel<?> model = (HumanoidModel<?>) modelObj;
        HumanoidArm arm = (HumanoidArm) armObj;

        applyArmTransformation(model, arm,
                () -> {
                    model.rightArm.xRot = -1.483531F;
                    model.rightArm.yRot = -0.043633F;
                    model.rightArm.zRot = -0.087267F;
                    model.rightArm.y += 1;
                },
                () -> {
                    model.leftArm.xRot = -1.483531F;
                    model.leftArm.yRot = 0.043633F;
                    model.leftArm.zRot = 0.087267F;
                    model.leftArm.y += 1;
                }
        );
    }

    // CELLO_HOLD 大提琴持握姿势
    public static void transformCelloHold(Object modelObj, Object entityObj, Object armObj) {
        HumanoidModel<?> model = (HumanoidModel<?>) modelObj;
        HumanoidArm arm = (HumanoidArm) armObj;

        applyArmTransformation(model, arm,
                () -> {
                    model.rightArm.xRot = -1.483531F;
                    model.rightArm.yRot = -0.043633F;
                    model.rightArm.zRot = -0.087267F;
                    model.rightArm.y += 1;
                    model.leftArm.xRot = -0.872665F;
                    model.leftArm.y -= 1;
                },
                () -> {
                    model.leftArm.xRot = -1.483531F;
                    model.leftArm.yRot = 0.043633F;
                    model.leftArm.zRot = 0.087267F;
                    model.leftArm.y += 1;
                    model.rightArm.xRot = -0.872665F;
                    model.rightArm.y -= 1;
                }
        );
    }

    // CELLO_PLAYING 大提琴演奏姿势
    public static void transformCelloPlaying(Object modelObj, Object entityObj, Object armObj) {
        HumanoidModel<?> model = (HumanoidModel<?>) modelObj;
        LivingEntity entity = (LivingEntity) entityObj;
        HumanoidArm arm = (HumanoidArm) armObj;

        applyArmTransformation(model, arm,
                () -> {
                    model.rightArm.xRot = -1.483531F;
                    model.rightArm.yRot = -0.043633F;
                    model.rightArm.zRot = -0.087267F;
                    model.rightArm.y += 1;
                    model.leftArm.xRot = -0.872665F;
                    model.leftArm.y -= 1;
                    AnimationUtils.animateCelloPlaying(model.rightArm, model.leftArm, entity, true);
                },
                () -> {
                    model.leftArm.xRot = -1.483531F;
                    model.leftArm.yRot = 0.043633F;
                    model.leftArm.zRot = 0.087267F;
                    model.leftArm.y += 1;
                    model.rightArm.xRot = -0.872665F;
                    model.rightArm.y -= 1;
                    AnimationUtils.animateCelloPlaying(model.rightArm, model.leftArm, entity, false);
                }
        );
    }

    public static void transformSaxophone(Object modelObj, Object entityObj, Object armObj) {
        HumanoidModel<?> model = (HumanoidModel<?>) modelObj;
        HumanoidArm arm = (HumanoidArm) armObj;

        model.rightArm.xRot = -1.047198F;
        model.leftArm.xRot = -1.047198F;
        model.rightArm.yRot = -0.218166F;
        model.leftArm.yRot = 0.218166F;
        model.rightArm.zRot = -0.174533F;
        model.leftArm.zRot = 0.174533F;
        model.rightArm.x += 0.5F;
        model.leftArm.x -= 0.5F;
    }

    public static void transformPipaHold(Object modelObj, Object entityObj, Object armObj) {
        HumanoidModel<?> model = (HumanoidModel<?>) modelObj;
        HumanoidArm arm = (HumanoidArm) armObj;

        applyArmTransformation(model, arm,
                () -> {
                    model.rightArm.xRot = -2.094396F;
                    model.rightArm.yRot = -0.349066F;
                    model.rightArm.zRot = -0.2618F;
                    model.rightArm.z += 0.5F;
                    model.leftArm.xRot = -0.610866F;
                    model.leftArm.yRot = 0.218166F;
                    model.leftArm.z -= 1F;
                },
                () -> {
                    model.rightArm.xRot = -0.610866F;
                    model.rightArm.yRot = -0.218166F;
                    model.rightArm.z -= 1F;
                    model.leftArm.xRot = -2.094396F;
                    model.leftArm.yRot = 0.349066F;
                    model.leftArm.zRot = 0.2618F;
                    model.leftArm.z += 0.5F;
                }
        );
    }

    public static void transformPipaPlaying(Object modelObj, Object entityObj, Object armObj) {
        HumanoidModel<?> model = (HumanoidModel<?>) modelObj;
        LivingEntity entity = (LivingEntity) entityObj;
        HumanoidArm arm = (HumanoidArm) armObj;

        applyArmTransformation(model, arm,
                () -> {
                    model.rightArm.xRot = -2.094396F;
                    model.rightArm.yRot = -0.349066F;
                    model.rightArm.zRot = -0.2618F;
                    model.rightArm.z += 0.5F;
                    model.leftArm.xRot = -0.610866F;
                    model.leftArm.yRot = 0.218166F;
                    model.leftArm.z -= 1F;
                    AnimationUtils.animatePipaPlaying(model.rightArm, model.leftArm, entity, true);
                },
                () -> {
                    model.rightArm.xRot = -0.610866F;
                    model.rightArm.yRot = -0.218166F;
                    model.rightArm.z -= 1F;
                    model.leftArm.xRot = -2.094396F;
                    model.leftArm.yRot = 0.349066F;
                    model.leftArm.zRot = 0.2618F;
                    model.leftArm.z += 0.5F;
                    AnimationUtils.animatePipaPlaying(model.rightArm, model.leftArm, entity, false);
                }
        );
    }
    public static void transformErhuHold(Object modelObj, Object entityObj, Object armObj) {
        HumanoidModel<?> model = (HumanoidModel<?>) modelObj;
        HumanoidArm arm = (HumanoidArm) armObj;

        applyArmTransformation(model, arm,
                () -> {
                    model.rightArm.xRot = -1.047198F;
                    model.rightArm.yRot = -0.087267F;
                    model.leftArm.xRot = -0.523599F;
                },
                () -> {
                    model.leftArm.xRot = -1.047198F;
                    model.leftArm.yRot = 0.087267F;
                    model.rightArm.xRot = -0.523599F;
                }
        );
    }
    public static void transformErhuPlaying(Object modelObj, Object entityObj, Object armObj) {
        HumanoidModel<?> model = (HumanoidModel<?>) modelObj;
        LivingEntity entity = (LivingEntity) entityObj;
        HumanoidArm arm = (HumanoidArm) armObj;

        applyArmTransformation(model, arm,
                () -> {
                    model.rightArm.xRot = -1.047198F;
                    model.rightArm.yRot = -0.087267F;
                    model.leftArm.xRot = -0.523599F;
                    AnimationUtils.animateErhuPlaying(model.rightArm, model.leftArm, entity, true);
                },
                () -> {
                    model.leftArm.xRot = -1.047198F;
                    model.leftArm.yRot = 0.087267F;
                    model.rightArm.xRot = -0.523599F;
                    AnimationUtils.animateErhuPlaying(model.rightArm, model.leftArm, entity, false);
                }
        );
    }
}