package com.jloisel.car.immutable;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.jloisel.body.api.Body;
import com.jloisel.car.api.Car;
import com.jloisel.engine.api.Engine;
import com.jloisel.powerband.api.PowerBand;
import com.jloisel.wheel.api.Wheel;

final class ImmutableCar implements Car {
	private final Body body;
	private final Iterable<Wheel> wheels;
	private final Engine engine;
	
	@Inject
	ImmutableCar(
			final Body body,
			final Engine engine, 
			final Wheel frontLeft, 
			final Wheel frontRight, 
			final Wheel rearLeft, 
			final Wheel rearRight) {
		this.body = checkNotNull(body);
		this.engine = checkNotNull(engine);
		this.wheels = ImmutableList.of(
			frontLeft, 
			frontRight, 
			rearLeft, 
			rearRight
		);
	}

	@Override
	public Body body() {
		return body;
	}
	
	@Override
	public Iterable<Wheel> wheels() {
		return wheels;
	}
	
	@Override
	public PowerBand powerBand() {
		return engine.powerBand();
	}
}
