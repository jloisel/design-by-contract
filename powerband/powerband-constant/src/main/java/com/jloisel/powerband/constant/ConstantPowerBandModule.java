package com.jloisel.powerband.constant;

import com.google.common.collect.Range;
import com.google.inject.Key;
import com.google.inject.PrivateModule;
import com.google.inject.TypeLiteral;
import com.jloisel.powerband.api.PowerBand;
import com.jloisel.powerband.api.curve.HorsePower;
import com.jloisel.powerband.api.curve.Torque;
import com.jloisel.powerband.common.ImmutablePowerBandModule;

/**
 * Provides a constant {@link PowerBand}.
 * 
 * @author Jerome
 *
 */
public final class ConstantPowerBandModule extends PrivateModule {

	@Override
	protected void configure() {
		install(new ImmutablePowerBandModule());
		bind(HorsePower.class).to(ConstantHorsePower.class);
		bind(Torque.class).to(ConstantTorque.class);
		
		requireBinding(Key.get(Integer.class, HorsePowerValue.class));
		requireBinding(Key.get(Integer.class, TorqueValue.class));
		requireBinding(Key.get(new TypeLiteral<Range<Integer>>() {}));
		
		expose(HorsePower.class);
		expose(Torque.class);
		expose(PowerBand.class);
	}

}
