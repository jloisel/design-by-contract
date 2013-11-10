package com.jloisel.engine.turbo;

import static org.mockito.Mockito.mock;

import com.jloisel.powerband.api.curve.HorsePower;

public class TurboHorsePowerTest extends AbstractTurboTest<HorsePower> {

	@Override
	protected HorsePower mockCurve() {
		return mock(HorsePower.class);
	}
	
	@Override
	protected AbstractTurbo newInstance(final HorsePower curve) {
		return new TurboHorsePower(curve);
	}

}
