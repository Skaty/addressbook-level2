package seedu.addressbook.data;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;

public class Tagging {
    public enum Action {
        ADD_TAG, REMOVE_TAG
    }

    private final Person person;
    private final Tag tag;
    private final Action action;
    
    public Tagging(Person person, Action action, Tag tag) {
        this.person = person;
        this.tag = tag;
        this.action = action;
    }
    
    private static String getPrintableAction(Action tagAction) {
        switch(tagAction) {
            case ADD_TAG:
                return "+";
            case REMOVE_TAG:
                return "-";
            default:
                return "";
        }
    }
    
    @Override
    public String toString() {
        String displayAction = getPrintableAction(this.action);
        String displayName = this.person.getName().toString();
        String displayTag = "[" + tag.toString() + "]";
        return String.join(" ", displayAction, displayName, displayTag);
    }
}
