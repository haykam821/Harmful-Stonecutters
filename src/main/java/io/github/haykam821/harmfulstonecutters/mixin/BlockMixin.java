package io.github.haykam821.harmfulstonecutters.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.haykam821.harmfulstonecutters.damage.SliceDamageSource;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.StonecutterBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(Block.class)
public class BlockMixin {
	@Unique
	private static final String MOD_ID = "harmfulstonecutters";

	@Unique
	private static final Identifier SAFE_STONECUTTERS_ID = new Identifier(MOD_ID, "safe_stonecutters");

	@Unique
	private static final Tag<Block> SAFE_STONECUTTERS = TagRegistry.block(SAFE_STONECUTTERS_ID);

	@Unique
	private static final Identifier ALWAYS_SLICING_ID = new Identifier(MOD_ID, "always_slicing");

	@Unique
	private static final Tag<Block> ALWAYS_SLICING = TagRegistry.block(ALWAYS_SLICING_ID);

	@Unique
	private static boolean canSlice(Block block) {
		if (block.isIn(ALWAYS_SLICING)) return true;
		return block instanceof StonecutterBlock && !block.isIn(SAFE_STONECUTTERS);
	}

	@Inject(method = "onSteppedOn", at = @At("HEAD"))
	private void sliceEntities(World world, BlockPos pos, Entity entity, CallbackInfo ci) {
		Block block = (Block) (Object) this;
		if (!BlockMixin.canSlice(block)) return;

		if (!(entity instanceof LivingEntity)) return;
		entity.damage(SliceDamageSource.slice(block), 2.0f);
	}
}