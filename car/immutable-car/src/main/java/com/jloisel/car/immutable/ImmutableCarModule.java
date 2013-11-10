package com.jloisel.car.immutable;

import com.google.inject.PrivateModule;
import com.jloisel.car.api.Car;
import com.jloisel.engine.api.Engine;

/**
 * Provides an immutable {@link Car}.
 * 
 * @author Jerome
 *
 */
public final class ImmutableCarModule extends PrivateModule {

	@Override
	protected void configure() {
		bind(Car.class).to(ImmutableCar.class);
		requireBinding(Engine.class);
		expose(Car.class);
	}

}
