package com.jloisel.engine.electric;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.google.common.collect.Range;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.jloisel.engine.api.Engine;
import com.jloisel.powerband.constant.HorsePowerValue;
import com.jloisel.powerband.constant.TorqueValue;

/**
 * Tests {@link ElectricEngineModule}.
 * 
 * @author Jerome
 *
 */
public class ElectricEngineModuleTest {
	private final Module module = new Module() {
		
		@Override
		public void configure(final Binder binder) {
			binder.bind(Integer.class).annotatedWith(HorsePowerValue.class).toInstance(110);
			binder.bind(Integer.class).annotatedWith(TorqueValue.class).toInstance(350);
		}
		
		@Provides
		@Singleton
		protected Range<Integer> providesRPMRange() {
			return Range.closed(1000, 6500);
		}
	};
	
	@Test
	public void shouldBindCorrectly() {
		final Injector injector = Guice.createInjector(new ElectricEngineModule(), module);
		assertNotNull(injector.getInstance(Engine.class).getClass());
	}
}
