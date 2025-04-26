package com.ChalkerCharles.morecolorful.mixin.block;

import com.ChalkerCharles.morecolorful.util.melody.MelodyHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.NoteBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NoteBlock.class)
public class NoteBlockMixin {
    @Inject(method = "triggerEvent", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/world/level/Level;playSeededSound(Lnet/minecraft/world/entity/player/Player;DDDLnet/minecraft/core/Holder;Lnet/minecraft/sounds/SoundSource;FFJ)V",
            shift = At.Shift.AFTER))

    private void onNoteBlockPlay(BlockState blockState, Level level, BlockPos blockPos, int i, int j, CallbackInfoReturnable<Boolean> cir) {
        if (!level.isClientSide()) {
            NoteBlockInstrument instrument = blockState.getValue(NoteBlock.INSTRUMENT);
            int note = blockState.getValue(NoteBlock.NOTE);
            MelodyHandler.getInstance().onNoteBlockPlaying(level, blockPos, blockState, note, instrument);
        }
    }
}