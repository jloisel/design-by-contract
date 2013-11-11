package com.jloisel.engine.turbo;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.google.inject.BindingAnnotation;

/**
 * Binds Linear increase coefficient to an {@code Integer}.
 * 
 * @author Jerome
 *
 */
@BindingAnnotation
@Retention(RUNTIME)
@Target({PARAMETER, METHOD})
public @interface TurboPressureValue {

}
