package com.jloisel.powerband.constant;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.collect.Range;
import com.jloisel.powerband.common.curve.AbstractPowerCurve;
import com.jloisel.powerband.common.curve.AbstractPowerCurveTest;

/**
 * Tests {@link ConstantTorque}.
 * 
 * @author Jerome
 *
 */
public class ConstantTorqueTest extends AbstractPowerCurveTest {

	@Test
	public void shouldReturnConstantTorque() {
		assertEquals(Integer.valueOf(2), new ConstantTorque(Range.singleton(1), 2).apply(1));
	}
	
	@Override
	protected AbstractPowerCurve newInstance() {
		return new ConstantTorque(Range.singleton(1), 1);
	}

	@Override
	protected AbstractPowerCurve newInstance(final Range<Integer> range) {
		return new ConstantTorque(range, 1);
	}

}
