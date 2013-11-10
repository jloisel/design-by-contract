package com.jloisel.powerband.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.jloisel.powerband.api.PowerBand;
import com.jloisel.powerband.api.curve.HorsePower;
import com.jloisel.powerband.api.curve.Torque;

/**
 * Tests {@link ImmutablePowerBandModule}.
 * 
 * @author Jerome
 *
 */
public class ConstantPowerBandModuleTest {

	private final Module module = new Module() {
		@Override
		public void configure(Binder binder) {
			binder.bind(HorsePower.class).toInstance(mock(HorsePower.class));
			binder.bind(Torque.class).toInstance(mock(Torque.class));
		}
	};
	
	@Test
	public void shouldBind() {
		final Injector injector = Guice.createInjector(new ImmutablePowerBandModule(), module);
		assertEquals(ImmutablePowerBand.class, injector.getInstance(PowerBand.class).getClass());
	}
	
	@Test
	public void shouldBindNonSingleton() {
		final Injector injector = Guice.createInjector(new ImmutablePowerBandModule(), module);
		assertNotSame(injector.getInstance(PowerBand.class), injector.getInstance(PowerBand.class));
	}
}
