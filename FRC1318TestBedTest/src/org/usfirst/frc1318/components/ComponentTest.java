package org.usfirst.frc1318.components;

import org.junit.After;
import org.junit.Before;
import org.usfirst.frc1318.shared.KinematicData;
import org.usfirst.frc1318.shared.ReferenceData;

/**
 * Extend this class if you are writing a test for a robot component that reads or writes
 * from either of the shared data structures. This will clear any data that may have been written
 * to the data structures from other test classes, as well as your own, before each test method is run.
 * @author violette
 *
 */
public class ComponentTest {
	
	@Before@After
	public final void clearData() {
		ReferenceData.getInstance().clear();
		KinematicData.getInstance().clear();
	}

}
