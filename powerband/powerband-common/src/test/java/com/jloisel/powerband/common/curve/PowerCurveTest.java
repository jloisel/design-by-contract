package com.jloisel.powerband.common.curve;

import com.google.common.collect.Range;

public class PowerCurveTest extends AbstractPowerCurveTest {

	@Override
	protected AbstractPowerCurve newInstance() {
		return newInstance(Range.closed(1000, 2000));
	}

	@Override
	protected AbstractPowerCurve newInstance(final Range<Integer> range) {
		return new AbstractPowerCurve(range) {
			@Override
			protected Integer whenWithinRange(final Integer input) {
				return input;
			}
		};
	}

}
