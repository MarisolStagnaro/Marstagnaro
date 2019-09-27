package paquete;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrizTest {

	@Test
	public void test() {
		//int [] mat= {1,2,9,2,5,3,5,1,5};
		//int [] mat={-715827882, 0, 0, 0, 715827882, 0, 0, 0, -715827882};
		int [] mat= {1, 2, 3, 2, 3, 1, 3, 1, 2};
		Matriz m= new Matriz(mat);
		int resultadoreal=m.cruceMinimo(mat);
		assertEquals(4,resultadoreal,0);
		
	}

}
