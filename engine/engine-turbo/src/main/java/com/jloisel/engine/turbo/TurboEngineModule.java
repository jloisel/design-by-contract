package com.jloisel.engine.turbo;

import com.google.inject.PrivateModule;
import com.jloisel.engine.api.Engine;
import com.jloisel.powerband.api.PowerBand;
import com.jloisel.powerband.api.curve.HorsePower;
import com.jloisel.powerband.api.curve.Torque;

/**
 * Provides a {@link Turbo} {@link Engine}.
 * 
 * @author Jerome
 *
 */
public final class TurboEngineModule extends PrivateModule {
	static final int DEFAULT_PRESSURE = 2;

	@Override
	protected void configure() {
		bind(Engine.class).to(TurboEngine.class);
		bind(TurboPowerBand.class);
		bind(TurboHorsePower.class);
		bind(TurboTorque.class);
		
		requireBinding(PowerBand.class);
		requireBinding(HorsePower.class);
		requireBinding(Torque.class);
		
		expose(Engine.class);
	}

}
