package com.jloisel.car.immutable;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.inject.Inject;
import com.jloisel.car.api.Car;
import com.jloisel.engine.api.Engine;
import com.jloisel.powerband.api.PowerBand;

final class ImmutableCar implements Car {
	private final Engine engine;
	
	@Inject
	ImmutableCar(final Engine engine) {
		this.engine = checkNotNull(engine);
	}

	@Override
	public PowerBand powerBand() {
		return engine.powerBand();
	}
	
	@Override
	public String toString() {
		return "Car Engine=[" + engine + "]";
	}
}
