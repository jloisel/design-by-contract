package com.jloisel.engine.turbo;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.testing.NullPointerTester;
import com.jloisel.powerband.api.AbstractPowerBandTest;
import com.jloisel.powerband.api.PowerBand;

@RunWith(MockitoJUnitRunner.class)
public class TurboPowerBandTest extends AbstractPowerBandTest {
	@Mock
	private TurboHorsePower horsePower;
	@Mock
	private TurboTorque torque;
	
	@Override
	protected NullPointerTester newNullPointerTester() {
		return super.newNullPointerTester()
				.setDefault(TurboHorsePower.class, horsePower)
				.setDefault(TurboTorque.class, torque);
	}
	
	@Test
	public void shouldSetPressureOnBothHorsePowerPAndTorque() {
		final TurboPowerBand powerBand = newInstance();
		powerBand.setPressure(10);
		verify(horsePower).setPressure(10);
		verify(torque).setPressure(10);
	}
	
	@Override
	protected TurboPowerBand newInstance() {
		return new TurboPowerBand(horsePower, torque);
	}

	@Override
	protected Class<? extends PowerBand> clazz() {
		return TurboPowerBand.class;
	}

}
