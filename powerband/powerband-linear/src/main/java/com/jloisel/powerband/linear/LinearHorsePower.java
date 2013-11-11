package com.jloisel.powerband.linear;

import com.google.common.collect.Range;
import com.google.inject.Inject;
import com.jloisel.powerband.api.curve.HorsePower;

/**
 * Linear {@link HorsePower} over whole RPM {@link #range()}.
 * 
 * @author Jerome
 *
 */
final class LinearHorsePower extends AbstractLinearPowerCurve implements HorsePower {
	/**
	 * @param range RPM range
	 * @param coefficient linear coefficient
	 * @throws NullPointerException when any of the input parameters is {@code null}
	 */
	@Inject
	LinearHorsePower(final Range<Integer> range, @LinearCoefficientValue final Integer coefficient) {
		super(range, coefficient);
	}
}
