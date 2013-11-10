package com.jloisel.powerband.constant;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import com.google.common.collect.Range;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.jloisel.powerband.api.PowerBand;

/**
 * Tests {@link ConstantPowerBandModule}.
 * 
 * @author Jerome
 *
 */
public class ConstantPowerbandModuleTest {

	private static final Integer HORSE_POWER = 110;
	private static final Integer TORQUE = 200;
	private static final Range<Integer> RPM_RANGE = Range.closed(1000, 6500);
	
	private final Module module = new AbstractModule() {
		
		@Override
		protected void configure() {
			bind(Integer.class).annotatedWith(HorsePowerValue.class).toInstance(HORSE_POWER);
			bind(Integer.class).annotatedWith(TorqueValue.class).toInstance(TORQUE);
		}
		
		@Provides
		@Singleton
		Range<Integer> providesRange() {
			return RPM_RANGE;
		}
	};
	
	@Test
	public void shouldBind() {
		final Injector injector = Guice.createInjector(new ConstantPowerBandModule(), module);
		final PowerBand powerBand = injector.getInstance(PowerBand.class);
		
		assertEquals(RPM_RANGE, powerBand.horsePower().range());
		
		final Random random = new Random(System.currentTimeMillis());
		assertEquals(HORSE_POWER, powerBand.horsePower().apply(1000 + random.nextInt(5500)));
		assertEquals(TORQUE, powerBand.torque().apply(1000 + random.nextInt(5500)));
	}
}
