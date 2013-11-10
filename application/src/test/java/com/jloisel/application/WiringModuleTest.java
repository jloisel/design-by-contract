package com.jloisel.application;

import static com.jloisel.application.Main.HORSE_POWER;
import static com.jloisel.application.Main.RPM_RANGE;
import static com.jloisel.application.Main.TORQUE;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.collect.Range;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.jloisel.powerband.constant.HorsePowerValue;
import com.jloisel.powerband.constant.TorqueValue;

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
		
		assertEquals(HORSE_POWER, instance.getHorsePowerValue());
		assertEquals(TORQUE, instance.getTorqueValue());
		assertEquals(RPM_RANGE, instance.getRange());
	}
	
	private static final class Injected {
		private final Integer horsePowerValue;
		private final Integer torqueValue;
		private final Range<Integer> range;
		
		@Inject
		Injected(
				@HorsePowerValue final Integer horsePowerValue, 
				@TorqueValue Integer torqueValue, final Range<Integer> range) {
			super();
			this.horsePowerValue = horsePowerValue;
			this.torqueValue = torqueValue;
			this.range = range;
		}
		
		Integer getHorsePowerValue() {
			return horsePowerValue;
		}
		
		Integer getTorqueValue() {
			return torqueValue;
		}
		
		Range<Integer> getRange() {
			return range;
		}
	}
}
