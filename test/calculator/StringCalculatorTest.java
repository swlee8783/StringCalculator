package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
	private StringCalculator cal;
	
	@BeforeEach
	public void setup() {
		cal = new StringCalculator();
	}
	
	@Test
	public void add_blank(){
		assertEquals(0, cal.add(" "));
	}
	
	@Test
	public void add_one() {
		assertEquals(1, cal.add("1"));
	}
	
	@Test
	public void add_multiple() {
		assertEquals(6, cal.add("1,2,3"));
	}
	
	@Test
	public void add_diffDelimiter(){
		assertEquals(6, cal.add("1,2:3"));
	}
	
	@Test
	public void add_customDelimiter(){
		assertEquals(6, cal.add("//;\n1;2;3"));
	}
	
	@Test
	public void add_negative(){
		assertThrows(RuntimeException.class, () -> cal.add("1,2,-3"));
	}
	
	@AfterEach
	public void tearDown() {
		System.out.println("teardown");
	}
}
