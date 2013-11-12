package com.jloisel.car.immutable;

import static org.mockito.Mockito.when;

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

	@Override
	protected Car newInstance(
			final Body body,
			final PowerBand powerBand, 
			final Wheel frontLeft,
			final Wheel frontRight, 
			final Wheel rearLeft, 
			final Wheel rearRight) {
		when(engine.powerBand()).thenReturn(powerBand);
		return new ImmutableCar(body, engine, frontLeft, frontRight, rearLeft, rearRight);
	}
	
	
}
