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

@Mixin(value = Block.class, remap = false)
public class BlockMixin116 {
	@SuppressWarnings("target")
	@Inject(method = "method_9591(Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lnet/minecraft/class_1297;)V", at = @At("HEAD"))
	private void sliceEntities(World world, BlockPos pos, Entity entity, CallbackInfo ci) {
		BlockState state = world.getBlockState(pos);
		if (!HarmfulStonecutters.canSlice(state)) return;

		if (!(entity instanceof LivingEntity)) return;
		entity.damage(SliceDamageSource.slice(state.getBlock()), 2.0f);
	}
}