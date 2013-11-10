package com.jloisel.engine.turbo;

import com.google.inject.Inject;
import com.jloisel.powerband.api.curve.HorsePower;

class TurboHorsePower extends AbstractTurbo implements HorsePower {
	
	@Inject
	TurboHorsePower(final HorsePower horsePower) {
		super(horsePower);
	}
}
