package com.jloisel.powerband.api.curve;


/**
 * This function takes as input Engine RPM, and 
 * outputs torque (Newton Meter).
 * 
 * Input RPM must be within {@link #range()}.
 * 
 * @author Jerome
 *
 */
public interface Torque extends PowerCurve {

}
