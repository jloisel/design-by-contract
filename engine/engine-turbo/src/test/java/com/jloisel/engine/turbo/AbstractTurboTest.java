package com.jloisel.engine.turbo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.google.common.collect.Range;
import com.jloisel.powerband.api.curve.PowerCurve;
import com.jloisel.powerband.common.curve.AbstractPowerCurveTest;

/**
 * Tests {@link AbstractTurbo}.
 * 
 * @author Jerome
 *
 */
public abstract class AbstractTurboTest<T extends PowerCurve> extends AbstractPowerCurveTest {
	private T curve;
	
	@Before
	public void before() {
		curve = mockCurve();
		final ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
		when(curve.apply(captor.capture())).thenAnswer(new Answer<Integer>() {
			@Override
			public Integer answer(InvocationOnMock invocation) throws Throwable {
				return captor.getValue();
			}
		});
		when(curve.range()).thenReturn(Range.closed(1000, 2000));
	}
	
	@Test
	public void shouldTakeIntoAccountTurboPressureInPowerCurve() {
		final AbstractTurbo turbo = newInstance(curve);
		final Integer pressure = 2;
		final Integer rpm = 1500;
		turbo.setPressure(pressure);
		
		final Integer expected = pressure * curve.apply(rpm);
		assertEquals(expected, turbo.apply(rpm));
	}
	
	@Override
	protected final AbstractTurbo newInstance() {
		return newInstance(curve);
	}
	
	@Override
	protected final AbstractTurbo newInstance(final Range<Integer> range) {
		when(curve.range()).thenReturn(range);
		return newInstance(curve);
	}
	
	protected abstract T mockCurve();
	
	protected abstract AbstractTurbo newInstance(final T curve);
}
