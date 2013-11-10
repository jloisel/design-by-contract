package com.jloisel.engine.immutable;
import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.jloisel.engine.api.AbstractEngineTest;
import com.jloisel.engine.api.Engine;
import com.jloisel.engine.immutable.AtmosphericEngine;
import com.jloisel.powerband.api.PowerBand;

/**
 * Tests {@link AtmosphericEngine}.
 * 
 * @author Jerome
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AtmosphericEngineTest extends AbstractEngineTest {
	@Mock
	private PowerBand powerBand;
	
	@Test
	public void shouldReturnSamePowerBand() {
		assertSame(powerBand, newEngine().powerBand());
	}
	
	@Override
	protected Engine newEngine() {
		return new AtmosphericEngine(powerBand);
	}
	
}
