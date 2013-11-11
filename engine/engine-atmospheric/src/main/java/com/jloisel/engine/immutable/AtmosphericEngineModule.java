package com.jloisel.engine.immutable;

import com.google.inject.AbstractModule;
import com.jloisel.engine.api.Engine;
import com.jloisel.engine.common.ImmutableEngineModule;
import com.jloisel.powerband.api.PowerBand;
import com.jloisel.powerband.linear.LinearPowerBandModule;

/**
 * Provides an atmospheric {@link Engine}: {@link PowerBand} is linear 
 * to RPM.
 * 
 * See {@link LinearPowerBandModule} for required bindings.
 * 
 * @author Jerome
 *
 */
public final class AtmosphericEngineModule extends AbstractModule {
	@Override
	protected void configure() {
		install(new ImmutableEngineModule());
		install(new LinearPowerBandModule());
	}

}
