package com.jloisel.powerband.linear;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.collect.Range;
import com.jloisel.powerband.common.curve.AbstractPowerCurve;
import com.jloisel.powerband.common.curve.AbstractPowerCurveTest;

public abstract class AbstractLinearPowerCurveTest extends AbstractPowerCurveTest {
	protected final Integer coefficient = 2;
	
	@Test
	public void shouldReturnConstantTorque() {
		final AbstractPowerCurve curve = newInstance();
		final Integer lower = curve.range().lowerEndpoint();
		assertEquals(Integer.valueOf(coefficient * lower), curve.apply(lower));
	}
	
	@Override
	protected AbstractLinearPowerCurve newInstance() {
		return newInstance(Range.singleton(1));
	}
	
	@Override
	protected AbstractLinearPowerCurve newInstance(final Range<Integer> range) {
		return newInstance(range, coefficient);
	}
	
	protected abstract AbstractLinearPowerCurve newInstance(final Range<Integer> range, final Integer coefficient);
}
