package com.jloisel.powerband.constant;

import com.google.common.collect.Range;
import com.google.inject.Inject;
import com.jloisel.powerband.api.curve.HorsePower;

/**
 * Constant {@link HorsePower} over whole RPM {@link #range()}.
 * 
 * @author Jerome
 *
 */
final class ConstantHorsePower extends AbstractConstantPowerCurve implements HorsePower {
	/**
	 * @param range RPM range
	 * @param horsePower constant horse power over {@code range}
	 * @throws NullPointerException when any of the input parameters is {@code null}
	 */
	@Inject
	ConstantHorsePower(final Range<Integer> range, @HorsePowerValue final Integer horsePower) {
		super(range, horsePower);
	}
}
