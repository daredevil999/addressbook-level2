package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's contact type in the address book.
 * @throws IllegalValueException if given contact information string is invalid.
 */

public abstract class Contact {
    
    private boolean isPrivate;
    private final String value;
    
    /**
     * Constructs and validates Person's contact type in the address book.
     * @throws IllegalValueException if given contact information string is invalid.
     */
    
    protected Contact (String value, boolean isPrivate, String MESSAGE_CONTACT_CONSTRAINTS, String CONTACT_VALIDATION_REGEX)throws IllegalValueException {
        if (!isValidContact(value, CONTACT_VALIDATION_REGEX)) {
            throw new IllegalValueException(MESSAGE_CONTACT_CONSTRAINTS);
        }
        this.value = value;
        this.isPrivate = isPrivate;
    }
    
    /**
     * Checks if a given string is a valid person contact against corresponding regex.
     */
    private boolean isValidContact(String test, String CONTACT_VALIDATION_REGEX) {
        return test.matches(CONTACT_VALIDATION_REGEX);
    }
    
    @Override
    public int hashCode() {
        return value.hashCode();
    }
    
    public boolean isPrivate() {
        return isPrivate;
    }
    
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }
    
    @Override
    public String toString() {
        return value;
    }
    
}
