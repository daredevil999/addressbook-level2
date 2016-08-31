package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's unit in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */

public class Unit {

	public static final String EXAMPLE = "#03-04";
    public static final String MESSAGE_ADDRESS_UNIT_CONSTRAINTS = "Unit address must be #xx-xx, x being integers";
    public static final String ADDRESS_VALIDATION_REGEX = "^[#-a-zA-Z0-9]*$";
	
    private final String unit;
    
    public String getUnit() {
		return unit;
	}

	/**
     * Validates given address unit.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Unit(String test) throws IllegalValueException {
        if (!isValidUnit(test)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_UNIT_CONSTRAINTS);
        }
        this.unit = test;
    }

    /**
     * Returns true if a given string is a valid person address unit.
     */
    public static boolean isValidUnit(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return unit;
    }
    
}

