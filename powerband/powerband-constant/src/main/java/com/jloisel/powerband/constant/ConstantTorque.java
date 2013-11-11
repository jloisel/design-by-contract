package com.jloisel.powerband.constant;

import com.google.common.collect.Range;
import com.google.inject.Inject;
import com.jloisel.powerband.api.curve.Torque;

/**
 * Constant {@link Torque} over whole RPM {@link #range()}.
 * 
 * @author Jerome
 *
 */
final class ConstantTorque extends AbstractConstantPowerCurve implements Torque {
	/**
	 * @param range RPM range
	 * @param torque constant torque over {@code range}
	 * @throws NullPointerException when any of the input parameters is {@code null}
	 */
	@Inject
	ConstantTorque(final Range<Integer> range, @TorqueValue final Integer torque) {
		super(range, torque);
	}
}
