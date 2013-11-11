package com.jloisel.material.carbon;

import com.google.inject.AbstractModule;
import com.jloisel.material.api.Material;

/**
 * Provides Carbon {@link Material}.
 * 
 * @author Jerome
 *
 */
public final class CarbonMaterialModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(Material.class).to(Carbon.class);
	}
}
