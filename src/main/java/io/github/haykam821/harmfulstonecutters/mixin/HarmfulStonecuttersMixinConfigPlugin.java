package io.github.haykam821.harmfulstonecutters.mixin;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import com.google.common.base.Predicates;

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.SemanticVersion;
import net.fabricmc.loader.api.Version;
import net.fabricmc.loader.api.VersionParsingException;
import net.fabricmc.loader.api.metadata.version.VersionPredicate;

public class HarmfulStonecuttersMixinConfigPlugin implements IMixinConfigPlugin {
	private static final String MIXIN_CLASS_PREFIX = "io.github.haykam821.harmfulstonecutters.mixin.";
	private static final String MIXIN_CLASS_1_16 = MIXIN_CLASS_PREFIX + "BlockMixin116";
	private static final String MIXIN_CLASS_1_17 = MIXIN_CLASS_PREFIX + "BlockMixin117";

	private static final Predicate<Version> IS_1_17 = createVersionCompatibility(">=1.17-alpha.21.17.a");

	@Override
	public void onLoad(String mixinPackage) {
		return;
	}

	@Override
	public String getRefMapperConfig() {
		return null;
	}

	@Override
	public boolean shouldApplyMixin(String targetClass, String mixinClass) {
		if (mixinClass.equals(MIXIN_CLASS_1_16)) {
			return !IS_1_17.test(getMinecraftVersion());
		} else if (mixinClass.equals(MIXIN_CLASS_1_17)) {
			return IS_1_17.test(getMinecraftVersion());
		}
		
		return true;
	}

	@Override
	public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
		return;
	}

	@Override
	public List<String> getMixins() {
		return null;
	}

	@Override
	public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
		return;
	}

	@Override
	public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
		return;
	}

	private static Version getMinecraftVersion() {
		Optional<ModContainer> container = FabricLoader.getInstance().getModContainer("minecraft");

		if (container.isPresent()) {
			Version version = container.get().getMetadata().getVersion();
			if (version instanceof SemanticVersion) {
				return version;
			}
		}

		return null;
	}

	private static Predicate<Version> createVersionCompatibility(String versionRange) {
		try {
			return VersionPredicate.parse(versionRange);
		} catch (VersionParsingException exception) {
			return Predicates.alwaysFalse();
		}
	}	
}
