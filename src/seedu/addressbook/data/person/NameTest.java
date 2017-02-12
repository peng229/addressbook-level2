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

}
