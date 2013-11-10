package com.jloisel.powerband.api;

import static com.google.common.testing.NullPointerTester.Visibility.PACKAGE;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.google.common.testing.NullPointerTester;

/**
 * Tests {@link PowerBand}.
 * 
 * @author Jerome
 *
 */
public abstract class AbstractPowerBandTest {

	@Test
	public void shouldPassNullPointerTester() {
		newNullPointerTester().testConstructors(clazz(), PACKAGE);
	}

	protected NullPointerTester newNullPointerTester() {
		return new NullPointerTester();
	}
	
	@Test
	public void shouldReturnHorsePowerCurve() {
		final PowerBand powerband = newInstance();
		assertNotNull(powerband.horsePower());
	}
	
	@Test
	public void shouldReturnTorqueCurve() {
		final PowerBand powerband = newInstance();
		assertNotNull(powerband.torque());
	}
	
	/**
	 * @return new {@link PowerBand} instance
	 */
	protected abstract PowerBand newInstance();
	
	/**
	 * @return tested {@link PowerBand} implementation class.
	 */
	protected abstract Class<? extends PowerBand> clazz();
}
