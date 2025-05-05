package com.ChalkerCharles.morecolorful.client;

import com.ChalkerCharles.morecolorful.MoreColorful;
import com.ChalkerCharles.morecolorful.client.gui.PlayingScreen;
import com.ChalkerCharles.morecolorful.common.attachment.ModDataAttachments;
import com.ChalkerCharles.morecolorful.common.item.ModItems;
import com.ChalkerCharles.morecolorful.util.EnumExtensions;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

@Environment(EnvType.CLIENT)
public class ModItemClientSetup {

    // 定义接口
    public interface ArmPoseProvider {
        HumanoidModel.ArmPose getArmPose(LivingEntity livingEntity, InteractionHand hand, ItemStack itemStack);
    }

    public interface HandTransformProvider {
        void transform(PoseStack poseStack, LocalPlayer player, HumanoidArm arm, ItemStack itemInHand, float partialTick, float equipProcess, float swingProcess);
    }

    private static boolean initialized = false;

    public static void init() {
        if (initialized) return;

        // 使用客户端生命周期事件延迟初始化，确保所有类都已加载
        ClientLifecycleEvents.CLIENT_STARTED.register(client -> {
            try {
                setupUseAnim();
                registerModelPredicate();
                initialized = true;
                MoreColorful.LOGGER.info("ModItemClientSetup initialized successfully");
            } catch (Exception e) {
                MoreColorful.LOGGER.error("Error initializing ModItemClientSetup", e);
            }
        });
    }

    private static void setupUseAnim() {
        try {
            // Flute
            registerArmPose(ModItems.FLUTE, (livingEntity, hand, itemStack) -> {
                if (livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack) {
                    return EnumExtensions.ArmPose.getArmPose(EnumExtensions.ArmPose.FLUTE);
                }
                return HumanoidModel.ArmPose.ITEM;
            });

            // Guitar-Like
            registerArmPose(new ItemStack[]{ModItems.GUITAR.getDefaultInstance(), ModItems.BASS.getDefaultInstance(), ModItems.BANJO.getDefaultInstance(), ModItems.ELECTRIC_GUITAR.getDefaultInstance()},
                    (livingEntity, hand, itemStack) -> {
                        if (livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack
                                && ModDataAttachments.isPlayingInstrument(livingEntity)) {
                            return EnumExtensions.ArmPose.getArmPose(EnumExtensions.ArmPose.GUITAR_PLAYING);
                        }
                        return EnumExtensions.ArmPose.getArmPose(EnumExtensions.ArmPose.GUITAR_HOLD);
                    });

            // Cow Bell
            registerArmPose(ModItems.COW_BELL, (livingEntity, hand, itemStack) -> {
                if (livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack) {
                    return EnumExtensions.ArmPose.getArmPose(EnumExtensions.ArmPose.COW_BELL);
                }
                return HumanoidModel.ArmPose.ITEM;
            });

            // Didgeridoo
            registerArmPose(ModItems.DIDGERIDOO, (livingEntity, hand, itemStack) -> {
                if (livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack) {
                    return EnumExtensions.ArmPose.getArmPose(EnumExtensions.ArmPose.DIDGERIDOO);
                }
                return HumanoidModel.ArmPose.ITEM;
            });

            // Violin
            registerArmPose(ModItems.VIOLIN, (livingEntity, hand, itemStack) -> {
                if (livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack
                        && ModDataAttachments.isPlayingInstrument(livingEntity)) {
                    return EnumExtensions.ArmPose.getArmPose(EnumExtensions.ArmPose.VIOLIN_PLAYING);
                } else if (livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack) {
                    return EnumExtensions.ArmPose.getArmPose(EnumExtensions.ArmPose.VIOLIN_HOLD);
                }
                return HumanoidModel.ArmPose.ITEM;
            });

            // Fiddle Bow
            registerHandTransform(ModItems.FIDDLE_BOW, (poseStack, player, arm, itemInHand, partialTick, equipProcess, swingProcess) -> {
                float f = player.getTicksUsingItem();
                float f1 = f % 20 >= 10 ? - (f % 20) + 10 : (f % 20) - 10;
                if (Minecraft.getInstance().screen instanceof PlayingScreen pScreen && pScreen.isPressing) {
                    if (player.getUseItem().getItem() == ModItems.VIOLIN) {
                        poseStack.mulPose(Axis.YP.rotationDegrees(f1 * 2));
                        if (arm == HumanoidArm.RIGHT) {
                            poseStack.mulPose(Axis.YP.rotationDegrees(15.0F));
                            poseStack.translate(- 0.4, 0.12, 0.02);
                        } else {
                            poseStack.translate(0.32, 0.12, 0.02);
                        }
                    } else if (player.getUseItem().getItem() == ModItems.CELLO) {
                        poseStack.mulPose(Axis.YP.rotationDegrees(f1 * 2));
                        poseStack.mulPose(Axis.XP.rotationDegrees(f1 / 2));
                        if (arm == HumanoidArm.RIGHT) {
                            poseStack.mulPose(Axis.YP.rotationDegrees(15.0F));
                            poseStack.translate(- 0.4, 0.0, - 0.1);
                        } else {
                            poseStack.translate(0.32, 0.0, - 0.1);
                        }
                    } else if (player.getUseItem().getItem() == ModItems.ERHU) {
                        poseStack.mulPose(Axis.YP.rotationDegrees(f1 * 2));
                        if (arm == HumanoidArm.RIGHT) {
                            poseStack.mulPose(Axis.YP.rotationDegrees(15.0F));
                            poseStack.translate(- 0.4, 0.0, - 0.07);
                        } else {
                            poseStack.translate(0.32, 0.0, - 0.07);
                        }
                    }
                }
            });

            // Cello
            registerArmPose(ModItems.CELLO, (livingEntity, hand, itemStack) -> {
                if (livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack
                        && ModDataAttachments.isPlayingInstrument(livingEntity)) {
                    return EnumExtensions.ArmPose.getArmPose(EnumExtensions.ArmPose.CELLO_PLAYING);
                } else if (livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack) {
                    return EnumExtensions.ArmPose.getArmPose(EnumExtensions.ArmPose.CELLO_HOLD);
                }
                return EnumExtensions.ArmPose.getArmPose(EnumExtensions.ArmPose.CELLO);
            });

            // Trumpet
            registerArmPose(ModItems.TRUMPET, (livingEntity, hand, itemStack) -> {
                if (livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack) {
                    return HumanoidModel.ArmPose.TOOT_HORN;
                }
                return HumanoidModel.ArmPose.ITEM;
            });

            // Saxophone, Ocarina & Harmonica
            registerArmPose(new ItemStack[]{ModItems.SAXOPHONE.getDefaultInstance(), ModItems.OCARINA.getDefaultInstance(), ModItems.HARMONICA.getDefaultInstance()},
                    (livingEntity, hand, itemStack) -> {
                        if (livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack) {
                            return EnumExtensions.ArmPose.getArmPose(EnumExtensions.ArmPose.SAXOPHONE);
                        }
                        return HumanoidModel.ArmPose.ITEM;
                    });

            // Pipa
            registerArmPose(ModItems.PIPA, (livingEntity, hand, itemStack) -> {
                if (livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack
                        && ModDataAttachments.isPlayingInstrument(livingEntity)) {
                    return EnumExtensions.ArmPose.getArmPose(EnumExtensions.ArmPose.PIPA_PLAYING);
                }
                return EnumExtensions.ArmPose.getArmPose(EnumExtensions.ArmPose.PIPA_HOLD);
            });

            // Erhu
            registerArmPose(ModItems.ERHU, (livingEntity, hand, itemStack) -> {
                if (livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack
                        && ModDataAttachments.isPlayingInstrument(livingEntity)) {
                    return EnumExtensions.ArmPose.getArmPose(EnumExtensions.ArmPose.ERHU_PLAYING);
                } else if (livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack) {
                    return EnumExtensions.ArmPose.getArmPose(EnumExtensions.ArmPose.ERHU_HOLD);
                }
                return HumanoidModel.ArmPose.ITEM;
            });
        } catch (Exception e) {
            MoreColorful.LOGGER.error("Error in setupUseAnim", e);
        }
    }

    private static void registerModelPredicate() {
        ItemProperties.register(ModItems.FLUTE, ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "playing"),
                (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.isUsingItem() && pEntity.getUseItem() == pStack ? 1.0F : 0.0F);
        ItemProperties.register(ModItems.COW_BELL, ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "playing"),
                (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.isUsingItem() && pEntity.getUseItem() == pStack ? 1.0F : 0.0F);
        ItemProperties.register(ModItems.DIDGERIDOO, ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "playing"),
                (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.isUsingItem() && pEntity.getUseItem() == pStack ? 1.0F : 0.0F);
        ItemProperties.register(ModItems.VIOLIN, ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "playing"),
                (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.isUsingItem() && pEntity.getUseItem() == pStack ? 1.0F : 0.0F);
        ItemProperties.register(ModItems.FIDDLE_BOW, ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "playing_violin"),
                (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.isUsingItem() && pEntity.getUseItem().getItem() == ModItems.VIOLIN ? 1.0F : 0.0F);
        ItemProperties.register(ModItems.FIDDLE_BOW, ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "playing_cello"),
                (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.isUsingItem() && pEntity.getUseItem().getItem() == ModItems.CELLO ? 1.0F : 0.0F);
        ItemProperties.register(ModItems.FIDDLE_BOW, ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "playing_erhu"),
                (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.isUsingItem() && pEntity.getUseItem().getItem() == ModItems.ERHU ? 1.0F : 0.0F);
        ItemProperties.register(ModItems.TRUMPET, ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "playing"),
                (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.isUsingItem() && pEntity.getUseItem() == pStack ? 1.0F : 0.0F);
        ItemProperties.register(ModItems.SAXOPHONE, ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "playing"),
                (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.isUsingItem() && pEntity.getUseItem() == pStack ? 1.0F : 0.0F);
        ItemProperties.register(ModItems.OCARINA, ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "playing"),
                (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.isUsingItem() && pEntity.getUseItem() == pStack ? 1.0F : 0.0F);
        ItemProperties.register(ModItems.HARMONICA, ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "playing"),
                (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.isUsingItem() && pEntity.getUseItem() == pStack ? 1.0F : 0.0F);
        ItemProperties.register(ModItems.ERHU, ResourceLocation.fromNamespaceAndPath(MoreColorful.MODID, "playing"),
                (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.isUsingItem() && pEntity.getUseItem() == pStack ? 1.0F : 0.0F);
    }

    // 注册手臂姿势
    public static void registerArmPose(Item item, ArmPoseProvider provider) {
        EnumExtensions.ArmPose.registerArmPoseForItem(item.getDefaultInstance(), provider);
    }

    public static void registerArmPose(ItemStack[] stacks, ArmPoseProvider provider) {
        for (ItemStack stack : stacks) {
            EnumExtensions.ArmPose.registerArmPoseForItem(stack, provider);
        }
    }

    // 辅助方法，用于注册手部变换
    private static void registerHandTransform(Object item, HandTransformProvider provider) {
        // 在Fabric中实现手部变换注册的逻辑
        // 这需要通过Mixin或其他方式实现
    }

}