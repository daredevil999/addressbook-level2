package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.*;

public class Formatter {
    
	/** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();
    private static final String DIVIDER = "===================================================";
    public String formatWelcomeMessage(String version, String storageFileInfo) {
        return formatMessage(DIVIDER, DIVIDER, MESSAGE_WELCOME, version, MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE, storageFileInfo, DIVIDER);
    }
    
    public String formatEnterCommand() {
        return LINE_PREFIX + "Enter command: ";
    }
    
    public String formatGoodbyeMessage() {
        return formatMessage(MESSAGE_GOODBYE, DIVIDER, DIVIDER);
    }
 
    public String formatInitFailedMessage() {
        return formatMessage(MESSAGE_INIT_FAILED, DIVIDER, DIVIDER);
    }
 
    public String formatPrompt(String message) {
        return LINE_PREFIX + message.replace("\n", LS + LINE_PREFIX);
    }
 
    public String formatResult(String result) {
        return formatMessage(result, DIVIDER);
    }
 
    public String formatMessage(String... messages) {
        StringBuilder builder = new StringBuilder();
        for (String m: messages) {
            builder.append(LINE_PREFIX + m.replace("\n", LS + LINE_PREFIX));
            builder.append("\n");
        }

        return builder.toString();
    }
}