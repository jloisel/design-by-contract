package com.jloisel.powerband.common.curve;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import com.google.common.collect.Range;


/**
 * Tests {@link AbstractPowerCurve} implementations.
 * 
 * @author Jerome
 *
 */
public abstract class AbstractPowerCurveTest extends com.jloisel.powerband.api.curve.AbstractPowerCurveTest {

	@Test
	public void shouldReturnSameRange() {
		final AbstractPowerCurve curve = newInstance();
		assertSame(curve.range(), curve.range());
	}
	
	@Test
	public void shouldReturnNull() {
		final AbstractPowerCurve curve = newInstance();
		assertNull(curve.apply(null));
	}
	
	@Test
	public void shouldApply() {
		final AbstractPowerCurve curve = newInstance(Range.singleton(1));
		
		final Integer value = Integer.valueOf(1);
		
		assertNotNull(curve.apply(value));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentExceptionOnApply() {
		final AbstractPowerCurve curve = newInstance(Range.singleton(2));
		
		final Integer value = Integer.valueOf(1);
		curve.apply(value);
	}
	
	@Override
	protected abstract AbstractPowerCurve newInstance();
	
	protected abstract AbstractPowerCurve newInstance(final Range<Integer> range);
}
