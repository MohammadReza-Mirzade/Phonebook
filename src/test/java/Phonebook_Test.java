import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * writing unit tests for each method of classes
 * If you have no idea about how to write unit tests, you can search the internet or check your first assignment
 * After each unit test you've written, please commit the changes and push to your repo

 * Hint: Your test coverage should be 100%
 * Attention:  We would check your commits and it will affect your score
 */
public class Phonebook_Test {
    Phonebook phonebook;

    @BeforeEach
    void init() {
        phonebook = new Phonebook();
        Person person1 = new Person("Mohammad", "09177777771");
        Person person2 = new Person("Ali", "09177777772");
        Person person3 = new Person("Reza", "09177777773");
        Person person4 = new Person("Ahmad", "09177777774");
        phonebook.addContact(person1);
        phonebook.addContact(person2);
        phonebook.addContact(person3);
        phonebook.addContact(person4);
    }

    @Test
    void personConstructor() {
        Person person = null;
        try {
            person = new Person("MRM", "0917747777");
        } catch (Error e) {
            assertEquals(e.getMessage(), "Your Phone Number Should have 11 digits and starts with 09");
        }
        assertNull(person);

        try {
            person = new Person("MRM", "19177477777");
        } catch (Error e) {
            assertEquals(e.getMessage(), "Your Phone Number Should have 11 digits and starts with 09");
        }
        assertNull(person);

        try {
            person = new Person("MRM", "0817747777");
        } catch (Error e) {
            assertEquals(e.getMessage(), "Your Phone Number Should have 11 digits and starts with 09");
        }
        assertNull(person);

        try {
            person = new Person("", "0917747777");
        } catch (Error e) {
            assertEquals(e.getMessage(), "Your name is empty.");
        }
        assertNull(person);

        person = new Person("TEST", "09177777777");
        assertNotEquals(null, person);
    }

    @Test
    void addContact() {
        try {
            phonebook.addContact(null);
        } catch (Error e) {
            assertEquals(e.getMessage(), "Null is not valid as contact.");
        }

        try {
            phonebook.addContact(new Person("Mohammad", "09177777775"));
        } catch (Error e) {
            assertEquals(e.getMessage(), "This name is already exist.");
        }

        phonebook.addContact(new Person("RERERE", "09177777775"));
        assertEquals(phonebook.getContact("RERERE"), 1);
    }

    @Test
    void getPhoneNumber() {
        assertEquals(phonebook.getPhoneNumber("Mohammad"), "09177777771");
        assertEquals(phonebook.getPhoneNumber("Ahmad"), "09177777774");
        assertEquals(phonebook.getPhoneNumber("RERERE"), "Contact Not Found");
    }

    @Test
    void getContact() {
        assertEquals(phonebook.getContact("Mohammad"), 1);
        assertEquals(phonebook.getContact("Ahmad"), 1);
        assertEquals(phonebook.getContact("RERERE"), 0);
    }

    @Test
    void updateContactName() {
        assertEquals(phonebook.updateContactName("RERERE", "RE"), 0);
        assertEquals(phonebook.updateContactName("Mohammad", "MohammadReza"), 1);
        assertEquals(phonebook.getContact("Mohammad"), 0);
        assertEquals(phonebook.getContact("MohammadReza"), 1);
    }
}
