package com.jloisel.material.alloy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.jloisel.material.api.Material;

public class AlloyMaterialModuleTest {
	
	@Test
	public void shouldBind() {
		final Injector injector = Guice.createInjector(new AlloyMaterialModule());
		
		assertEquals(Alloy.class, injector.getInstance(Material.class).getClass());
	}
}
