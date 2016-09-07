package seedu.addressbook.data.person;

public abstract class Contact {
    public final String value;
    private boolean isPrivate;
    
    public Contact(String value, boolean isPrivate) {
    	this.isPrivate = isPrivate;
    	this.value = value;
    }
    
    public Contact() {
    	this.value = "";
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
