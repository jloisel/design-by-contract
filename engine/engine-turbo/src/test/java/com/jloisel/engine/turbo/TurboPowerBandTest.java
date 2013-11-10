package com.jloisel.engine.turbo;

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
	
	@Override
	protected PowerBand newInstance() {
		return new TurboPowerBand(horsePower, torque);
	}

	@Override
	protected Class<? extends PowerBand> clazz() {
		return TurboPowerBand.class;
	}

}
