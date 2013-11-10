package com.jloisel.application;

import static com.jloisel.application.Main.HORSE_POWER;
import static com.jloisel.application.Main.RPM_RANGE;
import static com.jloisel.application.Main.TORQUE;

import com.google.common.collect.Range;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.jloisel.car.api.Car;
import com.jloisel.powerband.constant.HorsePowerValue;
import com.jloisel.powerband.constant.TorqueValue;

/**
 * Powers a {@link Car} with an 200HP / 350N.m engine over 1000->6500 RPM range.
 * 
 * @author Jerome
 *
 */
final class WiringModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(Integer.class).annotatedWith(HorsePowerValue.class).toInstance(HORSE_POWER);
		bind(Integer.class).annotatedWith(TorqueValue.class).toInstance(TORQUE);
	}

	@Provides
	@Singleton
	Range<Integer> providesRPMRange() {
		return RPM_RANGE;
	}
}