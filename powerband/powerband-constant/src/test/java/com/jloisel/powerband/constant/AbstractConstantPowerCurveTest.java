package com.jloisel.powerband.constant;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.collect.Range;
import com.jloisel.powerband.common.curve.AbstractPowerCurve;
import com.jloisel.powerband.common.curve.AbstractPowerCurveTest;

public abstract class AbstractConstantPowerCurveTest extends AbstractPowerCurveTest {

	@Test
	public void shouldReturnConstantTorque() {
		final AbstractPowerCurve curve = newInstance();
		final Integer lower = curve.range().lowerEndpoint();
		assertEquals(lower, curve.apply(lower));
	}
	
	@Override
	protected final AbstractConstantPowerCurve newInstance() {
		return newInstance(Range.singleton(1));
	}
	
	@Override
	protected final AbstractConstantPowerCurve newInstance(final Range<Integer> range) {
		return newInstance(range, 1);
	}
	
	protected abstract AbstractConstantPowerCurve newInstance(final Range<Integer> range, final Integer value);
}
