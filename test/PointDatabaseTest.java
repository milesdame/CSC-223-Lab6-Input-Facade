import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import geometry_objects.points.Point;
import geometry_objects.points.PointDatabase;
import geometry_objects.points.PointNamingFactory;

class PointDatabaseTest {

	
	PointDatabase _pointDatabase = new PointDatabase();
	
	
	Point _point0 = new Point(0 ,0);
	Point _point1NoName = new Point(1 ,1);
	Point _point1 = new Point("point1", 1 , 1);
	Point _point2NoName = new Point(2 ,2);
	Point _point2 = new Point("point2", 2 , 2);
	Point _point3NoName = new Point(3 ,3);
	Point _point3 = new Point("point3", 3 , 3);
	Point _nullPoint = new Point("null" , -1 , -1);
	
	
	
	@Test
	void testSize() {
		//test on an emtpy set
		assertEquals(0 , _pointDatabase.size());
		
		//add elements to the database
		_pointDatabase.put("point0", 0, 0);
		assertEquals(1 , _pointDatabase.size());
		
		_pointDatabase.put("point1", 1, 1);
		assertEquals(2 , _pointDatabase.size());
		
		_pointDatabase.put("point2", 2, 2);
		assertEquals(3 , _pointDatabase.size());
		
		//add elements that already exist and the size shouldnt change
		_pointDatabase.put("point2", 2, 2);
		assertEquals(3 , _pointDatabase.size());
	}
/*
	@Test
	void testPut() {
		fail("Not yet implemented");
	}
	@Test
	void testGetNameXY() {
		fail("Not yet implemented");
	}
	
	@Test
	void testGetPointName() {
		fail("Not yet implemented");
	}
	
	
	@Test
	void testGetPoint() {
		fail("Not yet implemented");
	}
	
	
	@Test
	void testGetPointXY() {
		fail("Not yet implemented");
	}
	*/
	
	
}
