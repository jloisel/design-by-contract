package com.jloisel.powerband.constant;

import com.google.common.collect.Range;

/**
 * Tests {@link ConstantTorque}.
 * 
 * @author Jerome
 *
 */
public class ConstantTorqueTest extends AbstractConstantPowerCurveTest {
	
	@Override
	protected AbstractConstantPowerCurve newInstance(final Range<Integer> range, final Integer value) {
		return new ConstantTorque(range, value);
	}

}
