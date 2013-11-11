package com.jloisel.engine.turbo;

import static com.google.common.testing.NullPointerTester.Visibility.PACKAGE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Random;

import org.junit.Test;

import com.google.common.testing.NullPointerTester;

/**
 * Tests {@link Turbo}.
 * 
 * @author Jerome
 *
 */
public class TurboTest {

	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowIllegalArgument() {
		new Turbo(0);
	}
	
	@Test
	public void shouldPassNullPointerTester() {
		new NullPointerTester().testConstructors(Turbo.class, PACKAGE);
	}
	
	@Test
	public void shouldCreateInstance() {
		assertNotNull(new Turbo(1));
	}
	
	@Test
	public void shouldPressurize() {
		final int coefficient = 1 + new Random(System.currentTimeMillis()).nextInt(1000);
		assertEquals(Integer.valueOf(2 * coefficient), new Turbo(2).pressurize(coefficient));
	}
}
