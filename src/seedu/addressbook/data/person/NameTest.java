package seedu.addressbook.data.person;

import static org.junit.Assert.*;


import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {
	Name first;
	Name second;

	@Test
	public void testSameName() throws IllegalValueException {
		try {
			first = new Name("Avery");
			second = new Name("Avery");
		} catch(IllegalValueException ie) {
			throw new IllegalValueException("test names should be valid");
		}
			assertTrue(first.isSimilar(second));
			assertTrue(second.isSimilar(first));
	}	
	
	
	@Test
	public void testDifferentCaseName() throws IllegalValueException {
		try {
			first = new Name("Avery");
			second = new Name("AVeRy");
		} catch(IllegalValueException ie) {
			throw new IllegalValueException("test names should be valid");
		}	
		assertTrue(first.isSimilar(second));
		assertTrue(second.isSimilar(first));
	}
	
	@Test
	public void testSubsetName() throws IllegalValueException {
		try {	//true test case
			first = new Name("Avery Bradley");
			second = new Name("AveRy");	
		} catch(IllegalValueException ie) {
			throw new IllegalValueException("test names should be valid");
		}
		assertTrue(first.isSimilar(second));
		assertTrue(second.isSimilar(first));
		
		try {	//false test case
			first = new Name("Avery Bradley");
			second = new Name("Charles Barkley");	
		} catch(IllegalValueException ie) {
			throw new IllegalValueException("test names should be valid");
		}
		assertFalse(first.isSimilar(second));
		assertFalse(second.isSimilar(first));
	}

}
