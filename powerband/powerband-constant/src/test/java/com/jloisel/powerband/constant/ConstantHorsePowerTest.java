package com.jloisel.powerband.constant;

import com.google.common.collect.Range;

/**
 * Tests {@link ConstantHorsePower}.
 * 
 * @author Jerome
 *
 */
public class ConstantHorsePowerTest extends AbstractConstantPowerCurveTest {
	
	@Override
	protected AbstractConstantPowerCurve newInstance(final Range<Integer> range, final Integer value) {
		return new ConstantHorsePower(range, value);
	}

}
