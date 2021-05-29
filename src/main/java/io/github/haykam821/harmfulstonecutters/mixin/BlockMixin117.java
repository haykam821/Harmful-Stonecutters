package io.github.haykam821.harmfulstonecutters.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.haykam821.harmfulstonecutters.HarmfulStonecutters;
import io.github.haykam821.harmfulstonecutters.damage.SliceDamageSource;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(Block.class)
public class BlockMixin117 {
	@Inject(method = "onSteppedOn", at = @At("HEAD"))
	private void sliceEntities(World world, BlockPos pos, BlockState state, Entity entity, CallbackInfo ci) {
		if (!HarmfulStonecutters.canSlice(state)) return;

		if (!(entity instanceof LivingEntity)) return;
		entity.damage(SliceDamageSource.slice(state.getBlock()), 2.0f);
	}
}