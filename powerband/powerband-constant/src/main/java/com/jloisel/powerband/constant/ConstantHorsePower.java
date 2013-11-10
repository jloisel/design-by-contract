package com.jloisel.powerband.constant;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.Range;
import com.google.inject.Inject;
import com.jloisel.powerband.api.curve.HorsePower;
import com.jloisel.powerband.common.curve.AbstractPowerCurve;

final class ConstantHorsePower extends AbstractPowerCurve implements HorsePower {
	private final Integer horsePower;
	
	@Inject
	ConstantHorsePower(final Range<Integer> range, @HorsePowerValue final Integer horsePower) {
		super(range);
		this.horsePower = checkNotNull(horsePower);
	}

	@Override
	protected Integer whenWithinRange(final Integer input) {
		return horsePower;
	}
}
