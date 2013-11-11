package com.jloisel.material.api;

import static com.google.common.testing.NullPointerTester.Visibility.PACKAGE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.testing.NullPointerTester;

public abstract class AbstractMaterialTest {

	@Test
	public void shouldPassNPETester() {
		new NullPointerTester().testConstructors(newInstance().getClass(), PACKAGE);
	}
	

	@Test
	public void shouldPassToStringTest() {
		final Material instance = newInstance();
		assertEquals(instance.getClass().getSimpleName(), instance.toString());
	}
	
	protected abstract Material newInstance();
}
