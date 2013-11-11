package com.jloisel.wheel.immutable;

import static com.jloisel.wheel.api.WheelSize.FOURTEEN;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import com.jloisel.material.api.Material;
import com.jloisel.wheel.api.AbstractWheelTest;
import com.jloisel.wheel.api.Wheel;
import com.jloisel.wheel.api.WheelSize;

/**
 * Tests {@link ImmutableWheel}.
 * 
 * @author Jerome
 *
 */
public class ImmutableWheelTest extends AbstractWheelTest {
	
	@Test
	public void shouldOverrideToString() {
		assertNotNull(newInstance(FOURTEEN, mock(Material.class)).toString());
	}
	
	@Override
	protected Wheel newInstance(final WheelSize size, final Material material) {
		return new ImmutableWheel(size, material);
	}
}
