package io.github.haykam821.harmfulstonecutters.damage;

import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class SliceDamageSource extends DamageSource {
	private final Block block;

	public SliceDamageSource(String name, Block block) {
		super(name);
		this.block = block;
	}

	public SliceDamageSource(Block block) {
		this("slice", block);
	}

	private String getTranslationKey() {
		return "death.attack.harmfulstonecutters." + this.getName();
	}

	public Text getDeathMessage(LivingEntity entity) {
		LivingEntity primeAdversary = entity.getPrimeAdversary();
		if (primeAdversary != null) {
			return new TranslatableText(this.getTranslationKey() + ".player", entity.getDisplayName(), this.getBlockName(), primeAdversary.getDisplayName());
		}

		return new TranslatableText(this.getTranslationKey(), entity.getDisplayName(), this.getBlockName());
	}

	public Block getBlock() {
		return this.block;
	}

	private Text getBlockName() {
  		return new TranslatableText(this.block.getTranslationKey());
	}

	public static DamageSource slice(Block source) {
		return new SliceDamageSource("slice", source);
	}
}