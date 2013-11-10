package com.jloisel.engine.api;

import static com.google.common.testing.NullPointerTester.Visibility.PACKAGE;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.google.common.testing.NullPointerTester;

/**
 * Tests {@link Engine}.
 * 
 * @author Jerome
 *
 */
public abstract class AbstractEngineTest {

	@Test
	public void shouldPassNullPointerTester() {
		new NullPointerTester().testConstructors(newEngine().getClass(), PACKAGE);
	}
	
	@Test
	public void shouldReturnNonNullPowerBand() {
		assertNotNull(newEngine().powerBand());
	}
	
	protected abstract Engine newEngine();
}
