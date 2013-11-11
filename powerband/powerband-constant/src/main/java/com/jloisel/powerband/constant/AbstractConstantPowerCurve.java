package com.jloisel.powerband.constant;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.Range;
import com.jloisel.powerband.common.curve.AbstractPowerCurve;

abstract class AbstractConstantPowerCurve extends AbstractPowerCurve {
	private final Integer value;
	
	/**
	 * @param range RPM range
	 * @param value constant power curve value
	 * @throws NullPointerException when any of the input parameter is {@code null}
	 */
	protected AbstractConstantPowerCurve(final Range<Integer> range, final Integer value) {
		super(range);
		this.value = checkNotNull(value);
	}

	@Override
	protected final Integer whenWithinRange(final Integer input) {
		return value;
	}
}
