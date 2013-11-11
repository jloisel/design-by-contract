package com.jloisel.engine.turbo;

import static java.lang.Integer.valueOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Random;

import org.junit.Test;

import com.google.common.collect.Range;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.jloisel.engine.api.Engine;
import com.jloisel.powerband.api.PowerBand;

/**
 * Tests {@link TurboEngineModule}.
 * 
 * @author Jerome
 *
 */
public class TurboEngineModuleTest {
	private static final int MIN_RPM = 1000;
	private static final int MAX_RPM = 6500;
	private static final Integer LINEAR_COEFFICIENT = 2;
	private static final Integer TURBO_PRESSURE = 2;
	
	private final Module module = new Module() {
		
		@Override
		public void configure(final Binder binder) {
			binder.bind(Key.get(Integer.class, TurboLinearCoefficientValue.class)).toInstance(LINEAR_COEFFICIENT);
			binder.bind(Key.get(Integer.class, TurboPressureValue.class)).toInstance(TURBO_PRESSURE);
		}
		
		@Provides
		Range<Integer> providesRPMRange() {
			return Range.closed(MIN_RPM, MAX_RPM);
		}
	};
	
	@Test
	public void shouldBindCorrectly() {
		final Injector injector = Guice.createInjector(new TurboEngineModule(), module);
		final Engine engine = injector.getInstance(Engine.class);
		assertNotNull(engine);
		
		final int rpm = MIN_RPM + new Random(System.currentTimeMillis()).nextInt(MAX_RPM - MIN_RPM);
		final PowerBand powerBand = engine.powerBand();
		assertEquals(valueOf(rpm * LINEAR_COEFFICIENT * TURBO_PRESSURE), powerBand.horsePower().apply(rpm));
		assertEquals(valueOf(rpm * LINEAR_COEFFICIENT * TURBO_PRESSURE), powerBand.torque().apply(rpm));
	}
}
