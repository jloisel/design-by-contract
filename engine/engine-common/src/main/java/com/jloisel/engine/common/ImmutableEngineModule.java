package com.jloisel.engine.common;

import com.google.inject.PrivateModule;
import com.jloisel.engine.api.Engine;
import com.jloisel.powerband.api.PowerBand;

/**
 * Provides an immutable {@link Engine}, with non-replaceable  
 * {@link PowerBand} instance.
 * 
 * Requires {@link PowerBand}.
 * 
 * @author Jerome
 *
 */
public final class ImmutableEngineModule extends PrivateModule {
	@Override
	protected void configure() {
		bind(Engine.class).to(ImmutableEngine.class);
		requireBinding(PowerBand.class);
		expose(Engine.class);
	}

}
