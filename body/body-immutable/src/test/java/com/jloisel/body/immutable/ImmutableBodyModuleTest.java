package com.jloisel.body.immutable;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.jloisel.body.api.Body;
import com.jloisel.material.api.Material;

public class ImmutableBodyModuleTest {

	private final Material material = mock(Material.class);
	
	private final Module module = new AbstractModule() {
		@Override
		protected void configure() {
			bind(Material.class).toInstance(material);
		}
	};
	
	@Test
	public void shouldBind() {
		final Injector injector = Guice.createInjector(new ImmutableBodyModule(), module);
		
		final Body body = injector.getInstance(Body.class);
		assertEquals(ImmutableBody.class, body.getClass());
		assertEquals(material, body.madeOf());
	}
}
