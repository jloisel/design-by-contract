package com.jloisel.engine.turbo;

import com.google.inject.Inject;
import com.jloisel.powerband.api.curve.HorsePower;

/**
 * Not final for testing purpose.
 * 
 * @author Jerome
 *
 */
class TurboHorsePower extends AbstractTurboPowerCurve implements HorsePower {
	/**
	 * @param horsePower decorated power curve
	 * @throws NullPointerException when {@code horsePower} is {@code null}
	 */
	@Inject
	TurboHorsePower(final HorsePower horsePower) {
		super(horsePower);
	}
}
