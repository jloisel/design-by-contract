package com.jloisel.wheel.api;

import static com.google.common.testing.NullPointerTester.Visibility.PACKAGE;
import static com.jloisel.wheel.api.WheelSize.FOURTEEN;
import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.testing.NullPointerTester;
import com.jloisel.material.api.AbstractMaterialedTest;
import com.jloisel.material.api.Material;
import com.jloisel.material.api.Materialed;

/**
 * Tests {@link Wheel}.
 * 
 * @author Jerome
 *
 */
@RunWith(MockitoJUnitRunner.class)
public abstract class AbstractWheelTest extends AbstractMaterialedTest {
	@Mock
	private Material material;
	
	@Test
	public void shouldPassNullPointerTester() {
		new NullPointerTester()
		.setDefault(WheelSize.class, FOURTEEN)
		.setDefault(Material.class, material)
		.testConstructors(newInstance(FOURTEEN, material).getClass(), PACKAGE);
	}
	
	@Test
	public void shouldReturnSameWheelSize() {
		for(final WheelSize size : WheelSize.values()) {
			final Wheel wheel = newInstance(size, material);
			assertSame(size, wheel.size());
		}
	}
	
	@Test
	public void shouldReturnSameMaterial() {
		final Wheel wheel = newInstance(FOURTEEN, material);
		assertSame(material, wheel.madeOf());
	}
	
	@Override
	protected final Materialed newInstance() {
		return newInstance(FOURTEEN, material);
	}
	
	protected abstract Wheel newInstance(final WheelSize size, final Material material);
}
