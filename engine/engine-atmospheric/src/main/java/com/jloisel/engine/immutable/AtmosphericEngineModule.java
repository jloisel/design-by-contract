package com.jloisel.engine.immutable;

import com.google.inject.PrivateModule;
import com.jloisel.engine.api.Engine;
import com.jloisel.powerband.api.PowerBand;

/**
 * Provides an immutable {@link Engine}.
 * 
 * @author Jerome
 *
 */
public final class AtmosphericEngineModule extends PrivateModule {

	@Override
	protected void configure() {
		bind(Engine.class).to(AtmosphericEngine.class);
		requireBinding(PowerBand.class);
		expose(Engine.class);
	}

}
