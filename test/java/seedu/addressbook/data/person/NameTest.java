package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

    @Test
    public void isSimilar_similarNames() {
        try {
            final Name inputName = new Name("John Smith");
            final Name otherName = new Name("John Smith");
            assertTrue(inputName.isSimilar(otherName));
        } catch (IllegalValueException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void isSimilar_caseInsensitive() {
        try {
            final Name inputName = new Name("JoHn SmIth");
            final Name otherName = new Name("John Smith");
            assertTrue(inputName.isSimilar(otherName));
        } catch (IllegalValueException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
