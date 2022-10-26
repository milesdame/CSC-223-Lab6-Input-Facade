import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractMap;

import input.InputFacade;
import input.components.FigureNode;
import input.visitor.UnparseVisitor;

import org.junit.jupiter.api.Test;

class InputFacadeTest {

	@Test
	void test() {
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

}
