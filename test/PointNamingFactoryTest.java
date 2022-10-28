import static org.junit.Assert.assertEquals;

import org.junit.Test;

import geometry_objects.points.PointNamingFactory;

public class PointNamingFactoryTest {

	
	
@Test
void updateNameTest() {
	PointNamingFactory factory = new PointNamingFactory();
	assertEquals(factory.getNumLetters(), 1);
	assertEquals(factory.getCurrName(), "A");
	assertEquals(factory.getNumLetters(), 2);
	
	
}
	
}
