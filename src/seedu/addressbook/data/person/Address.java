package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, #09-123, S123456";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final String COMMA = ",";

    public final String value;
    private boolean isPrivate;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    
    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        String[] processAddress = trimmedAddress.split(",");
        block = new Block(processAddress[0].trim());
        street = new Street(processAddress[1].trim());
        unit = new Unit(processAddress[2].trim());
        postalCode = new PostalCode(processAddress[3].trim());
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = trimmedAddress;
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return block.getblockNumber() + COMMA + street.getStreetName() 
        + COMMA + unit.getUnitNumber() + COMMA + postalCode.getPostalCodeNumber() ;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}

class Block {
	private String blockNumber;
	
	public Block(String value) {
		this.blockNumber = value;
	}
	
	public String getblockNumber() {
		return this.blockNumber;
	}
}

class Street {
	private String streetName;
	
	public Street(String value) {
		this.streetName = value;
	}
	
	public String getStreetName() {
		return this.streetName;
	}
}

class Unit {
	private String unitNumber;
	
	public Unit(String value) {
		this.unitNumber = value;
	}
	
	public String getUnitNumber() {
		return this.unitNumber;
	}
}

class PostalCode {
	private String postalCodeNumber;
	
	public PostalCode(String value) {
		this.postalCodeNumber = value;
	}
	
	public String getPostalCodeNumber() {
		return this.postalCodeNumber;
	}
}


