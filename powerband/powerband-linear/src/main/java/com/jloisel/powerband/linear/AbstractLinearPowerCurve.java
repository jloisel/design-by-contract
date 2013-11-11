package com.jloisel.powerband.linear;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.Range;
import com.jloisel.powerband.api.curve.PowerCurve;
import com.jloisel.powerband.common.curve.AbstractPowerCurve;

/**
 * Linear {@link PowerCurve}, ouput increases linearly when RPM 
 * increases.
 * 
 * @author Jerome
 *
 */
abstract class AbstractLinearPowerCurve extends AbstractPowerCurve {
	private final Integer coefficient;
	
	/**
	 * @param range RPM range
	 * @param coefficient linear increase coefficient
	 * @throws NullPointerException when any of the input parameter is {@code null}
	 */
	protected AbstractLinearPowerCurve(final Range<Integer> range, final Integer coefficient) {
		super(range);
		this.coefficient = checkNotNull(coefficient);
	}

	@Override
	protected final Integer whenWithinRange(final Integer input) {
		return coefficient * input;
	}
}
