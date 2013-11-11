package com.jloisel.car.immutable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.ImmutableList;
import com.jloisel.body.api.Body;
import com.jloisel.car.api.AbstractCarTest;
import com.jloisel.car.api.Car;
import com.jloisel.engine.api.Engine;
import com.jloisel.powerband.api.PowerBand;
import com.jloisel.wheel.api.Wheel;

/**
 * Tests {@link ImmutableCar}.
 * 
 * @author Jerome
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ImmutableCarTest extends AbstractCarTest {
	@Mock
	private Engine engine;
	@Mock
	private Wheel wheel;
	@Mock
	private Body body;
	
	@Before
	public void before() {
		when(engine.powerBand()).thenReturn(mock(PowerBand.class));
	}
	
	@Test
	public void shouldReturnSamePowerBand() {
		assertSame(engine.powerBand(), newInstance().powerBand());
	}
	
	@Test
	public void shouldReturnSameWheels() {
		assertEquals(ImmutableList.of(wheel, wheel, wheel, wheel), newInstance().wheels());
	}
	
	@Override
	protected Car newInstance() {
		return new ImmutableCar(body, engine, wheel, wheel, wheel, wheel);
	}

}
