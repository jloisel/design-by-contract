package com.jloisel.car.api;

import static com.google.common.testing.NullPointerTester.Visibility.PACKAGE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.Iterables;
import com.google.common.testing.NullPointerTester;
import com.jloisel.body.api.Body;
import com.jloisel.powerband.api.PowerBand;
import com.jloisel.wheel.api.Wheel;

/**
 * Tests a {@link Car}.
 * 
 * @author Jerome
 *
 */
@RunWith(MockitoJUnitRunner.class)
public abstract class AbstractCarTest {
	@Mock
	private PowerBand powerBand;
	@Mock(name="frontLeft")
	private Wheel frontLeft;
	@Mock(name="frontRight")
	private Wheel frontRight;
	@Mock(name="rearLeft")
	private Wheel rearLeft;
	@Mock(name="rearRight")
	private Wheel rearRight;
	@Mock
	private Body body;	
	
	@Test
	public void shouldPassNullPointerTester() {
		new NullPointerTester().testConstructors(newInstance().getClass(), PACKAGE);
	}
	
	@Test
	public void shouldReturnPowerBand() {
		final Car car = newInstance();
		assertNotNull(car.powerBand());
	}
	
	@Test
	public void shouldReturnSamePowerBand() {
		final Car car = newInstance();
		assertEquals(car.powerBand(), car.powerBand());
	}
	
	@Test
	public void shouldReturnNonNullBody() {
		final Car car = newInstance();
		assertNotNull(car.body());
	}
	
	@Test
	public void shouldReturnSameBody() {
		final Car car = newInstance();
		assertSame(car.body(), car.body());
	}
	
	@Test
	public void shouldHaveFourWheels() {
		final Car car = newInstance();
		assertEquals(4, Iterables.size(car.wheels()));
	}
	
	@Test
	public void shouldHaveFourWheelsInWellOrder() {
		final Car car = newInstance();
		final Iterator<Wheel> wheels = car.wheels().iterator();
		assertEquals(frontLeft, wheels.next());
		assertEquals(frontRight, wheels.next());
		assertEquals(rearLeft, wheels.next());
		assertEquals(rearRight, wheels.next());
	}
	
	protected final Car newInstance() {
		return newInstance(body, powerBand, frontLeft, frontRight, rearLeft, rearRight);
	}
	
	/**
	 * @return car instance
	 */
	protected abstract Car newInstance(
			final Body body,
			final PowerBand powerBand, 
			final Wheel frontLeft, 
			final Wheel frontRight, 
			final Wheel rearLeft, 
			final Wheel rearRight);
}
