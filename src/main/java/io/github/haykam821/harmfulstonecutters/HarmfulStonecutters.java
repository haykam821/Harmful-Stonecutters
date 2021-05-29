package io.github.haykam821.harmfulstonecutters;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StonecutterBlock;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class HarmfulStonecutters {
	private static final String MOD_ID = "harmfulstonecutters";

	private static final Identifier SAFE_STONECUTTERS_ID = new Identifier(MOD_ID, "safe_stonecutters");
	private static final Tag<Block> SAFE_STONECUTTERS = TagRegistry.block(SAFE_STONECUTTERS_ID);

	private static final Identifier ALWAYS_SLICING_ID = new Identifier(MOD_ID, "always_slicing");
	private static final Tag<Block> ALWAYS_SLICING = TagRegistry.block(ALWAYS_SLICING_ID);

	public static boolean canSlice(BlockState state) {
		if (state.isIn(ALWAYS_SLICING)) return true;
		return state.getBlock() instanceof StonecutterBlock && !state.isIn(SAFE_STONECUTTERS);
	}
}
