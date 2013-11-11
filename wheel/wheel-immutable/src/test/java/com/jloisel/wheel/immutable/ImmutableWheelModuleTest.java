package com.jloisel.wheel.immutable;

import static com.jloisel.wheel.api.WheelSize.FOURTEEN;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.jloisel.material.api.Material;
import com.jloisel.wheel.api.Wheel;
import com.jloisel.wheel.api.WheelSize;

public class ImmutableWheelModuleTest {

	private final Material material = mock(Material.class);
	
	private final Module module = new AbstractModule() {
		@Override
		protected void configure() {
			bind(WheelSize.class).toInstance(WheelSize.FOURTEEN);
			bind(Material.class).toInstance(material);
		}
	};
	
	@Test
	public void shouldBind() {
		final Injector injector = Guice.createInjector(new ImmutableWheelModule(), module);
		
		final Wheel wheel = injector.getInstance(Wheel.class);
		assertEquals(ImmutableWheel.class, wheel.getClass());
		assertEquals(FOURTEEN, wheel.size());
		assertEquals(material, wheel.madeOf());
	}
}
