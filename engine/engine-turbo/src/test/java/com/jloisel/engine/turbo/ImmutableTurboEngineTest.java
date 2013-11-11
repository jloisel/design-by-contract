package com.jloisel.engine.turbo;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.Range;
import com.jloisel.engine.api.AbstractEngineTest;

@RunWith(MockitoJUnitRunner.class)
public class ImmutableTurboEngineTest extends AbstractEngineTest {
	@Mock
	private TurboPowerBand powerBand;
	@Mock
	private TurboHorsePower horsePower;
	@Mock
	private TurboTorque torque;
	
	@Before
	public void before() {
		when(horsePower.range()).thenReturn(Range.singleton(1));
		when(powerBand.horsePower()).thenReturn(horsePower);
		
		when(torque.range()).thenReturn(Range.singleton(1));
		when(powerBand.torque()).thenReturn(torque);
	}
	
	@Test
	public void shouldSetPressure() {
		final TurboEngine engine = newEngine();
		engine.setPressure(10);
	}
	
	@Override
	protected TurboEngine newEngine() {
		return new TurboEngine(powerBand);
	}

}
