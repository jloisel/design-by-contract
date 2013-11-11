package com.jloisel.engine.common;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.inject.Inject;
import com.jloisel.engine.api.Engine;
import com.jloisel.powerband.api.PowerBand;

/**
 * Immutable {@link Engine}.
 * 
 * @author Jerome
 *
 */
final class ImmutableEngine implements Engine {
	private final PowerBand powerBand;

	/**
	 * @param powerBand engine {@link PowerBand}
	 * @throws NullPointerException when {@code powerBand} is {@code null}
	 */
	@Inject
	ImmutableEngine(final PowerBand powerBand) {
		super();
		this.powerBand = checkNotNull(powerBand);
	}

	@Override
	public PowerBand powerBand() {
		return powerBand;
	}
}
