package seedu.addressbook.ui;

import java.util.List;

/**
 * Formatter class that allows decoration of strings to be displayed to user
 */
public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";


    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";

    /**
     * Returns true if the user input line is a comment line.
     *
     * @param rawInputLine full raw user input line.
     * @return true if input line is a comment.
     */
	public static boolean isCommentLine(String rawInputLine) {
        return rawInputLine.trim().matches(COMMENT_LINE_FORMAT_REGEX);
    }
    
    /**
     * Retrieve the current divider
     * @return the current divider, stored in DIVIDER variable
     */
	public static String getDivider() {
		return DIVIDER;
	}

	/**
     * Retrieve the current line prefix
     * @return the current line prefix
     */
	public static String getLinePrefix() {
		return LINE_PREFIX;
	}
	
	/** Formats a list of strings as a viewable indexed list. */
    public static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
    
    /**
	 * Prepends the line prefix to a String
	 * @param line the line to format
	 * @return a String that has the line prefix prepended
	 */
    public static String prependLinePrefix(String line) {
    	return LINE_PREFIX + line;
    }
	
	/**
	 * Formats a String such that it can be displayed to the user 
	 * @param line the line to format
	 * @return a String that is formatted for display
	 */
	public static String formatLine(String line) {
		return prependLinePrefix(line.replace("\n", LS + LINE_PREFIX));
	}
}
