import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPrimeNumbers {

	@Test
	public void testEvenNumber (){ 
		MyNumber n = new MyNumber();
		n.setValue(3); 
		assertEquals(-1, n.isEven());
		n.setValue(2); 
		assertEquals(0, n.isEven());
		assertEquals("2 is Even", n.printEven());
		n.setValue(15);
		assertEquals("1,3,5,15", n.printFactors());
		}





}
