package seedu.addressbook.data.person;

/**
 * Represents a Person's contact type in the address book.
 */

public abstract class Contact {
    
    private boolean isPrivate;
    private final String value;
    
    protected Contact (String value, boolean isPrivate) {
        this.value = value;
        this.isPrivate = isPrivate;
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
