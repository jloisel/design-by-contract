package com.jloisel.engine.turbo;

import com.google.inject.Inject;
import com.jloisel.powerband.api.curve.Torque;

/**
 * Not final for testing purpose.
 * 
 * @author Jerome
 *
 */
class TurboTorque extends AbstractTurboPowerCurve implements Torque {
	/**
	 * @param torque decorated torque curve
	 * @throws NullPointerException when {@code torque} is {@code null}
	 */
	@Inject
	TurboTorque(final Torque torque) {
		super(torque);
	}
}
