package seedu.addressbook.data.person;

import java.util.Objects;
import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "311, Clementi Ave 2, #02-25, 120311";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be in the following order: [BLOCK/HOUSE NUMBER], [STREET NAME], [UNIT], [POSTAL CODE]";
    public static final String ADDRESS_VALIDATION_REGEX = "[^,]+, [^,]+, [^,]+, [^,]+";

    private boolean isPrivate;
    
    private final Block block;
    private final Street street;
    private final Unit unit;
    private final PostalCode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        String[] addressComponents = address.split(",");
        
        this.block = new Block(addressComponents[0]);
        this.street = new Street(addressComponents[1]);
        this.unit = new Unit(addressComponents[2]);
        this.postalCode = new PostalCode(addressComponents[3]);
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    public Block getBlock() {
		return block;
	}

	public Street getStreet() {
		return street;
	}

	public Unit getUnit() {
		return unit;
	}

	public PostalCode getPostalCode() {
		return postalCode;
	}

	@Override
    public String toString() {
        return String.join(",",
        		this.getBlock().toString(),
        		this.getStreet().toString(),
        		this.getUnit().toString(),
        		this.getPostalCode().toString());
    }
    
    private boolean isSameStateAs(Address other) {
        return other == this
                || (other != null
                && other.getBlock().equals(this.getBlock())
                && other.getStreet().equals(this.getStreet())
                && other.getUnit().equals(this.getUnit())
                && other.getPostalCode().equals(this.getPostalCode()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.isSameStateAs(((Address) other))); // state check
    }

    @Override
    public int hashCode() {
        return Objects.hash(block, street, unit, postalCode);
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}