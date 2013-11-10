package com.jloisel.powerband.common;

import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.jloisel.powerband.api.AbstractPowerBandTest;
import com.jloisel.powerband.api.PowerBand;
import com.jloisel.powerband.api.curve.HorsePower;
import com.jloisel.powerband.api.curve.Torque;

/**
 * Tests {@link ImmutablePowerBand}.
 * 
 * @author Jerome
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ImmutablePowerBandTest extends AbstractPowerBandTest {
	@Mock
	private HorsePower horsePower;
	@Mock
	private Torque torque;
	
	@Test
	public void shouldReturnHorsePower() {
		assertSame(horsePower, newInstance().horsePower());
	}
	
	@Test
	public void shouldReturnTorque() {
		assertSame(torque, newInstance().torque());
	}
	
	@Override
	protected PowerBand newInstance() {
		return new ImmutablePowerBand(horsePower, torque);
	}
	
	@Override
	protected Class<? extends PowerBand> clazz() {
		return ImmutablePowerBand.class;
	}
}
