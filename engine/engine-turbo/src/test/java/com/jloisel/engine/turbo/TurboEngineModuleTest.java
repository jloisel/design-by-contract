package com.jloisel.engine.turbo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.google.common.collect.Range;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.jloisel.engine.api.Engine;
import com.jloisel.powerband.api.PowerBand;
import com.jloisel.powerband.api.curve.HorsePower;
import com.jloisel.powerband.api.curve.Torque;

/**
 * Tests {@link TurboEngineModule}.
 * 
 * @author Jerome
 *
 */
public class TurboEngineModuleTest {
	private final Module module = new Module() {
		
		@Override
		public void configure(final Binder binder) {
			binder.bind(PowerBand.class).toInstance(mock(PowerBand.class));

			final HorsePower horsePower = mock(HorsePower.class);
			when(horsePower.range()).thenReturn(Range.singleton(1));
			binder.bind(HorsePower.class).toInstance(horsePower);
			
			final Torque torque = mock(Torque.class);
			when(torque.range()).thenReturn(Range.singleton(1));
			binder.bind(Torque.class).toInstance(torque);
		}
	};
	
	@Test
	public void shouldBindCorrectly() {
		final Injector injector = Guice.createInjector(new TurboEngineModule(), module);
		assertEquals(TurboEngine.class, injector.getInstance(Engine.class).getClass());
	}
}
