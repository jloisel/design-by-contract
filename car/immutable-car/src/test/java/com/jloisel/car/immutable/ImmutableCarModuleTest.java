package com.jloisel.car.immutable;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.jloisel.car.api.Car;
import com.jloisel.engine.api.Engine;

/**
 * Tests {@link ImmutableCarModule}.
 * 
 * @author Jerome
 *
 */
public class ImmutableCarModuleTest {
	private final Engine engine = mock(Engine.class);
		
	private final Module module = new Module() {
		
		@Override
		public void configure(final Binder binder) {
			binder.bind(Engine.class).toInstance(engine);
		}
	};
	
	@Test
	public void shouldBindCorrectly() {
		final Injector injector = Guice.createInjector(new ImmutableCarModule(), module);
		assertEquals(ImmutableCar.class, injector.getInstance(Car.class).getClass());
	}
}
