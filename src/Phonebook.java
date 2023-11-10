import java.util.ArrayList;
import java.util.List;

public class Phonebook {
    private final List<Contactinfo> contacts = new ArrayList<>();

    public Phonebook() {
    }

    public void addContact(Contactinfo contact) {
            contacts.add(contact);
            System.out.println("Contact is added in phonebook");
    }

    public void deleteContact(String deleteSurname) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getSurname().equalsIgnoreCase(deleteSurname)) {
                contacts.remove(i);
                System.out.println("contact is removed from the phonebook");
                return;
            }
        }
        System.out.println("contact not found");
    }
    public void updateContactFirstname(Contactinfo contact, String newFirstname){
        contact.setFirstname(newFirstname.toLowerCase());
        System.out.println("Firstname on contact is updated");
    }
    public void updateContactSurname(Contactinfo contact, String newSurname){
        contact.setSurname(newSurname.toLowerCase());
        System.out.println("Surname on contact is updated");
    }
    public void updateContactAge(Contactinfo contact, int newAge){
        contact.setAge(newAge);
        System.out.println("Age on contact is updated");
    }
    public void updateContactPhonenumber(Contactinfo contact, String newPhonenumber){
        contact.setPhonenumber(newPhonenumber);
        System.out.println("Phonenumber on contact is updated");
    }
    public void updateContactAdress(Contactinfo contact, Adress newAdress){
        contact.setAdress(newAdress);
        System.out.println("Adress on the contact is updated");
    }

    public Contactinfo findContactBySurname(String surname) {
        for (Contactinfo contact : contacts) {
            if (contact.getSurname().equalsIgnoreCase(surname.toLowerCase())) {
                return contact;
            }
        }
        return null;
    }

    public List<Contactinfo> searchContacts(String searchOption, String searchChoice){
        List<Contactinfo> result = new ArrayList<>();
        for (Contactinfo contact: contacts) {
            switch (searchChoice.toLowerCase()) {
                case "1":
                    if(contact.getSurname().equalsIgnoreCase(searchOption.toLowerCase())){
                        result.add(contact);
                        return result;
                    }
                    break;
                case "2":
                    if(contact.getAdress().getStreetname().equalsIgnoreCase(searchOption.toLowerCase())){
                        result.add(contact);
                    }
                    break;
                case "3":
                    if(contact.getFirstname().equalsIgnoreCase(searchOption.toLowerCase())){
                        result.add(contact);
                    }
                    break;
                case "4":
                    if(contact.getFirstname().toLowerCase().contains(searchOption.toLowerCase())||
                            contact.getSurname().toLowerCase().contains(searchOption.toLowerCase()) ||
                            contact.getAdress().getCity().toLowerCase().contains(searchOption.toLowerCase())||
                            contact.getAdress().getStreetname().toLowerCase().contains(searchOption.toLowerCase())||
                            contact.getAdress().getPostcode().toLowerCase().contains(searchOption.toLowerCase())||
                            contact.getPhonenumber().contains(searchOption)){
                        result.add(contact);
                    }
                    break;
            }
        }
        if(result.isEmpty()) {
           System.out.println("\nCould not find any matches in the phonebook \nTry again");
        }
        return result;
    }

    public void printSearchResults(List<Contactinfo> results){
        for (Contactinfo contact : results) {
            System.out.println(contact);
        }
    }

    public void printPhonebook() {
        if (contacts.isEmpty()) {
            System.out.println("Phonebook is empty");
            return;
        }
        for (Contactinfo contact : contacts) {
            System.out.println(contact);
        }
    }

    }

