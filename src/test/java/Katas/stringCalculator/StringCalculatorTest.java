package Katas.stringCalculator;

import static org.junit.Assert.*;

import org.junit.Test;

import Katas.stringCalculator.StringCalculator;


public class StringCalculatorTest  {
	
	@Test
    public void testEmptyString() {
    	StringCalculator sc = new StringCalculator();
    	int i = -1;
		try {
			i = sc.add("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	assertEquals(0,i);
    }
    
	@Test
    public void testOneNumber() {
    	StringCalculator sc = new StringCalculator();
    	int i = -1;
		try {
			i = sc.add("1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	assertEquals(1,i);
    }
    
	@Test
    public void testTwoNumbers() {
    	StringCalculator sc = new StringCalculator();
    	int i = -1;
		try {
			i = sc.add("1,2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	assertEquals(3,i);
    }
    
	@Test
    public void testMoreNumbers() {
    	StringCalculator sc = new StringCalculator();
    	int i = -1;
		try {
			i = sc.add("1,2,3,7");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	assertEquals(13,i);
    }
    
	@Test
    public void testEndLine() {
    	StringCalculator sc = new StringCalculator();
    	int i=-1;
		try {
			i = sc.add("1\n2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	assertEquals(3,i);
    }
    
	@Test
    public void testNewDelimiter() {
    	StringCalculator sc = new StringCalculator();
    	int i = -1;
		try {
			i = sc.add("//;,1;2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(i);
    	assertEquals(3,i);
    }
    
	@Test
    public void testNewDelimiter2() {
    	StringCalculator sc = new StringCalculator();
    	int i = -1;
		try {
			i = sc.add("//;\n1;2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	assertEquals(3,i);
    }
    
    @Test (expected=NegativeNumberException.class)
    public void testNegatives() throws NegativeNumberException {
    	StringCalculator sc = new StringCalculator();
    	sc.add("1,-2,2,-1");
    }
    
    @Test 
    public void testAnyLengthTokens() {
    	StringCalculator sc = new StringCalculator();
    	int i = -1;
		try {
			i = sc.add("//[**]\n1**2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	assertEquals(3,i);
    }
    
    @Test 
    public void testAnyLengthTokens2() {
    	StringCalculator sc = new StringCalculator();
    	int i = -1;
		try {
			i = sc.add("//[**][##]\n1**2##3");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	assertEquals(6,i);
    }
}
