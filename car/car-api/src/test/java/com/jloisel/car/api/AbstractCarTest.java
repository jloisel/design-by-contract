package com.jloisel.car.api;

import static com.google.common.testing.NullPointerTester.Visibility.PACKAGE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.testing.NullPointerTester;

/**
 * Tests a {@link Car}.
 * 
 * @author Jerome
 *
 */
public abstract class AbstractCarTest {

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
	public void shouldFourWheels() {
		final Car car = newInstance();
		assertEquals(4, Iterables.size(car.wheels()));
	}
	
	/**
	 * @return car instance
	 */
	protected abstract Car newInstance();
}
