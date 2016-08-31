package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's unit in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */

public class PostalCode {
	
	public static final String EXAMPLE = "Singapore 350443";
    public static final String MESSAGE_ADDRESS_POSTAL_CODE_CONSTRAINTS = "Postal code must be alphanumeric";
    public static final String ADDRESS_VALIDATION_REGEX = "^[a-zA-Z0-9 ]*$";
	
    private final String postalCode;
    
    public String getPostalCode() {
		return postalCode;
	}

	/**
     * Validates given address postal code.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public PostalCode(String test) throws IllegalValueException {
        if (!isValidPostalCode(test)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_POSTAL_CODE_CONSTRAINTS);
        }
        this.postalCode = test;
    }

    /**
     * Returns true if a given string is a valid person address unit.
     */
    public static boolean isValidPostalCode(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return postalCode;
    }
}
