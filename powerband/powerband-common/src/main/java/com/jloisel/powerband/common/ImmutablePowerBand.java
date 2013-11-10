package com.jloisel.powerband.common;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.inject.Inject;
import com.jloisel.powerband.api.PowerBand;
import com.jloisel.powerband.api.curve.HorsePower;
import com.jloisel.powerband.api.curve.Torque;

/**
 * Immutable {@link PowerBand}.
 * 
 * @author Jerome
 *
 */
final class ImmutablePowerBand implements PowerBand {
	private final HorsePower horsePower;
	private final Torque torque;
	
	/**
	 * @param horsePower horse power curve
	 * @param torque torque curve
	 * @throws NullPointerException when any of the input parameter is {@code null}
	 */
	@Inject
	ImmutablePowerBand(final HorsePower horsePower, final Torque torque) {
		super();
		this.horsePower = checkNotNull(horsePower);
		this.torque = checkNotNull(torque);
	}

	@Override
	public HorsePower horsePower() {
		return horsePower;
	}

	@Override
	public Torque torque() {
		return torque;
	}

	@Override
	public String toString() {
		return "PowerBand Torque=[" + torque + "], HorsePower=[" + horsePower + "]";
	}
}
