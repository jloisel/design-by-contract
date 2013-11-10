package com.jloisel.powerband.constant;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.Range;
import com.google.inject.Inject;
import com.jloisel.powerband.api.curve.Torque;
import com.jloisel.powerband.common.curve.AbstractPowerCurve;

final class ConstantTorque extends AbstractPowerCurve implements Torque {
	private final Integer torque;
	
	@Inject
	ConstantTorque(final Range<Integer> range, @TorqueValue Integer torque) {
		super(range);
		this.torque = checkNotNull(torque);
	}

	@Override
	protected Integer whenWithinRange(final Integer input) {
		return torque;
	}
}
