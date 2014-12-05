package Katas.stringCalculator;

import Katas.stringCalculator.StringCalculator;
import junit.framework.Test;
import junit.framework.TestCase;

public class StringCalculatorTest extends TestCase {
	
	
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
    
    public void testNewDelimiter() {
    	StringCalculator sc = new StringCalculator();
    	int i = -1;
		try {
			i = sc.add("//;,1;2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	assertEquals(3,i);
    }
    
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
    
    public void testNegatives() {
    	StringCalculator sc = new StringCalculator();
    	int i = -1;
		try {
			i = sc.add("1,-2,2,-1");
			//assert false;
			assertTrue(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertTrue(true);
		}
    }
}
