package seedu.addressbook.data;

import seedu.addressbook.data.person.*;
import seedu.addressbook.data.person.UniquePersonList.*;
import seedu.addressbook.data.tag.UniqueTagList;
import seedu.addressbook.data.tag.UniqueTagList.*;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.Tagging;
import seedu.addressbook.data.tag.Tagging.Action;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;

/**
 * Represents the entire address book. Contains the data of the address book.
 *
 * Guarantees:
 *  - Every tag found in every person will also be found in the tag list.
 *  - The tags in each person point to tag objects in the master list. (== equality)
 */
public class AddressBook {

    private final UniquePersonList allPersons;
    private final UniqueTagList allTags; // can contain tags not attached to any person
    
    private final ArrayList <Tagging> tagging;

    /**
     * Creates an empty address book.
     */
    public AddressBook() {
        allPersons = new UniquePersonList();
        allTags = new UniqueTagList();
        tagging = new ArrayList<Tagging>();
    }

    /**
     * Constructs an address book with the given data.
     * Also updates the tag list with any missing tags found in any person.
     *
     * @param persons external changes to this will not affect this address book
     * @param tags external changes to this will not affect this address book
     */
    public AddressBook(UniquePersonList persons, UniqueTagList tags) {
        this (persons, tags, addExistingTags(persons));
    }

    /**
     * Constructs an address book with the given data.
     * Also updates the tag list with any missing tags found in any person.
     *
     * @param persons external changes to this will not affect this address book
     * @param tags external changes to this will not affect this address book
     */
    public AddressBook(UniquePersonList persons, UniqueTagList tags, ArrayList<Tagging> taggings) {
        this.allPersons = new UniquePersonList(persons);
        this.allTags = new UniqueTagList(tags);
        this.tagging = taggings;
        for (Person p : allPersons) {
            syncTagsWithMasterList(p);
        }
    }

    /**
     * Adds existing tags to the tagging list
     *
     * @param persons external changes to this will not affect this address book
     * @return returns ArrayList<Tagging> 
     */
    public static ArrayList<Tagging> addExistingTags(UniquePersonList persons) {
        ArrayList<Tagging> taggings = new ArrayList<Tagging>();
        for (Person p: persons ) {
            UniqueTagList individualTagList = p.getTags();
            for (Tag t: individualTagList) {
                taggings.add(new Tagging(Action.ADD, p.getName().toString(), t));
            }
        }
        return taggings;
    }

    /**
     * Ensures that every tag in this person:
     *  - exists in the master list {@link #allTags}
     *  - points to a Tag object in the master list
     */
    private void syncTagsWithMasterList(Person person) {
        final UniqueTagList personTags = person.getTags();
        allTags.mergeFrom(personTags);

        // Create map with values = tag object references in the master list
        final Map<Tag, Tag> masterTagObjects = new HashMap<>();
        for (Tag tag : allTags) {
            masterTagObjects.put(tag, tag);
        }

        // Rebuild the list of person tags using references from the master list
        final Set<Tag> commonTagReferences = new HashSet<>();
        for (Tag tag : personTags) {
            commonTagReferences.add(masterTagObjects.get(tag));
        }
        person.setTags(new UniqueTagList(commonTagReferences));
    }

    /**
     * Adds a person to the address book.
     * Also checks the new person's tags and updates {@link #allTags} with any new tags found,
     * and updates the Tag objects in the person to point to those in {@link #allTags}.
     *
     * @throws DuplicatePersonException if an equivalent person already exists.
     */
    public void addPerson(Person toAdd) throws DuplicatePersonException {
        syncTagsWithMasterList(toAdd);
        allPersons.add(toAdd);
        addPersonTag(toAdd);
    }
    
    /**
     * Adds a person's tag to the tagging list
     * 
     */
    public void addPersonTag(Person toAdd) {
        UniqueTagList individualTagList = toAdd.getTags();
        for (Tag t: individualTagList) {
            this.tagging.add(new Tagging(Action.ADD, toAdd.getName().toString(), t));
        }
    }

    /**
     * Adds a tag to the list of tags present in the address book.
     *
     * @throws DuplicateTagException if an equivalent tag already exists.
     */
    public void addTag(Tag toAdd) throws DuplicateTagException {
        allTags.add(toAdd);
    }

    /**
     * Checks if an equivalent person exists in the address book.
     */
    public boolean containsPerson(ReadOnlyPerson key) {
        return allPersons.contains(key);
    }

    /**
     * Checks if an equivalent person exists in the address book.
     */
    public boolean containsTag(Tag key) {
        return allTags.contains(key);
    }

    /**
     * Removes the equivalent person from the address book.
     *
     * @throws PersonNotFoundException if no such Person could be found.
     */
    public void removePerson(ReadOnlyPerson toRemove) throws PersonNotFoundException {
        allPersons.remove(toRemove);
        UniqueTagList tags = toRemove.getTags();
        for (Tag t : tags) {
            tagging.add(new Tagging (Action.REMOVE, toRemove.getName().toString(), t));
        }
    }

    /**
     * Removes the equivalent Tag from the address book.
     *
     * @throws TagNotFoundException if no such Tag could be found.
     */
    public void removeTag(Tag toRemove) throws TagNotFoundException {
        allTags.remove(toRemove);
    }

    /**
     * Clears all persons and tags from the address book.
     */
    public void clear() {
        allPersons.clear();
        allTags.clear();
    }
    
    /**
     * Prints all taggings and then clears all tagging list for that session.
     */
    public String exitTaggingList() {
        StringBuilder builder =  new StringBuilder();
        for (Tagging t : tagging) {
            builder.append(t.toString())
                    .append("\n");
        }
        tagging.clear();
        return builder.toString();
    }

    /**
     * Defensively copied UniquePersonList of all persons in the address book at the time of the call.
     */
    public UniquePersonList getAllPersons() {
        return new UniquePersonList(allPersons);
    }

    /**
     * Defensively copied UniqueTagList of all tags in the address book at the time of the call.
     */
    public UniqueTagList getAllTags() {
        return new UniqueTagList(allTags);
    }
}
