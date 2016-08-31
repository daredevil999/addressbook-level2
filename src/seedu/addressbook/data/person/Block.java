package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's Block number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */

public class Block {
	public static final String EXAMPLE = "123";
    public static final String MESSAGE_ADDRESS_BLOCK_CONSTRAINTS = "Block number must be in integers.";
    public static final String ADDRESS_VALIDATION_REGEX = "\\d+";
    
    private final String block;

    public String getBlock() {
		return block;
	}

	/**
     * Validates given address block number.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Block(String test) throws IllegalValueException {
        if (!isValidBlock(test)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_BLOCK_CONSTRAINTS);
        }
        this.block = test;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidBlock(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return block;
    }
    
    

}
