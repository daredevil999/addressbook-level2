package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's street in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */

public class Street {

	public static final String EXAMPLE = "Tavistock Avenue";
    public static final String MESSAGE_ADDRESS_STREET_CONSTRAINTS = "Street address must be alphanumeric";
    public static final String ADDRESS_VALIDATION_REGEX = "^[a-zA-Z0-9 ]*$";
	
    private final String street;
    
    public String getStreet() {
		return street;
	}

	/**
     * Validates given address street.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Street(String test) throws IllegalValueException {
        if (!isValidStreet(test)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_STREET_CONSTRAINTS);
        }
        this.street = test;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidStreet(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return street;
    }
    
}
