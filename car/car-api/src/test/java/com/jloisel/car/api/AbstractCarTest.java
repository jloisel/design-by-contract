package com.jloisel.car.api;

import static com.google.common.testing.NullPointerTester.Visibility.PACKAGE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

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
	
	/**
	 * @return car instance
	 */
	protected abstract Car newInstance();
}
