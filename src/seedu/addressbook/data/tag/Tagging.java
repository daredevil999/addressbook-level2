package seedu.addressbook.data.tag;

/**
 * An Association class to keep track of added or deleted tags of all persons in the address book.
 * 
 */

public class Tagging {
    
    private static final String ADD_ACTION = "+ ";
    private static final String DELETE_ACTION = "- ";
    
    public static enum Action {
        ADD, REMOVE;
    }
    
    private String personName;
    private Action action;
    private Tag tag;
    
    public Tagging (Action action, String personName, Tag tag) {
        this.action = action;
        this.personName = personName;
        this.tag = tag;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (action == Action.ADD) {
            builder.append(ADD_ACTION);
        } else {
            builder.append(DELETE_ACTION);
        }
        builder.append(personName)
                .append(" ")
                .append(tag.toString());
        return builder.toString();
    }
    
}
