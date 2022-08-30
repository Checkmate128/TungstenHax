package com.Checkmate128.tungstenhax.mixin;

import com.Checkmate128.tungstenhax.TungstenHaxMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.block.BlockModelRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemConvertible;
import net.minecraft.network.packet.s2c.play.MapUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@Mixin(Block.class)
public abstract class XRAYMixin implements ItemConvertible {

    //private static ArrayList visibleList = new ArrayList(Arrays.asList(visible));

    @Inject(at = @At("HEAD"), method = "shouldDrawSide", cancellable = true)
    private static void onShouldDrawSide(BlockState state, BlockView world, BlockPos pos, Direction side, BlockPos blockPos, CallbackInfoReturnable<Boolean> cir) {
        Block[] visible = {
                Blocks.CHEST, Blocks.TRAPPED_CHEST, Blocks.ENDER_CHEST, Blocks.NETHER_PORTAL, Blocks.END_PORTAL,
                Blocks.DIAMOND_ORE, Blocks.GOLD_ORE, Blocks.IRON_ORE, Blocks.COPPER_ORE, Blocks.LAPIS_ORE,
                Blocks.COAL_ORE, Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.DEEPSLATE_GOLD_ORE,
                Blocks.DEEPSLATE_IRON_ORE, Blocks.DEEPSLATE_COPPER_ORE, Blocks.DEEPSLATE_LAPIS_ORE,
                Blocks.DEEPSLATE_COAL_ORE, Blocks.NETHER_GOLD_ORE, Blocks.ANCIENT_DEBRIS, Blocks.LAVA,
                Blocks.WATER
        };

        ArrayList visibleList = new ArrayList(Arrays.asList(visible));

        boolean shouldDraw = false;

        if (TungstenHaxMod.xrayEnabled) {
//            for(int i = 0; i < visible.length; i++) {
//                if(state.getBlock().equals(visible[i])) {
//                    cir.setReturnValue(true);
//                    shouldDraw = true;
//                }
//            }
            shouldDraw = visibleList.contains(state.getBlock());
            cir.setReturnValue(shouldDraw);

//            if(!shouldDraw) {
//                cir.setReturnValue(false);
//            }
        }
    }

}
