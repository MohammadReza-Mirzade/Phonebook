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
    void person() {
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

        assertEquals("TEST", person.getName());
        assertEquals("09177777777", person.getPhone());
        assertNotNull(person.getId());
        assertFalse(person.isHidden());
        assertEquals("Name: TEST - Phone number: 09177777777", person.toString());

        try {
            person.setName("");
        } catch (Error e) {
            assertEquals(e.getMessage(), "Your name is empty.");
        }

        person.setName("TEST2");
        assertEquals("TEST2", person.getName());

        try {
            person.setPhone("0917777777");
        } catch (Error e) {
            assertEquals(e.getMessage(), "Your Phone Number Should have 11 digits and starts with 09");
        }
        assertEquals("09177777777", person.getPhone());

        try {
            person.setPhone("19177777777");
        } catch (Error e) {
            assertEquals(e.getMessage(), "Your Phone Number Should have 11 digits and starts with 09");
        }
        assertEquals("09177777777", person.getPhone());

        try {
            person.setPhone("08177777777");
        } catch (Error e) {
            assertEquals(e.getMessage(), "Your Phone Number Should have 11 digits and starts with 09");
        }
        assertEquals("09177777777", person.getPhone());

        person.setPhone("09177777766");
        assertEquals("09177777766", person.getPhone());

        person.setHidden();
        assertTrue(person.isHidden());

        person.setUnHidden();
        assertFalse(person.isHidden());
    }

    @Test
    void addContact() {
        try {
            phonebook.addContact(null);
        } catch (Error e) {
            assertEquals("Null is not valid as contact.", e.getMessage());
        }

        try {
            phonebook.addContact(new Person("Mohammad", "09177777775"));
        } catch (Error e) {
            assertEquals("This name is already exist.", e.getMessage());
        }

        phonebook.addContact(new Person("RERERE", "09177777775"));
        assertEquals(1, phonebook.getContact("RERERE"));
    }

    @Test
    void getPhoneNumber() {
        assertEquals("09177777771", phonebook.getPhoneNumber("Mohammad"));
        assertEquals("09177777774", phonebook.getPhoneNumber("Ahmad"));
        assertEquals("Contact Not Found", phonebook.getPhoneNumber("RERERE"));
    }

    @Test
    void getContact() {
        assertEquals(1, phonebook.getContact("Mohammad"));
        assertEquals(1, phonebook.getContact("Ahmad"));
        assertEquals(0, phonebook.getContact("RERERE"));
    }

    @Test
    void updateContactName() {
        assertEquals(0, phonebook.updateContactName("RERERE", "RE"));
        assertEquals(1, phonebook.updateContactName("Mohammad", "MohammadReza"));
        assertEquals(0, phonebook.getContact("Mohammad"));
        assertEquals(1, phonebook.getContact("MohammadReza"));
        try {
            phonebook.updateContactName("Ahmad", "Ali");
        } catch (Error e) {
            assertEquals("This name is already exist.", e.getMessage());
        }
        assertEquals(1, phonebook.getContact("Ahmad"));
    }

    @Test
    void updateContactPhoneNumber() {
        assertEquals(0, phonebook.updateContactName("RERERE", "09177777777"));
        try {
            assertEquals(1, phonebook.updateContactName("Mohammad", "09177777"));
        } catch (Error e) {
            assertEquals("Your Phone Number Should have 11 digits and starts with 09", e.getMessage());
        }
        assertEquals(1, phonebook.updateContactName("Mohammad", "09177777777"));
        assertEquals("09177777777", phonebook.getPhoneNumber("Mohammad"));
    }
}
