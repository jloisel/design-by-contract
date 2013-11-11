package com.jloisel.material.api;

/**
 * Something that is composed by a material.
 * 
 * @author Jerome
 *
 */
public interface Materialed {
	/**
	 * The {@link Material} it is composed of.
	 * 
	 * @return composed material
	 */
	Material madeOf();
}
