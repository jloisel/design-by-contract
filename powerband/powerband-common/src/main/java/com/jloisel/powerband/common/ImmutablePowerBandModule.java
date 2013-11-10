package com.jloisel.powerband.common;

import com.google.inject.PrivateModule;
import com.jloisel.powerband.api.PowerBand;
import com.jloisel.powerband.api.curve.HorsePower;
import com.jloisel.powerband.api.curve.Torque;

/**
 * Provides an immutable {@link PowerBand}.
 * 
 * @author Jerome
 *
 */
public final class ImmutablePowerBandModule extends PrivateModule {

	@Override
	protected void configure() {
		bind(PowerBand.class).to(ImmutablePowerBand.class);
		
		requireBinding(HorsePower.class);
		requireBinding(Torque.class);
		
		expose(PowerBand.class);
	}

}
