package com.jloisel.material.alloy;

import com.jloisel.material.api.AbstractMaterialTest;
import com.jloisel.material.api.Material;

public class AlloyTest extends AbstractMaterialTest {
	@Override
	protected Material newInstance() {
		return new Alloy();
	}

}
