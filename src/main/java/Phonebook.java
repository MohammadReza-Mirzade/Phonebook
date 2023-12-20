import java.util.ArrayList;
import java.util.Objects;

public class Phonebook {
    private final ArrayList<Person> contacts;

    public Phonebook() {
        this.contacts = new ArrayList<>();
    }

    /**
     * A Simple function to add a new contact
     * @param contact is the Person that we created and just adding it
     */
    public void addContact(Person contact){
        if (contact == null) throw new Error("Null is not valid as contact.");
        if (this.getContact(contact.getName()) == 1) throw new Error("This name is already exist.");
        contacts.add(contact);
    }

    /**
     * A Method to find a specific user's phone number by entering him/her name
     * @param name is the name of our contact
     * @return  is the phone number or an error (happens when we didn't find contact)
     */
    public String getPhoneNumber(String name){
        for (Person contact : contacts) {
            if(Objects.equals(contact.getName(), name))
                return contact.getPhone();
        }
        return "Contact Not Found";
    }

    /**
     * @param name is The name of the contact who we are looking for
     * if we found the contact who we were looking for, we show the information
     * @return 1 if we found contact and 0 if we couldn't find it
    */
    public int getContact(String name){
        for (Person contact : contacts) {
            if (Objects.equals(contact.getName(), name)) {
                System.out.println(contact);
                return 1;
            }
        }
        return 0;
    }

    /**
     * A simple function to update our contact name
     * @param name is the name of the contact who we want to change
     * @param newName is the new name of that conract
     * @return 1 if changing was successful and 0 if it missed
     */
    public int updateContactName(String name, String newName){
        if (getContact(newName) == 1) throw new Error("This name is already exist.");
        if (newName.trim().isEmpty() || newName.trim().isBlank()) throw new Error("Your name is empty.");
        for (Person contact : contacts) {
            if (Objects.equals(contact.getName(), name)) {
                contact.setName(newName);
                return 1;
            }
        }
        return 0;
    }
    /**
     * A simple function to update our contact name
     * @param name is the name of the contact who we want to change
     * @param newPhone is the new phone number of that contact
     * @return 1 if changing was successful and 0 if it missed
     */
    public int updateContactPhoneNumber(String name, String newPhone){
        for (Person contact : contacts) {
            if (Objects.equals(contact.getName(), name)) {
                contact.setPhone(newPhone);
                return 1;
            }
        }
        return 0;
    }

    /**
     * A function to delete a specific contact from phonebook
     * @param name is the name of that contact
     * @return 1 if deleting was successful and 0 if it wasn't
     */
    public int deleteContact(String name){
        for (Person contact : contacts) {
            if(Objects.equals(contact.getName(), name)){
                contacts.remove(contact);
                return 1;
            }
        }
        return 0;
    }

    /**
     * A method to get all of our contacts in once
     * @return our List of contacts
     */
    public ArrayList<Person> getAllContacts(){
        return contacts;
    }

    /**
     * As a security part of this phonebook, we created this function
     * here we can hide all contacts at once
     */
    public void setAllContactsHidden(){
        for (Person contact : contacts) {
            if(contact == null)
                return;
            contact.setHidden();
        }
    }
    /**
     * As a security part of this phonebook, we created this function
     * here we can make all contacts unhidden at once
     */
    public void setAllContactsUnHidden(){
        for (Person contact : contacts){
            if(contact == null)
                return;
            contact.setUnHidden();
        }
    }
}
