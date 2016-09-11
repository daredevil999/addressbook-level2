package seedu.addressbook.common;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.parser.Parser;

public class UtilsTest {
    
    private static Set<Tag> tagSet;
    
    //To check for illegal set up with tag
    @BeforeClass
    public static void setup() {
        tagSet = new HashSet<Tag>();
        try {
            tagSet.add(new Tag ("friend"));
            tagSet.add(new Tag ("colleague"));
        } catch (IllegalValueException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test
    public void isAnyNull_singlePerson_shouldReturnTrue() {
        try {
            assertEquals(false, Utils.isAnyNull(new Person(new Name("person"), new Phone("12345", true),
                                                new Email("lol@u.nus.edu", false), new Address("311, Clementi Ave 2, #02-25", true),
                                                new UniqueTagList(tagSet))));
        } catch (IllegalValueException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void checkNull_shouldReturnTrue() {
        assertEquals(true, Utils.isAnyNull("1", "2", null));
    }
    
    @Test
    public void checkUniqueElements_twoIdenticalPersons_shouldReturnFalse() {
        try {
            ArrayList <Person> persons = new ArrayList <Person>();
            Person defaultPerson = new Person (new Name("person"), 
                                                new Phone("12345", true),
                                                new Email("lol@u.nus.edu", false), 
                                                new Address("311, Clementi Ave 2", true),
                                                new UniqueTagList(tagSet));
            persons.add(defaultPerson);
            persons.add(defaultPerson);
            assertEquals(false, Utils.elementsAreUnique(persons));
        } catch (IllegalValueException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void checkUniqueElements_twoDifferentPersons_shouldReturnTrue() {
        try {
            ArrayList <Person> persons = new ArrayList <Person>();
            Person defaultPerson = new Person (new Name("person"), 
                                                new Phone("12345", true),
                                                new Email("lol@u.nus.edu", false), 
                                                new Address("311, Clementi Ave 2", true),
                                                new UniqueTagList(tagSet));
            Person anotherDefaultPerson = new Person (new Name("person"), 
                    new Phone("123456", true),
                    new Email("lol@u.nus.edu", false), 
                    new Address("311, Clementi Ave 2", true),
                    new UniqueTagList(tagSet));
            persons.add(defaultPerson);
            persons.add(anotherDefaultPerson);
            assertEquals(true, Utils.elementsAreUnique(persons));
        } catch (IllegalValueException e) {
            e.printStackTrace();
        }
    }

}
