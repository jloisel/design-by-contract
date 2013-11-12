package com.jloisel.engine.turbo;

import com.google.common.annotations.VisibleForTesting;
import com.google.inject.Inject;
import com.google.inject.Key;
import com.google.inject.PrivateModule;
import com.google.inject.Provides;
import com.jloisel.engine.api.Engine;
import com.jloisel.engine.immutable.AtmosphericEngineModule;
import com.jloisel.powerband.linear.LinearCoefficientValue;

/**
 * <p>Provides a {@link Turbo} {@link Engine}.
 * <p>Requires {@link TurboPressureValue}, {@link TurboLinearCoefficientValue} and 
 * RPM {@code Range}.
 * 
 * @author Jerome
 *
 */
public final class TurboEngineModule extends PrivateModule {
	@VisibleForTesting
	static final int DEFAULT_PRESSURE = 2;

	@Override
	protected void configure() {
		install(new AtmosphericEngineModule());
		bind(Turbo.class);
		
		requireBinding(Key.get(Integer.class, TurboPressureValue.class));
		requireBinding(Key.get(Integer.class, TurboLinearCoefficientValue.class));
		
		expose(Engine.class);
	}

	@Provides
	@Inject
	@LinearCoefficientValue
	static Integer providesLinearCoefficient(
			final Turbo turbo, 
			@TurboLinearCoefficientValue final Integer coefficient) {
		return turbo.pressurize(coefficient);
	}
}
