package com.jloisel.engine.immutable;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.jloisel.engine.api.Engine;
import com.jloisel.engine.immutable.AtmosphericEngine;
import com.jloisel.engine.immutable.AtmosphericEngineModule;
import com.jloisel.powerband.api.PowerBand;

/**
 * Tests {@link AtmosphericEngineModule}.
 * 
 * @author Jerome
 *
 */
public class AtmosphericEngineModuleTest {

	private final PowerBand powerBand = mock(PowerBand.class);
		
	private final Module module = new Module() {
		
		@Override
		public void configure(final Binder binder) {
			binder.bind(PowerBand.class).toInstance(powerBand);
		}
	};
	
	@Test
	public void shouldBindCorrectly() {
		final Injector injector = Guice.createInjector(new AtmosphericEngineModule(), module);
		assertEquals(AtmosphericEngine.class, injector.getInstance(Engine.class).getClass());
	}
}
