package com.jloisel.powerband.linear;

import com.google.common.collect.Range;
import com.google.inject.Inject;
import com.jloisel.powerband.api.curve.Torque;

/**
 * Linear {@link Torque} over whole RPM {@link #range()}.
 * 
 * @author Jerome
 *
 */
final class LinearTorque extends AbstractLinearPowerCurve implements Torque {
	/**
	 * @param range RPM range
	 * @param coefficient linear coefficient
	 * @throws NullPointerException when any of the input parameters is {@code null}
	 */
	@Inject
	LinearTorque(final Range<Integer> range, @LinearCoefficientValue final Integer coefficient) {
		super(range, coefficient);
	}
}
