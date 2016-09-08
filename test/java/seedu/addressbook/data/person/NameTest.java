package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Test;

public class NameTest {

    @Test
    public void isSimilar_similarNames() {
        final Name inputName = new Name("John Smith");
        final Name otherName = new Name("John Smith");
        assertTrue(inputName.isSimilar(otherName));
    }
}
