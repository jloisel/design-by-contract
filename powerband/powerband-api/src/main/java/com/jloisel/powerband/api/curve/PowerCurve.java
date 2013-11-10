package com.jloisel.powerband.api.curve;

import com.google.common.base.Function;
import com.google.common.collect.Range;

/**
 * A power curve returns a given power for an input RPM (Rotation Per Minute).
 *  
 * @author Jerome
 *
 */
public interface PowerCurve extends Function<Integer, Integer> {

	/**
	 * Valid input RPM range.
	 * 
	 * @return power curve max input RPM
	 */
	Range<Integer> range();
	
	/**
	 * Input RPM must be within {@link #range()}.
	 *  
	 * @throws IllegalArgumentException when input RPM outside {@link #range()}
	 */
	@Override
	public Integer apply(Integer input);
}
