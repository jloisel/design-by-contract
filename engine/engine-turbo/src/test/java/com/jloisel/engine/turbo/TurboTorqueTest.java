package com.jloisel.engine.turbo;

import static org.mockito.Mockito.mock;

import com.jloisel.powerband.api.curve.Torque;

public class TurboTorqueTest extends AbstractTurboTest<Torque> {

	@Override
	protected Torque mockCurve() {
		return mock(Torque.class);
	}
	
	@Override
	protected AbstractTurboPowerCurve newInstance(final Torque curve) {
		return new TurboTorque(curve);
	}

}
