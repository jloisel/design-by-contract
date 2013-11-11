package com.jloisel.material.alloy;

import com.google.inject.AbstractModule;
import com.jloisel.material.api.Material;

/**
 * <p>Provides Alloy Wheel {@link Material}.
 * <p>Requires {@link WheelSizeValue} binding.
 * 
 * @author Jerome
 *
 */
public final class AlloyMaterialModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(Material.class).to(Alloy.class);
	}
}
