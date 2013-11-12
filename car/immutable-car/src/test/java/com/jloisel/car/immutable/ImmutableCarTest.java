package com.jloisel.car.immutable;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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
	
	@Override
	protected Car newInstance() {
		return new ImmutableCar(body, engine, wheel, wheel, wheel, wheel);
	}

}
