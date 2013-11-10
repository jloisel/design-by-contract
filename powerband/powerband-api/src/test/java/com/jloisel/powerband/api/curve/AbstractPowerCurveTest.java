package com.jloisel.powerband.api.curve;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;

/**
 * Tests {@link PowerCurve}.
 * 
 * @author Jerome
 *
 */
public abstract class AbstractPowerCurveTest {

	@Test
	public void shouldReturnValidValueForInputWithinRange() {
		final PowerCurve curve = newInstance();
		final Range<Integer> range = curve.range();
		final ContiguousSet<Integer> set = ContiguousSet.create(range, DiscreteDomain.integers());
		for(final Integer value : set) {
			assertNotNull(curve.apply(value));
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionWhenRPMBelowMin() {
		final PowerCurve curve = newInstance();
		final Range<Integer> range = curve.range();
		curve.apply(range.lowerEndpoint() - 1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionWhenRPMOverMax() {
		final PowerCurve curve = newInstance();
		final Range<Integer> range = curve.range();
		curve.apply(range.upperEndpoint() + 1);
	}
	
	protected abstract PowerCurve newInstance();
}
