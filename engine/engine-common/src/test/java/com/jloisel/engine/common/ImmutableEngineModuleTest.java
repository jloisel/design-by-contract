package com.jloisel.engine.common;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.jloisel.engine.api.Engine;
import com.jloisel.powerband.api.PowerBand;

/**
 * Tests {@link ImmutableEngineModule}.
 * 
 * @author Jerome
 *
 */
public class ImmutableEngineModuleTest {

	private final PowerBand powerBand = mock(PowerBand.class);
		
	private final Module module = new Module() {
		
		@Override
		public void configure(final Binder binder) {
			binder.bind(PowerBand.class).toInstance(powerBand);
		}
	};
	
	@Test
	public void shouldBindCorrectly() {
		final Injector injector = Guice.createInjector(new ImmutableEngineModule(), module);
		assertEquals(ImmutableEngine.class, injector.getInstance(Engine.class).getClass());
	}
}
