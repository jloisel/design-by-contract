package com.jloisel.engine.immutable;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.inject.Inject;
import com.jloisel.engine.api.Engine;
import com.jloisel.powerband.api.PowerBand;

/**
 * Conventional Atmospheric {@link Engine} with 
 * an unmodifiable {@link PowerBand}.
 * 
 * @author Jerome
 *
 */
final class AtmosphericEngine implements Engine {
	private final PowerBand powerBand;

	/**
	 * @param powerBand engine {@link PowerBand}
	 * @throws NullPointerException when {@code powerBand} is {@code null}
	 */
	@Inject
	AtmosphericEngine(final PowerBand powerBand) {
		super();
		this.powerBand = checkNotNull(powerBand);
	}

	@Override
	public PowerBand powerBand() {
		return powerBand;
	}
}
