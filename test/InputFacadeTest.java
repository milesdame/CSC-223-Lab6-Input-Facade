import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractMap;

import input.InputFacade;
import input.components.FigureNode;
import input.visitor.UnparseVisitor;

import org.junit.jupiter.api.Test;

class InputFacadeTest {

//Extract Figure Tests
	
	@Test
	void pointTest() {
		FigureNode figNode = InputFacade.extractFigure("jsonfiles/point.json");
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor();
		
		unparser.visitFigureNode(figNode, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		
		String expected = "Figure \n"
				+ "{\n"
				+ "    Description : \"A single point\"\n"
				+ "    Points:\n"
				+ "    {\n"
				+ "        Point(A)(0.0, 0.0)\n"
				+ "    }\n"
				+ "    Segments:\n"
				+ "    {\n"
				+ "    }\n"
				+ "}\n";
		
		assertEquals(expected, sb.toString());
	}
	
	@Test
	void SingleLineSegmentTest() {
		FigureNode figNode = InputFacade.extractFigure("jsonfiles/lineseg.json");
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor();
		
		unparser.visitFigureNode(figNode, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		
		String expected = "Figure \n"
				+ "{\n"
				+ "    Description : \"One line segment consisting of two points on y-axis.\"\n"
				+ "    Points:\n"
				+ "    {\n"
				+ "        Point(A)(0.0, 0.0)\n"
				+ "        Point(B)(0.0, 1.0)\n"
				+ "    }\n"
				+ "    Segments:\n"
				+ "    {\n"
				+ "        A : B  \n"
				+ "    }\n"
				+ "}\n";
		
		assertEquals(expected, sb.toString());
	}
	
	@Test
	void TriangleSegmentTest() {
		FigureNode figNode = InputFacade.extractFigure("jsonfiles/single_triangle.json");
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor();
		
		unparser.visitFigureNode(figNode, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		
		String expected = "Figure \n"
				+ "{\n"
				+ "    Description : \"Right Triangle in the first quadrant.\"\n"
				+ "    Points:\n"
				+ "    {\n"
				+ "        Point(A)(0.0, 0.0)\n"
				+ "        Point(B)(1.0, 1.0)\n"
				+ "        Point(C)(1.0, 0.0)\n"
				+ "    }\n"
				+ "    Segments:\n"
				+ "    {\n"
				+ "        A : B  C  \n"
				+ "        B : C  \n"
				+ "    }\n"
				+ "}\n";
		
		assertEquals(expected, sb.toString());
	}
	
	@Test
	void SquareSegmentTest() {
		FigureNode figNode = InputFacade.extractFigure("jsonfiles/square.json");
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor();
		
		unparser.visitFigureNode(figNode, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		
		String expected = "Figure \n"
				+ "{\n"
				+ "    Description : \"Square.\"\n"
				+ "    Points:\n"
				+ "    {\n"
				+ "        Point(A)(0.0, 0.0)\n"
				+ "        Point(B)(0.0, 6.0)\n"
				+ "        Point(C)(6.0, 0.0)\n"
				+ "        Point(D)(6.0, 6.0)\n"
				+ "    }\n"
				+ "    Segments:\n"
				+ "    {\n"
				+ "        A : B  C  \n"
				+ "        B : D  \n"
				+ "        C : D  \n"
				+ "    }\n"
				+ "}\n";
		
		assertEquals(expected, sb.toString());
	}
	
	@Test
	void Collinear_line_segmentTest() {
		FigureNode figNode = InputFacade.extractFigure("jsonfiles/collinear_line_segments.json");
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor();
		
		unparser.visitFigureNode(figNode, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		
		String expected = "Figure \n"
				+ "{\n"
				+ "    Description : \"A seqeunce of collinear line segments mimicking one line with 6 points.\"\n"
				+ "    Points:\n"
				+ "    {\n"
				+ "        Point(A)(0.0, 0.0)\n"
				+ "        Point(B)(4.0, 0.0)\n"
				+ "        Point(C)(9.0, 0.0)\n"
				+ "        Point(D)(11.0, 0.0)\n"
				+ "        Point(E)(16.0, 0.0)\n"
				+ "        Point(F)(26.0, 0.0)\n"
				+ "    }\n"
				+ "    Segments:\n"
				+ "    {\n"
				+ "        A : B  \n"
				+ "        B : C  \n"
				+ "        C : D  \n"
				+ "        D : E  \n"
				+ "        E : F  \n"
				+ "    }\n"
				+ "}\n";
		
		assertEquals(expected, sb.toString());
	}
	
	@Test
	void crossing_symmetric_triangleTest() {
		FigureNode figNode = InputFacade.extractFigure("jsonfiles/crossing_symmetric_triangle.json");
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor();
		
		unparser.visitFigureNode(figNode, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		
		String expected = "Figure \n"
				+ "{\n"
				+ "    Description : \"Crossing symmetric triangle construction.\"\n"
				+ "    Points:\n"
				+ "    {\n"
				+ "        Point(A)(3.0, 6.0)\n"
				+ "        Point(B)(2.0, 4.0)\n"
				+ "        Point(C)(4.0, 4.0)\n"
				+ "        Point(D)(0.0, 0.0)\n"
				+ "        Point(E)(6.0, 0.0)\n"
				+ "    }\n"
				+ "    Segments:\n"
				+ "    {\n"
				+ "        A : B  C  \n"
				+ "        B : C  D  E  \n"
				+ "        C : D  E  \n"
				+ "        D : E  \n"
				+ "    }\n"
				+ "}\n";
		
		assertEquals(expected, sb.toString());
	}
	
	@Test
	void fully_connected_irregular_polygonTest() {
		FigureNode figNode = InputFacade.extractFigure("jsonfiles/fully_connected_irregular_polygon.json");
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor();
		
		unparser.visitFigureNode(figNode, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		
		String expected = "Figure \n"
				+ "{\n"
				+ "    Description : \"Irregular pentagon in which each vertex is connected to each other.\"\n"
				+ "    Points:\n"
				+ "    {\n"
				+ "        Point(A)(0.0, 0.0)\n"
				+ "        Point(B)(4.0, 0.0)\n"
				+ "        Point(C)(6.0, 3.0)\n"
				+ "        Point(D)(3.0, 7.0)\n"
				+ "        Point(E)(-2.0, 4.0)\n"
				+ "    }\n"
				+ "    Segments:\n"
				+ "    {\n"
				+ "        A : B  C  D  E  \n"
				+ "        B : C  D  E  \n"
				+ "        C : D  E  \n"
				+ "        D : E  \n"
				+ "    }\n"
				+ "}\n";
		
		assertEquals(expected, sb.toString());
	}
	
	@Test
	void snakeTest() {
		FigureNode figNode = InputFacade.extractFigure("jsonfiles/snake.json");
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor();
		
		unparser.visitFigureNode(figNode, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		
		String expected = "Figure \n"
				+ "{\n"
				+ "    Description : \"Three triangles glued by vertex in a row\"\n"
				+ "    Points:\n"
				+ "    {\n"
				+ "        Point(A)(0.0, 0.0)\n"
				+ "        Point(B)(0.0, 1.0)\n"
				+ "        Point(C)(1.0, 0.0)\n"
				+ "        Point(D)(2.0, 0.0)\n"
				+ "        Point(E)(2.0, 1.0)\n"
				+ "        Point(F)(3.0, 1.0)\n"
				+ "        Point(G)(3.0, 0.0)\n"
				+ "    }\n"
				+ "    Segments:\n"
				+ "    {\n"
				+ "        A : B  C  \n"
				+ "        B : C  \n"
				+ "        C : D  E  \n"
				+ "        D : E  \n"
				+ "        E : F  G  \n"
				+ "        F : G  \n"
				+ "    }\n"
				+ "}\n";
		
		assertEquals(expected, sb.toString());
	}
	
	@Test
	void Tri_QuadTest() {
		FigureNode figNode = InputFacade.extractFigure("jsonfiles/Tri_Quad.json");
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor();
		
		unparser.visitFigureNode(figNode, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		
		String expected = "Figure \n"
				+ "{\n"
				+ "    Description : \"Tri Quad Shape.\"\n"
				+ "    Points:\n"
				+ "    {\n"
				+ "        Point(A)(4.0, 0.0)\n"
				+ "        Point(B)(8.0, 0.0)\n"
				+ "        Point(C)(4.0, 5.0)\n"
				+ "        Point(D)(8.0, 5.0)\n"
				+ "        Point(E)(0.0, 10.0)\n"
				+ "        Point(F)(12.0, 10.0)\n"
				+ "        Point(G)(4.0, 12.0)\n"
				+ "        Point(H)(8.0, 12.0)\n"
				+ "        Point(I)(6.0, 10.0)\n"
				+ "    }\n"
				+ "    Segments:\n"
				+ "    {\n"
				+ "        A : B  C  \n"
				+ "        B : D  \n"
				+ "        C : D  E  I  \n"
				+ "        D : F  I  \n"
				+ "        E : G  \n"
				+ "        F : H  \n"
				+ "        G : I  \n"
				+ "        H : I  \n"
				+ "    }\n"
				+ "}\n";
		
		assertEquals(expected, sb.toString());
	}
	

}
