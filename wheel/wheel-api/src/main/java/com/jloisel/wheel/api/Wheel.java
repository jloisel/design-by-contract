package com.jloisel.wheel.api;

import com.jloisel.material.api.Materialed;

/**
 * A wheel is a circular component that is intended to rotate on an axial bearing.
 * 
 * @author Jerome
 *
 */
public interface Wheel extends Materialed {
	/**
	 * @return wheel size in inches. Example: 19"
	 */
	WheelSize size();
}
