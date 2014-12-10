package com.talosdigital.kata.stringCalculator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.talosdigital.kata.stringCalculator.NegativeNumberException;
import com.talosdigital.kata.stringCalculator.StringCalculator;

public class StringCalculatorTest {

	@Test
	public void testEmptyString() throws NegativeNumberException {
		StringCalculator sc = new StringCalculator();
		int i = -1;
		i = sc.add("");
		assertEquals(0, i);
	}

	@Test
	public void testOneNumber() throws NegativeNumberException {
		StringCalculator sc = new StringCalculator();
		int i = -1;
		i = sc.add("1");
		assertEquals(1, i);
	}

	@Test
	public void testTwoNumbers() throws NegativeNumberException {
		StringCalculator sc = new StringCalculator();
		int i = -1;
		i = sc.add("1,2");
		assertEquals(3, i);
	}

	@Test
	public void testMoreNumbers() throws NegativeNumberException {
		StringCalculator sc = new StringCalculator();
		int i = -1;
		i = sc.add("1,2,3,7");
		assertEquals(13, i);
	}

	@Test
	public void testEndLine() throws NegativeNumberException {
		StringCalculator sc = new StringCalculator();
		int i = -1;
		i = sc.add("1\n2");
		assertEquals(3, i);
	}

	@Test
	public void testNewDelimiter() throws NegativeNumberException {
		StringCalculator sc = new StringCalculator();
		int i = -1;
		i = sc.add("//;,1;2");
		assertEquals(3, i);
	}

	@Test
	public void testNewDelimiter2() throws NegativeNumberException {
		StringCalculator sc = new StringCalculator();
		int i = -1;
		i = sc.add("//;\n1;2");
		assertEquals(3, i);
	}

	@Test
	public void testNegatives() {
		StringCalculator sc = new StringCalculator();
		try {
			sc.add("1,-2,2,-1");
		} catch (NegativeNumberException e) {
			// TODO Auto-generated catch block
			assertEquals("Negatives not allowed: -2, -1",e.getMessage());
		}
	}

	@Test
	public void testAnyLengthTokens() throws NegativeNumberException {
		StringCalculator sc = new StringCalculator();
		int i = -1;
		i = sc.add("//[**]\n1**2");
		assertEquals(3, i);
	}

	@Test
	public void testAnyLengthTokens2() throws NegativeNumberException {
		StringCalculator sc = new StringCalculator();
		int i = -1;
		i = sc.add("//[**][##]\n1**2##3");
		assertEquals(6, i);
	}
}
