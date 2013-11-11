package com.jloisel.application;

import static com.jloisel.application.Main.LINEAR_COEFFICIENT;
import static com.jloisel.application.Main.RPM_RANGE;
import static com.jloisel.wheel.api.WheelSize.NINETEEN;

import com.google.common.collect.Range;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.jloisel.car.api.Car;
import com.jloisel.powerband.linear.LinearCoefficientValue;
import com.jloisel.wheel.api.WheelSize;

/**
 * Powers a {@link Car} with an 200HP / 350N.m engine over 1000->6500 RPM range.
 * 
 * @author Jerome
 *
 */
final class WiringModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(Integer.class).annotatedWith(LinearCoefficientValue.class).toInstance(LINEAR_COEFFICIENT);
		bind(WheelSize.class).toInstance(NINETEEN);
	}

	@Provides
	@Singleton
	Range<Integer> providesRPMRange() {
		return RPM_RANGE;
	}
}