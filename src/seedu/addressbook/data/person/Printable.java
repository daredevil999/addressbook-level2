package seedu.addressbook.data.person;

/**
 * An interface for concatenating a Person's details in the addressbook.
 * Implementations should guarantee: details are present and not null, field values are validated.
 */

public interface Printable {
    
    public String getPrintableString();
    public boolean isPrivate();
}
