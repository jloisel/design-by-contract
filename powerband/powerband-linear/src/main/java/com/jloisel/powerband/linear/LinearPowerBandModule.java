package com.jloisel.powerband.linear;

import com.google.common.collect.Range;
import com.google.inject.Key;
import com.google.inject.PrivateModule;
import com.google.inject.TypeLiteral;
import com.jloisel.powerband.api.PowerBand;
import com.jloisel.powerband.api.curve.HorsePower;
import com.jloisel.powerband.api.curve.Torque;
import com.jloisel.powerband.common.ImmutablePowerBandModule;

/**
 * Provides a linear increasing {@link PowerBand}.
 * Requires {@link LinearCoefficientValue} bound to an {@link Integer}, and 
 * RPM range.
 * 
 * @author Jerome
 *
 */
public final class LinearPowerBandModule extends PrivateModule {

	@Override
	protected void configure() {
		install(new ImmutablePowerBandModule());
		bind(HorsePower.class).to(LinearHorsePower.class);
		bind(Torque.class).to(LinearTorque.class);
		
		requireBinding(Key.get(Integer.class, LinearCoefficientValue.class));
		requireBinding(Key.get(new TypeLiteral<Range<Integer>>() {
		}));
		
		expose(HorsePower.class);
		expose(Torque.class);
		expose(PowerBand.class);
	}

}
