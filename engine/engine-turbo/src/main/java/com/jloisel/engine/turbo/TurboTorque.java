package com.jloisel.engine.turbo;

import com.google.inject.Inject;
import com.jloisel.powerband.api.curve.Torque;

class TurboTorque extends AbstractTurbo implements Torque {
	
	@Inject
	TurboTorque(final Torque torque) {
		super(torque);
	}
}
