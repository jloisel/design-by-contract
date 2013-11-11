package com.jloisel.engine.immutable;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.google.common.collect.Range;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.jloisel.engine.api.Engine;
import com.jloisel.powerband.linear.LinearCoefficientValue;

/**
 * Tests {@link AtmosphericEngineModule}.
 * 
 * @author Jerome
 *
 */
public class AtmosphericEngineModuleTest {

	private final Module module = new Module() {
		
		@Override
		public void configure(final Binder binder) {
			binder.bind(Key.get(Integer.class, LinearCoefficientValue.class)).toInstance(1);
		}
		
		@Provides
		Range<Integer> providesRPMRange() {
			return Range.closed(1000, 6500);
		}
	};
	
	@Test
	public void shouldBindCorrectly() {
		final Injector injector = Guice.createInjector(new AtmosphericEngineModule(), module);
		assertNotNull(injector.getInstance(Engine.class));
	}
}
