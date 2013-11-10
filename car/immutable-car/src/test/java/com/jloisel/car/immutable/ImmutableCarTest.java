package com.jloisel.car.immutable;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.jloisel.car.api.AbstractCarTest;
import com.jloisel.car.api.Car;
import com.jloisel.engine.api.Engine;
import com.jloisel.powerband.api.PowerBand;

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
	
	@Before
	public void before() {
		when(engine.powerBand()).thenReturn(mock(PowerBand.class));
	}
	
	@Test
	public void shouldReturnSamePowerBand() {
		assertSame(engine.powerBand(), newInstance().powerBand());
	}
	
	@Override
	protected Car newInstance() {
		return new ImmutableCar(engine);
	}

}
