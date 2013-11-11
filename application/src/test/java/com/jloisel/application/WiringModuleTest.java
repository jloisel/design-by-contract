package com.jloisel.application;

import static com.jloisel.application.Main.LINEAR_COEFFICIENT;
import static com.jloisel.application.Main.RPM_RANGE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.collect.Range;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.jloisel.powerband.linear.LinearCoefficientValue;

/**
 * Tests {@link WiringModule}.
 * 
 * @author Jerome
 *
 */
public class WiringModuleTest {

	@Test
	public void shouldBindCorrectly() {
		final Injector injector = Guice.createInjector(new WiringModule());
		final Injected instance = injector.getInstance(Injected.class);
		
		assertEquals(LINEAR_COEFFICIENT, instance.getCoefficient());
		assertEquals(RPM_RANGE, instance.getRange());
	}
	
	private static final class Injected {
		private final Integer coefficient;
		private final Range<Integer> range;
		
		@Inject
		Injected(@LinearCoefficientValue final Integer coefficient, final Range<Integer> range) {
			super();
			this.coefficient = coefficient;
			this.range = range;
		}
		
		Integer getCoefficient() {
			return coefficient;
		}
		
		Range<Integer> getRange() {
			return range;
		}
	}
}
