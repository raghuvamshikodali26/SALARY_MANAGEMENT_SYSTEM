package salary_management_system.sms_test;
import junit.framework.*;

public class TestFile extends TestCase{
	private boolean True;
	
	@Test
	@Test
	public void test() {
		boolean actual=FindEmployee.emptest("Admin", "afds");
		boolean expected=True;
		assertEquals(expected, actual);
	}
	
}