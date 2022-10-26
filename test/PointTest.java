import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import geometry_objects.points.Point;

class PointTest {
	
	Point _point0 = new Point(1 ,1);
	Point _point1 = new Point("point1", 1 , 1);
	Point _point2 = new Point(3 ,3);
	Point _point3 = new Point("point3", 3 , 3);
	
	

	@Test
	void testGetX() {
		
		assertEquals(1 , _point0.getX());
		
		assertEquals(1 , _point1.getX());
		
		assertEquals(3 , _point2.getX());
		
		assertEquals(3 , _point3.getX());
	}
	
	@Test
	void testGetY() {
		fail("Not yet implemented");
	}
	
	
	@Test
	void testGetName() {
		fail("Not yet implemented");
	}
	
	
	
	@Test
	void testIsGenerated() {
		fail("Not yet implemented");
	}
	
	
	
	@Test
	void testIsUnnamed() {
		fail("Not yet implemented");
	}
	
	
	
	@Test
	void testHashCode() {
		fail("Not yet implemented");
	}
	
	@Test
	void testLexiconGraphicOrdering() {
		fail("Not yet implemented");
	}
	
	
	@Test
	void testCompareTo() {
		fail("Not yet implemented");
	}
	
	
	

}
