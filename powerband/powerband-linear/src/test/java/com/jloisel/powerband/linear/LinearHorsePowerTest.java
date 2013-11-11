package com.jloisel.powerband.linear;

import com.google.common.collect.Range;

/**
 * Tests {@link ConstantHorsePower}.
 * 
 * @author Jerome
 *
 */
public class LinearHorsePowerTest extends AbstractLinearPowerCurveTest {
	
	@Override
	protected AbstractLinearPowerCurve newInstance(final Range<Integer> range,
			final Integer coefficient) {
		return new LinearHorsePower(range, coefficient);
	}

}
