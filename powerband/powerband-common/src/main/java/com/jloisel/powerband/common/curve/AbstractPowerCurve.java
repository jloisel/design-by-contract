package com.jloisel.powerband.common.curve;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.Range;
import com.jloisel.powerband.api.curve.HorsePower;
import com.jloisel.powerband.api.curve.PowerCurve;
import com.jloisel.powerband.api.curve.Torque;

/**
 * Provides a base implementation for both {@link HorsePower} 
 * and {@link Torque}.
 * 
 * @author Jerome
 *
 */
public abstract class AbstractPowerCurve implements PowerCurve {
	private final Range<Integer> range;

	/**
	 * @param range power curve applicable RPM range
	 * @throws NullPointerException when {@code range} is {@code null}
	 */
	protected AbstractPowerCurve(final Range<Integer> range) {
		super();
		this.range = checkNotNull(range);
	}
	
	@Override
	public Range<Integer> range() {
		return range;
	}
	
	@Override
	public Integer apply(final Integer input) {
		if(input == null) {
			return null;
		}
		
		checkArgument(range().contains(input), "invalid input %s, not within range %s", input, range());
		return whenWithinRange(input);
	}
	
	/**
	 * Apply power curve {@code Function} on a non-null 
	 * input verified to be within {@link #range()}.
	 * 
	 * @param input
	 * @return
	 */
	protected abstract Integer whenWithinRange(final Integer input);
}
