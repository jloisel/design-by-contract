package com.jloisel.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Range;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.jloisel.car.api.Car;
import com.jloisel.car.immutable.ImmutableCarModule;
import com.jloisel.engine.turbo.TurboEngineModule;
import com.jloisel.powerband.api.PowerBand;
import com.jloisel.powerband.constant.ConstantPowerBandModule;

/**
 * Executes the application.
 * 
 * @author Jerome
 *
 */
public final class Main {
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
	
	// N.m (Newton Meter)
	static final int TORQUE = 350;
	// HP (Horse Power)
	static final int HORSE_POWER = 200;
	// RPM (Rotation Per Minute)
	static final Range<Integer> RPM_RANGE = Range.closed(1000, 6500);

	private Main() {
		throw new IllegalAccessError();
	}
	
	/**
	 * Run this main method to see the application in action.
	 * 
	 * @param args command line arguments
	 */
	public static void main(final String[] args) {
		final Injector injector = Guice.createInjector(
			new ImmutableCarModule(), 
			new TurboEngineModule(),
			new ConstantPowerBandModule(), 
			new WiringModule()
		);

		final Car car = injector.getInstance(Car.class);
		final PowerBand powerBand = car.powerBand();

		final int rpm = 2000;
		LOGGER.info("At " + rpm + " RPM, Car outputs:");
		LOGGER.info(powerBand.horsePower().apply(rpm)+ " hp");
		LOGGER.info(powerBand.torque().apply(rpm) + " N.m");
	}
}
