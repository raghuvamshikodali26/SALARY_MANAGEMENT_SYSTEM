package salary_management_system.sms_test;

import static org.junit.Assert.assertEquals;
import junit.framework.*;

public class TestFile1 extends TestCase{
	private boolean True;
//	@Test
	public void test() {
		boolean actual=FindEmployee.emptest("emp", "abcd");
		boolean expected=True;
		assertEquals(expected, actual);
	}
	
}