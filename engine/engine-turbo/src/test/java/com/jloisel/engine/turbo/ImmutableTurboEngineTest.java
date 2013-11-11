package com.jloisel.engine.turbo;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.jloisel.engine.api.AbstractEngineTest;

@RunWith(MockitoJUnitRunner.class)
public class ImmutableTurboEngineTest extends AbstractEngineTest {
	@Mock
	private TurboPowerBand powerBand;
	
	@Test
	public void shouldSetPressure() {
		final TurboEngine engine = newEngine();
		engine.setPressure(10);
		verify(powerBand).setPressure(10);
	}
	
	@Override
	protected TurboEngine newEngine() {
		return new ImmutableTurboEngine(powerBand);
	}
}
