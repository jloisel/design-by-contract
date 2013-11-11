package com.jloisel.powerband.constant;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.collect.Range;
import com.jloisel.powerband.common.curve.AbstractPowerCurve;
import com.jloisel.powerband.common.curve.AbstractPowerCurveTest;

/**
 * Tests {@link ConstantHorsePower}.
 * 
 * @author Jerome
 *
 */
public class ConstantHorsePowerTest extends AbstractPowerCurveTest {

	@Test
	public void shouldReturnConstantTorque() {
		assertEquals(Integer.valueOf(2), new ConstantTorque(Range.singleton(1), 2).apply(1));
	}
	
	@Override
	protected AbstractPowerCurve newInstance() {
		return newInstance(Range.singleton(1));
	}

	@Override
	protected AbstractPowerCurve newInstance(final Range<Integer> range) {
		return new ConstantHorsePower(range, 1);
	}

}
