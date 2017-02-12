package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

	@Test
	public void testSameName() throws IllegalValueException {
		Name first = new Name("Avery");
		Name second = new Name("Avery");
		assertTrue(first.isSimilar(second));
		assertTrue(second.isSimilar(first));
	}

}
