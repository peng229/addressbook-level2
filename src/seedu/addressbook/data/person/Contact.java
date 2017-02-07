package seedu.addressbook.data.person;
import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a contact in the address book. Parent class of Email, Phone, Address
 * Guarantees: immutable; is Valid as declared in {@link #isValidAddress(String)}
 * 
 *
 */
public class Contact {
	public final String value;
	private boolean isPrivate;
	
	/**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
    */
	
	public Contact(String content, boolean isPrivate, String validContactRegex, String invalidContactMsg) throws IllegalValueException{
		
		String trimmedContent = content.trim();
		if (!isValidValue(trimmedContent, validContactRegex)) {
			throw new IllegalValueException(invalidContactMsg);
		}
		this.value = trimmedContent;
		this.isPrivate = isPrivate;
	}
	
	
	public static boolean isValidValue(String test, String validContactRegex) {
		return test.matches(validContactRegex);
	}
	
	@Override
	public String toString() {
		return value;
	}
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
