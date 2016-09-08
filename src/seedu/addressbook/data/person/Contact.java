package seedu.addressbook.data.person;

/**
 * Represents a Person's contact type in the address book.
 */

public abstract class Contact {
    
    protected boolean isPrivate;
    protected final String value;
    
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
    public String toString() {
        return value;
    }
    

}
