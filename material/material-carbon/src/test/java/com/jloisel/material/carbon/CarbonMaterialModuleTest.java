package com.jloisel.material.carbon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.jloisel.material.api.Material;

public class CarbonMaterialModuleTest {
	
	@Test
	public void shouldBind() {
		final Injector injector = Guice.createInjector(new CarbonMaterialModule());
		
		assertEquals(Carbon.class, injector.getInstance(Material.class).getClass());
	}
}
