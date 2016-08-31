package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    private static final int ADDRESS_INDEX_QUANTITY = 4;
	private static final int ADDRESS_POSTAL_CODE_INDEX = 3;
	private static final int ADDRESS_UNIT_INDEX = 2;
	private static final int ADDRESS_STREET_INDEX = 1;
	private static final int ADDRESS_BLOCK_INDEX = 0;
	public static final String EXAMPLE = "123, Travistock Avenue 4, #03-03, Singapore 350443";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Address format: BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

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
        this.isPrivate = isPrivate;
        extractAddressComponents(address);
        this.value = address;
    }

    /**
     * Extracts address components from the given address
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public void extractAddressComponents(String address) throws IllegalValueException {
    	String[] addressComponents = new String[ADDRESS_INDEX_QUANTITY]; 
        addressComponents = address.split(",");
        if (!isValidAddressComponents(addressComponents.length)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
    	block = new Block(addressComponents[ADDRESS_BLOCK_INDEX].trim());
    	street = new Street(addressComponents[ADDRESS_STREET_INDEX].trim());
    	unit = new Unit(addressComponents[ADDRESS_UNIT_INDEX].trim());
    	postalCode = new PostalCode(addressComponents[ADDRESS_POSTAL_CODE_INDEX].trim());
    }

    public boolean isValidAddressComponents (int numberComponents) {
    	return numberComponents == 4;
    }
    
    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}