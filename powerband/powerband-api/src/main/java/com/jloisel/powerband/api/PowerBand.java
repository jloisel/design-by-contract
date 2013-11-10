package com.jloisel.powerband.api;

import com.jloisel.powerband.api.curve.HorsePower;
import com.jloisel.powerband.api.curve.Torque;


/**
 * The power band of an engine or electric motor refers 
 * to the range of operating speeds under which the engine 
 * or motor is able to operate efficiently.
 * 
 * @author Jerome
 *
 */
public interface PowerBand {
	
	/**
	 * See {@link HorsePower} for more information.
	 * 
	 * @return horse power curve
	 */
	HorsePower horsePower();
	
	/**
	 * See {@link Torque} for more information.
	 *  
	 * @return Torque curve
	 */
	Torque torque();
}
